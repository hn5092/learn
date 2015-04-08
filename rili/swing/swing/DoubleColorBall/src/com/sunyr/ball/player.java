package swing.DoubleColorBall.src.com.sunyr.ball;


import java.util.Scanner;

public class player {
	 int[] No = new int[7];
	public void inputNum(){
	Scanner input = new Scanner(System.in);
	System.out.println("ÇëÊäÈëÒª¹ºÂòµÄË«É«ÇòºÅÂë£¨6ºì<1-33>/ 1À¶<1-16>£©:");
	
	for(int i =0;i<No.length;i++){
		No[i]=input.nextInt();
	}
	}
}
