package caiheik;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * ����������
 * �еĶ���û��
 * @author sinzitai01
 *
 */
public class Cell {
	protected int x;	//������
	protected int y;	//������
	protected int speed;//�����ٶȣ���ʱû��
	
	protected int width;//������
	protected int height;//����߶�
	protected BufferedImage image;//ʹ��ͼƬ
	
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
	/** ��дtoString���� */
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
