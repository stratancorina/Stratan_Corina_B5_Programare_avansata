package exceptions;

public class InvalidItemId extends Exception{
    public InvalidItemId(String errorMessage) {
        super(errorMessage);
    }
}
