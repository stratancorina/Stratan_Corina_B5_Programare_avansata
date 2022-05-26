
public class Message {

    private int id;
    private String expeditor;
    private String text;

    public Message(String expeditor, String text) {
        this.expeditor = expeditor;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", expeditor='" + expeditor + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
