package swing.DoubleColorBall.src.com.sunyr.ball;

import java.awt.image.BufferedImage;

/*
 * 父类的方法
 */
public abstract class Ball {
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected BufferedImage image;//球的图片
	
	public abstract void step();
	
	
	

}
