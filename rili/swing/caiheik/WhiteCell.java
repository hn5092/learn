package caiheik;

import java.awt.image.BufferedImage;
/**
 * �׿���
 * @author sinzitai01
 *
 */
public class WhiteCell extends Cell {
	//���췽����Ҫ��������Ĳ���
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
	/** ���䷽�� */
	public void drop(){
		this.y += height;
	}
	/** �ƶ����� */
	public void setp(){
		this.y += speed;
	}
}
