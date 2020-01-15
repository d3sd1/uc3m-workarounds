package Exceptions;

public class ApiRateLimitException extends Exception {
    public ApiRateLimitException(String message) {
        super(message);
    }

    public ApiRateLimitException()
    {
        super("");
    }
}