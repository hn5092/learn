package swing.DoubleColorBall.src.com.sunyr.ball;

import java.util.Arrays;
import java.util.Random;


public class RedBall extends Ball {
	protected int speed = 1;
	Random rand = new Random();
	
	
	/**中奖的红球数组*/
	int[] red1 = new int[6];
	
	public RedBall(){//构造方法
		image = DoubleColorBallGame.redBall;
		width = image.getWidth();
		height = image.getHeight();
		Random rand = new Random();
		x = 250;
		y = 215;
		
	}
		public int RedNumber(){
			return 1;
		}
	
	public void step() {
		y += speed;
		
	}
	
	
	
}
