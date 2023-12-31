package throwingexceptions.exceptionthrowers;

public class MyException extends Exception {
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
}
