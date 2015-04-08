package caiheik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * ���࣬��ʼ����ͬʱ����1��3��
 * @author sinzitai01
 *
 */
public class Row {
	Random rand = new Random();	
	private int[] initialX ={0,100,200,300};//�������ʼλ��
	private Cell[] row = new Cell[4];		//��һ���������� 
	private int blackX;						//�ڿ������
	private int blackY;						//�ڿ�������
	private BlackCell black;				//�ڿ�
	private List<WhiteCell> whites = new ArrayList<WhiteCell>(); //�׿���һ������װ
	private int blackPosition;				//�ڿ�ĺ����껻��Ϊ�����±�
	
	public Row(){	//�޲ι��죬��0��
		this(-150);					
	}
	
	public Row(int y){	//ָ�������Ĺ��췽��
		black = new BlackCell(y);//ʵ����һ���ڿ�
		blackX = black.getX();	//�ڿ������
		switch(blackX){			//��switch�Ѻڿ������ת��Ϊ�±�
		case 0:
			blackPosition = 0;
			break;
		case 100:
			blackPosition = 1;
			break;
		case 200:
			blackPosition = 2;
			break;
		case 300:
			blackPosition = 3;
			break;
		}
		blackY = y;	//��ȡ�ڿ��������
		row[blackPosition] = black;	//�Ѻڿ����������
		for(int i=0;i<row.length;i++){	//ʹ��forѭ����ʼ���׿飬�ڿ��λ������
			if(i==blackPosition){
				continue;
			}
			WhiteCell white = new WhiteCell(initialX[i],y);
			whites.add(white);	//�����ȼ��뼯���ټ������飨������Ҫǿת��
			row[i] = white;
		}
		
	}
	
	public int getBlackX() {
		return blackX;
	}

	public void setBlackX(int blackX) {
		this.blackX = blackX;
	}

	public int getBlackY() {
		return blackY;
	}

	public void setBlackY(int blackY) {
		this.blackY = blackY;
	}
	
	public BlackCell getBlack() {
		return black;
	}

	public void setBlack(BlackCell black) {
		this.black = black;
	}

	public Cell[] getRow() {
		return row;
	}

	public void setRow(Cell[] row) {
		this.row = row;
	}
	
	public int getBlackPosition() {
		return blackPosition;
	}

	public void setBlackPosition(int blackPosition) {
		this.blackPosition = blackPosition;
	}
	
	public List<WhiteCell> getWhites() {
		return whites;
	}

	public void setWhites(List<WhiteCell> whites) {
		this.whites = whites;
	}

	public String toString(){
		String str="";
		for(int i=0;i<row.length;i++){
			str += row[i].toString();
		}
		return str;
	}
	//���䷽��
	public void drop(){
		for(int i=0;i<row.length;i++){
			row[i].drop();
		}
		blackY += black.height;	//
	}
	
	public void step(){
		for(int i=0;i<row.length;i++){
			int y = row[i].getY();
			y += 5;
			row[i].setY(y);
		}
		blackY += black.speed;
	}
}
