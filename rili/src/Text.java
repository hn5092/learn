

/**
 * 日历中添加记事本
 * @author Administrator
 *
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Text{
	public void writerText(int[] a) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw = new PrintWriter(osw, true);
		Scanner scan= new Scanner(System.in);
		System.out.println("请输入你记事的内容：");
		while(true){
		String st=scan.nextLine();
		if("exit".equals(st)){
			break;
		}else{
			pw.println(st);
		}	
		}
	
		pw.close();
	}
	public void readText(int[] a) throws IOException {
		FileInputStream fis = new FileInputStream("pw.txt");
		InputStreamReader isr = new InputStreamReader(fis,"utf-8");
		BufferedReader br =new BufferedReader(isr);
		String str = null;
		String str1="";
		while ((str = br.readLine()) != null) {
			str1+=str+'\n';
		}
		br.close();	
	}
}