package Exceptions;

public class ApiInvalidQueryException extends Exception {
    public ApiInvalidQueryException(String message) {
        super(message);
    }

    public ApiInvalidQueryException()
    {
        super("");
    }
}