package trywithresource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResource {
    public static void main(String args[]) throws FileNotFoundException, IOException {
        FileInputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream("file.txt");
            bis = new BufferedInputStream(is);
            int data = -1;
            while((data = bis.read()) != -1){
                System.out.print((char) data);
            }
        } finally {
            // close resources
            if (is != null) is.close();
            if (bis != null) bis.close();
        }

        try (FileInputStream is2 = new FileInputStream("file.txt");
             BufferedInputStream bis2 = new BufferedInputStream(is2))
        {
            int data;
            while ((data = bis2.read()) != -1) {
                System.out.print((char) data);
            }
        }
    }
}
