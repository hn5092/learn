package swing;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ʵ��AreaText�Ļ��б��� {
	BufferedWriter bw = null;
    try {
        OutputStream os = new FileOutputStream("E:\\test.txt");
        bw = new BufferedWriter(new OutputStreamWriter(os));
        for (String value : jta.getText().split("\n")) {
            bw.write(value);
            bw.newLine();//����
        }
    } catch (IOException e1) {
        e1.printStackTrace();
    } finally {
        if (bw != null) {
            try {
                bw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
