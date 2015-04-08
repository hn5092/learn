package caiheik;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 黑块类
 * @author sinzitai01
 *
 */
public class BlackCell extends Cell {
	Random rand = new Random();		
	int[] initialX ={0,100,200,300};//横坐标的初始位置数组
	
	public BlackCell(int y){		//以指定纵坐标为参数的构造
		this.image = StartGame.black;	
		width = 100;
		height = 150;
		this.x = initialX[rand.nextInt(4)];	//随机位置
		this.y = y;
	}
	//无参构造，纵坐标为第零行（-150）
	public BlackCell(){				
		this.image = StartGame.black;
		width = 100;
		height = 150;
		this.x = initialX[rand.nextInt(4)];	
		this.y = -height;
		this.speed = 5;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public String toString(){	//测试用，不再使用
		return "("+x+","+y+")"+" ";
	}
	/** 下落方法 */
	public void drop(){
		this.y += height;
	}
	/** 移动方法 */
	public void setp(){
		this.y += speed;
	}
}
