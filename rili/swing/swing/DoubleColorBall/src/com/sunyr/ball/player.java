package swing.DoubleColorBall.src.com.sunyr.ball;


import java.util.Scanner;

public class player {
	 int[] No = new int[7];
	public void inputNum(){
	Scanner input = new Scanner(System.in);
	System.out.println("������Ҫ�����˫ɫ����루6��<1-33>/ 1��<1-16>��:");
	
	for(int i =0;i<No.length;i++){
		No[i]=input.nextInt();
	}
	}
}
