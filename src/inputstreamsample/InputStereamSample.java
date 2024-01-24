package inputstreamsample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStereamSample {
//    static int data = -1; // 아래 InputStream 의 read() 검증 이외의 용도가 없으므로 지역변수로 선언하는 것이 더 자연스러움
    public static void main(String[] args) {
        int data = -1;
        try {
            FileInputStream myFileIs = new FileInputStream("/Users/kidsnote/Workspace/IdeaProjects/sample_java_basic_2024_/src/module-info.java");
            data = myFileIs.read(); // 이 동작이 잘 수행된 것을 보장하려면 초기값이 0~127 을 벗어나기만 하면 됨
            System.out.println(data); // Unicode 또는 ASCII 코드를 1 byte 씩 읽어서 int 로 다루고 있음... (0 ~ 127) -1 값이 없음
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
