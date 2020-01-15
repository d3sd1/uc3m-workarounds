package Exceptions;

public class ApiKeyInvalidException extends Exception {
    public ApiKeyInvalidException(String message) {
        super(message);
    }

    public ApiKeyInvalidException()
    {
        super("");
    }
}