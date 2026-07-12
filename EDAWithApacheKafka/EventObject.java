import java.io.Serializable;

public class EventObject implements Serializable {
    private int id;
    private String message;

    public EventObject(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventObject{id=" + id + ", message='" + message + "'}";
    }
}