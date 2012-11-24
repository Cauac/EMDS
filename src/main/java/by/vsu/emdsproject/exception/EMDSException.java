package by.vsu.emdsproject.exception;

public class EMDSException extends RuntimeException{

    public EMDSException() {
    }

    public EMDSException(String message) {
        super(message);
    }

    public EMDSException(String message, Throwable cause) {
        super(message, cause);
    }

    public EMDSException(Throwable cause) {
        super(cause);
    }
    
}
