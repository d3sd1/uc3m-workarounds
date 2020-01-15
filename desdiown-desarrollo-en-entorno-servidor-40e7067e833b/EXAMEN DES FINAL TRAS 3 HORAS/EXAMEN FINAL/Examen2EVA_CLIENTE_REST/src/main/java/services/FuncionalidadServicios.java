package services;

import Exceptions.ApiErrorException;
import Exceptions.ApiInvalidQueryException;
import Exceptions.ApiKeyInvalidException;
import Exceptions.ApiRateLimitException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import modelo.User;
import utils.Api;

public class FuncionalidadServicios {
    private final String API_URL_USUARIOS = "/usuarios?name={name}&password={password}";
    private final String API_URL_USUARIOS_DELETE = "/usuarios/{name}/{force}";
    public List<User> listUsuarios() 
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api();
        String json = api.get(API_URL_USUARIOS);
        Type listType = new TypeToken<List<User>>()
            {
            }.getType();

        List<User> apiQuery = new Gson().fromJson(json, listType);
        
        return apiQuery;
    }
    public void addUser(String name, String password)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api();
        String preparedURL = API_URL_USUARIOS.replace("{name}",name).replace("{password}",password);
        User data = new User();
        data.setName(name);
        data.setPassword(password);
        api.put(preparedURL);
    }
    public void updUser(String name, String password)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api();
        String preparedURL = API_URL_USUARIOS.replace("{name}",name).replace("{password}",password);
        api.post(preparedURL);
    }
    public void delUser(String name)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api();
        String preparedURL = API_URL_USUARIOS_DELETE.replace("{name}",name).replace("{force}","false");
        api.delete(preparedURL);
    }
    public void fDelUser(String name)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api();
        String preparedURL = API_URL_USUARIOS_DELETE.replace("{name}",name).replace("{force}","true");
        api.delete(preparedURL);
    }
}
