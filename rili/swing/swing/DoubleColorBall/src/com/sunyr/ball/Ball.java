package swing.DoubleColorBall.src.com.sunyr.ball;

import java.awt.image.BufferedImage;

/*
 * ����ķ���
 */
public abstract class Ball {
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected BufferedImage image;//���ͼƬ
	
	public abstract void step();
	
	
	

}
