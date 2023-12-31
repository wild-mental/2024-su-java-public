package throwingexceptions.exceptionthrowers;

public class MyExceptionThrower {
    public void ThrowMyException() throws MyException {
        throw new MyException("thrown from MyExceptionThrower!");
    }
}
