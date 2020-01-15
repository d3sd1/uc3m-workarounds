package services;

import Exceptions.ApiErrorException;
import Exceptions.ApiIntegrityError;
import Exceptions.ApiInvalidQueryException;
import Exceptions.ApiKeyInvalidException;
import Exceptions.ApiRateLimitException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import modelo.Caja;
import modelo.Cosa;
import modelo.User;
import utils.Api;

public class UsuarioServicios {
    private User user;
    public UsuarioServicios(User user)
    {
        this.user = user;
    }
    private final String API_URL_CAJAS = "/acciones_usuario";
    public List<Caja> listCajas() 
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiErrorException, ApiIntegrityError, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String json = api.get(API_URL_CAJAS);
        if(null == json)
        {
            throw new ApiErrorException();
        }
        Type listType = new TypeToken<List<Caja>>()
            {
            }.getType();

        List<Caja> apiQuery = new Gson().fromJson(json, listType);
        
        return apiQuery;
    }
    public List<Cosa> listCosas(String caja) 
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiErrorException, ApiIntegrityError, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String json = api.get(API_URL_CAJAS + "/" + caja);
        if(null == json)
        {
            throw new ApiErrorException();
        }

        Caja apiQuery = new Gson().fromJson(json, Caja.class);
        List<Cosa> cosas = apiQuery.getCosas();
        
        return cosas;
    }
    public void addCaja(String name)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException, ApiIntegrityError
    {
        Api api = new Api();
        String preparedURL = API_URL_CAJAS;
        Caja data = new Caja();
        data.setNombre(name);
        api.put(preparedURL, data);
    }
    public void addcantidad(String name)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException, ApiIntegrityError
    {
        Api api = new Api();
        String preparedURL = API_URL_CAJAS;
        Caja data = new Caja();
        data.setNombre(name);
        api.put(preparedURL, data);
    }
}
