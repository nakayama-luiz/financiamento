package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Message nextMessage;
    
    public Message(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
