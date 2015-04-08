package caiheik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 行类，初始化的同时包括1黑3白
 * @author sinzitai01
 *
 */
public class Row {
	Random rand = new Random();	
	private int[] initialX ={0,100,200,300};//横坐标初始位置
	private Cell[] row = new Cell[4];		//用一个数组来存 
	private int blackX;						//黑块横坐标
	private int blackY;						//黑块纵坐标
	private BlackCell black;				//黑块
	private List<WhiteCell> whites = new ArrayList<WhiteCell>(); //白块用一个集合装
	private int blackPosition;				//黑块的横坐标换算为数组下标
	
	public Row(){	//无参构造，第0行
		this(-150);					
	}
	
	public Row(int y){	//指定行数的构造方法
		black = new BlackCell(y);//实例化一个黑块
		blackX = black.getX();	//黑块横坐标
		switch(blackX){			//用switch把黑块横坐标转化为下标
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
		blackY = y;	//获取黑块的纵坐标
		row[blackPosition] = black;	//把黑块加入行数组
		for(int i=0;i<row.length;i++){	//使用for循环初始化白块，黑块的位置跳过
			if(i==blackPosition){
				continue;
			}
			WhiteCell white = new WhiteCell(initialX[i],y);
			whites.add(white);	//必须先加入集合再加入数组（否则需要强转）
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
	//下落方法
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
