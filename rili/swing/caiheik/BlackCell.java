package caiheik;

import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * �ڿ���
 * @author sinzitai01
 *
 */
public class BlackCell extends Cell {
	Random rand = new Random();		
	int[] initialX ={0,100,200,300};//������ĳ�ʼλ������
	
	public BlackCell(int y){		//��ָ��������Ϊ�����Ĺ���
		this.image = StartGame.black;	
		width = 100;
		height = 150;
		this.x = initialX[rand.nextInt(4)];	//���λ��
		this.y = y;
	}
	//�޲ι��죬������Ϊ�����У�-150��
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
	
	public String toString(){	//�����ã�����ʹ��
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
