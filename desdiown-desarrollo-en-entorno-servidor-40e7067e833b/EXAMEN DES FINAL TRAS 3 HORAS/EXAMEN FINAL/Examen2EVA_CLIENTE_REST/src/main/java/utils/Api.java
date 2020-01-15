package utils;

import Exceptions.ApiErrorException;
import Exceptions.ApiInvalidQueryException;
import Exceptions.ApiKeyInvalidException;
import Exceptions.ApiRateLimitException;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import config.Configuration;
import java.io.IOException;
import modelo.User;

public class Api
{

    /* Se pasa el user si se desea para que éste se adhiera
    a las cabeceras de las llamadas (necesario para Cajas, pero no para
    el control de usuarios)*/
    private User user;

    public Api()
    {
        this.user = new User();
    }

    public Api(User user)
    {
        this.user = user;
    }

    private String call(String url, String method) throws ApiErrorException, ApiInvalidQueryException, ApiKeyInvalidException, ApiRateLimitException
    {
        String apiQuery;
        try
        {
            HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
            final JsonFactory JSON_FACTORY = new JacksonFactory();
            HttpRequestFactory requestFactory
                    = HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer()
                    {
                        @Override
                        public void initialize(HttpRequest request)
                        {
                            request.setParser(new JsonObjectParser(JSON_FACTORY));

                        }
                    });
            HttpRequest requestGoogle;
            HttpContent content = null;
            switch (method)
            {
                case "GET":
                    requestGoogle = requestFactory.buildGetRequest(new GenericUrl(Configuration.getInstance().getAPI_URL() + url));
                    break;
                case "POST":
                    requestGoogle = requestFactory.buildPostRequest(new GenericUrl(Configuration.getInstance().getAPI_URL() + url), content);
                    break;
                case "PUT":
                    requestGoogle = requestFactory.buildPutRequest(new GenericUrl(Configuration.getInstance().getAPI_URL() + url), content);
                    break;
                case "DELETE":
                    requestGoogle = requestFactory.buildDeleteRequest(new GenericUrl(Configuration.getInstance().getAPI_URL() + url));
                    break;
                default:
                    throw new ApiInvalidQueryException();
            }
            requestGoogle.getHeaders().set("rest-api-key", Configuration.getInstance().getAPI_KEY());
            requestGoogle.getHeaders().set("name", user.getName());
            requestGoogle.getHeaders().set("password", user.getPassword());
            requestGoogle.getHeaders().setContentType("application/json");

            HttpResponse exec = requestGoogle.execute();
            switch (exec.getStatusCode())
            {
                case 400:
                    throw new ApiInvalidQueryException();
                case 401:
                    throw new ApiKeyInvalidException();
                case 406:
                    throw new ApiRateLimitException();
                case 500:
                    throw new ApiErrorException();
            }
            apiQuery = exec.parseAsString();
        }
        catch (HttpResponseException e)
        {
            switch (e.getStatusCode())
            {
                case 500:
                    throw new ApiErrorException();
                case 406:
                    throw new ApiRateLimitException();
                case 401:
                    throw new ApiKeyInvalidException();
                case 400:
                    throw new ApiInvalidQueryException();
                default:
                    throw new ApiErrorException();

            }
        }
        catch (IOException e)
        {
            throw new ApiErrorException();
        }
        return apiQuery;
    }

    public String get(String url) throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        return call(url, "GET");
    }

    public void post(String url) throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        this.call(url, "POST");

    }

    public void put(String url) throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        this.call(url, "PUT");
    }

    public void delete(String url) throws ApiErrorException, ApiRateLimitException, ApiKeyInvalidException, ApiInvalidQueryException
    {
        this.call(url, "DELETE");
    }
}
