package wsServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import model.Data;

public class MessageEncoder implements Encoder.Text<Data> {
 
    private static final ObjectMapper gson = new ObjectMapper();
 
    @Override
    public String encode(Data message) throws EncodeException {
        String json = "";
        try {
            json = gson.writeValueAsString(message);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MessageEncoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
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