package services;

import Exceptions.ApiErrorException;
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
    private final String API_URL_CAJAS = "/cajas";
    private final String API_URL_CAJAS_PUT = "/cajas?cajanombre={caja}";
    private final String API_URL_COSAS_GET = "/cosas?cajanombre={caja}";
    private final String API_URL_COSAS_PUT = "/cosas?cajanombre={caja}&cosanombre={cosa}&cosacantidad={cantidad}";
    private final String API_URL_COSAS_POST = "/cosas?cajanombre={caja}&cosanombre={cosa}&cosacantidad={cantidad}";
    
    public List<Caja> listCajas() 
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiErrorException, ApiInvalidQueryException
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
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiErrorException, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String json = api.get(API_URL_COSAS_GET.replace("{caja}",caja));
        if(null == json)
        {
            throw new ApiErrorException();
        }

        Caja apiQuery = new Gson().fromJson(json, Caja.class);
        List<Cosa> cosas = apiQuery.getCosas();
        
        return cosas;
    }
    public void addCaja(String name)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String preparedURL = API_URL_CAJAS_PUT.replace("{caja}",name);
        api.put(preparedURL);
    }
    public void addCosa(String caja, String cosa, String cantidad)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String preparedURL = API_URL_COSAS_PUT.replace("{caja}",caja).replace("{cosa}",cosa).replace("{cantidad}",cantidad);
        api.put(preparedURL);
    }
    public void addCantidad(String caja, String cosa, String cantidad)
            throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        Api api = new Api(user);
        String preparedURL = API_URL_COSAS_POST.replace("{caja}",caja).replace("{cosa}",cosa).replace("{cantidad}",cantidad);
        api.post(preparedURL);
    }
}
