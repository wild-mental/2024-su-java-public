package throwingexceptions.runtimeexceptionthrowers;

public class MyRuntimeExceptionThrower {
//    public void ThrowMyRuntimeException() throws MyRuntimeException{
    public void ThrowMyRuntimeException() {
        throw new MyRuntimeException("Thrown from MyRuntimeExceptionThrower");
    }
}
