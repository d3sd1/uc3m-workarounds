package Exceptions;

public class ApiErrorException extends Exception {
    public ApiErrorException(String message) {
        super(message);
    }

    public ApiErrorException()
    {
        super("");
    }
}