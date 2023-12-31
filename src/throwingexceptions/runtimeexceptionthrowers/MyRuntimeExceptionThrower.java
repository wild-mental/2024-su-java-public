package throwingexceptions.runtimeexceptionthrowers;

public class MyRuntimeExceptionThrower {
    public void ThrowMyRuntimeException() throws MyRuntimeException{
        throw new MyRuntimeException("Thrown from MyRuntimeExceptionThrower");
    }
}
