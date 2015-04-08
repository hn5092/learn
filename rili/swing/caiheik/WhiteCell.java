package caiheik;

import java.awt.image.BufferedImage;
/**
 * 白块类
 * @author sinzitai01
 *
 */
public class WhiteCell extends Cell {
	//构造方法需要横纵坐标的参数
	public WhiteCell(int x,int y){
		this.image = StartGame.white;
		width = 100;
		height = 150;
		this.x = x;
		this.y = y;
		this.speed = 3;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public String toString(){
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
