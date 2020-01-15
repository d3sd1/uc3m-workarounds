package Exceptions;

public class ApiIntegrityError extends Exception {
    public ApiIntegrityError(String message) {
        super(message);
    }

    public ApiIntegrityError()
    {
        super("");
    }
}