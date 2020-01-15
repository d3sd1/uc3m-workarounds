package wsServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import model.Data;
import utils.Constants;

public class MessageDecoder implements Decoder.Text<Data> {
 
    private static final ObjectMapper gsonMapper = new ObjectMapper();
 
    @Override
    public Data decode(String json) throws DecodeException {
        Gson gson = new GsonBuilder().setDateFormat(Constants.DATE_FORMAT).create();
        Data data = gson.fromJson(json, Data.class);
        return data;
    }
 
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }
 
    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }
 
    @Override
    public void destroy() {
        // Close resources
    }
}