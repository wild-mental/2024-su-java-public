package throwingexceptions;

import java.lang.Thread;
import throwingexceptions.exceptionthrowers.MyException;
import throwingexceptions.exceptionthrowers.MyExceptionThrower;
import throwingexceptions.runtimeexceptionthrowers.MyRuntimeExceptionThrower;

public class ThrowingExceptionSample {
    public static void main(String[] args) {
        System.out.println("main is called");
        MyExceptionThrower met = new MyExceptionThrower();
        try {
            met.ThrowMyException();
        } catch (MyException me) {
            me.printStackTrace();
        } finally {
            try { Thread.sleep(20); } catch (InterruptedException e) { throw new RuntimeException(e); }
            System.out.println(">>>>> Program 실행을 계속합니다.");
        }
        MyRuntimeExceptionThrower mret = new MyRuntimeExceptionThrower();
        mret.ThrowMyRuntimeException();
    }
}