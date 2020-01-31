package core.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ResponseMessage
 */
@Getter
@Setter
@NoArgsConstructor
public class ResponseMessage {
    private String message;


    public ResponseMessage(String message) {
        this.message = message;
    }
    
}