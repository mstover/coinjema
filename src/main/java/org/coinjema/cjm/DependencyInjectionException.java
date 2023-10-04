package org.coinjema.cjm;

public class DependencyInjectionException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DependencyInjectionException() {
        super();
    }

    public DependencyInjectionException(String message) {
        super(message);
    }

    public DependencyInjectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DependencyInjectionException(Throwable cause) {
        super(cause);
    }

}
