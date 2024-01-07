package systemclasscheck;

import java.io.*;
import java.lang.ref.WeakReference;

// 시스템 클래스 관련 기능을 살펴봅니다. - GC and Runtime.
public class SystemClassSample1 {

    public static Object[] outOfMainMethod(Object a, Object b, WeakReference c) {
        b = null;
        c = null;
        Object[] objs = new Object[] {a, b, c};
        return objs;
    }

    public static void main(String[] args) {
        Object a = new SystemClassSample1();
        Object b = a;
        WeakReference<Object> c = new WeakReference<>(a);

        Object[] objs = outOfMainMethod(a, b, c);

        if (a == b) {
            System.out.println("a == b!");
        }
        if (a.equals(b)) {
            System.out.println("a equals b!");
        }
        a = null;
        System.out.println(c);
        System.gc();
        try  {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c);

        // java.lang 에 있지만 System 클래스 및 gc() 와 매우 유관하기 때문에 함께 확인
        Runtime currentRuntime = Runtime.getRuntime();

        try {
            // Get the input stream of the process
            Process process = currentRuntime.exec("pwd");
            InputStream ExecResultInputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ExecResultInputStream));


            // Read and print the output
            String line;
            System.out.println("Output of the command:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the BufferedReader
            reader.close();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
