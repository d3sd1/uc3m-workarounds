package Commands;

public abstract class Command {
    private String value;
    abstract void execute();


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
