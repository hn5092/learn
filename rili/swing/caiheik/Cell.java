package caiheik;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 基础方格类
 * 有的东西没用
 * @author sinzitai01
 *
 */
public class Cell {
	protected int x;	//横坐标
	protected int y;	//纵坐标
	protected int speed;//下落速度，暂时没用
	
	protected int width;//方块宽度
	protected int height;//方块高度
	protected BufferedImage image;//使用图片
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	/** 重写toString方法 */
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
