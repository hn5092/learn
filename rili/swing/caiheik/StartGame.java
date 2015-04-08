package caiheik;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartGame extends JPanel{
	public static final int WIDTH = 415; // 面板宽
	public static final int HEIGHT = 639;//	面板高
	
	private int state;
	private static final int START = 0;
	private static final int MOVING = 1;
	private static final int WAITING = 2;
	private static final int GAME_OVER = 3;
	
	private Timer timer; // 定时器
	private int intervel = 10; // 时间间隔(毫秒)
	
	public static BufferedImage background;
	public static BufferedImage black;
	public static BufferedImage white;
	
	private List<BlackCell> blackcells = new ArrayList<BlackCell>();//存放黑块的集合
	private List<WhiteCell> whitecells = new ArrayList<WhiteCell>();//存放白块的集合
	public static List<Row> rows;	//行集合
	
	public StartGame(){		//测试用构造方法，初始界面
		rows = new ArrayList<Row>();//初始化行集合
		rows.add(new Row(-150));	//加入第零行（看不见）
		rows.add(new Row(0));		//加入第一行
		rows.add(new Row(150));		//加入第二行
		rows.add(new Row(300));		//加入第三行
		addBAW();				//把现有黑白块加入集合
		
	}
	
	static {
		try {
			background = ImageIO.read(StartGame.class.getResource("background.png"));
			black = ImageIO.read(StartGame.class.getResource("black.png"));
			white = ImageIO.read(StartGame.class.getResource("white.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Fly");
		StartGame game = new StartGame(); // 面板对象
		frame.add(game); // 将面板添加到JFrame中
		frame.setSize(WIDTH, HEIGHT); // 设置大小
		frame.setAlwaysOnTop(true); // 设置其总在最上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
		frame.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // 设置窗体的图标
		frame.setLocationRelativeTo(null); // 设置窗体初始位置
		frame.setVisible(true); // 尽快调用paint
		
		game.action(); 
	

	}
	
public void g(int a){
	Scanner scan = new Scanner(System.in);
	while(true){
		System.out.println("请输入第三行黑块的位置：1-4");	//控制台输入第三行黑块的横坐标
		int order = scan.nextInt();
		if(order == rows.get(3).getBlackPosition()+1){			
			rows = new StartGame().moveAction();				//输入正确则调用moveAction方法，并更新集合
		}else if(order == 5){
			
		}else{
			System.out.println("输入错误，游戏结束");	//输入错误游戏结束
			break;									//跳出循环
		}
	}	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // 画背景图
		paintBlack(g); // 画黑块
		paintWhite(g); // 画白块
	}
	//画黑块
	public void paintBlack(Graphics g) {
		for(int i=0;i<blackcells.size();i++){
			BlackCell b = blackcells.get(i);
			g.drawImage(b.getImage(), b.getX(), b.getY(), null);
		}
	}
	//画白块
	public void paintWhite(Graphics g) {
		for(int i=0;i<whitecells.size();i++){
			WhiteCell w = whitecells.get(i);
			g.drawImage(w.getImage(), w.getX(), w.getY(), null);
		}
	}
	//添加黑白块方法
	public void addBAW(){		
//		for(int i=0;i<rows.size();i++){
//			blackcells.add(rows.get(i).getBlack());
//			whitecells.addAll(rows.get(i).getWhites());
//		}
		for(Row row : rows){
			blackcells.add(row.getBlack());
			whitecells.addAll(row.getWhites());
		}
	}
	//方块下落和增删行
	public List<Row> moveAction() {			
//		for(int i=0;i<rows.size();i++){
//			rows.get(i).drop();	//遍历下落
//		}
		for(Row row : rows){
			row.drop();
		}
		
		rows.add(0,new Row());	//插入新行
		addBAW();			//添加黑白块
		
		if(rows.size()>5){		//如果大于5行	
			rows.set(5,null);	//则把第六行设为空（超范围）
			rows.remove(5);		//移除空元素
		}
		repaint();				//重绘
		return rows;			//把移动和增删后的行集合返回
	}
	
	public void enterAction() {			
//		for(int i=0;i<rows.size();i++){
//			rows.get(i).drop();	//遍历下落
//		}	
		rows.add(0,new Row());	//插入新行
		addBAW();			//添加黑白块
		
//		if(rows.size()>5){		//如果大于5行	
//			rows.set(5,null);	//则把第六行设为空（超范围）
//			rows.remove(5);		//移除空元素
//		}
	}
	
	int stepIndex=0;
	
	public void stepAction() {
		if (stepIndex % 50 == 0) {
			rows.add(0, new Row()); // 插入新行
			addBAW(); // 添加黑白块
		}
		
		stepIndex++;
		
		for(BlackCell b : blackcells){
			int y = b.getY();
			y += 3;
			b.setY(y);
		}
		for(WhiteCell w : whitecells){
			w.setp();
		}
		if (rows.size() > 5) { // 如果大于5行
			rows.set(5, null); // 则把第六行设为空（超范围）
			rows.remove(5); // 移除空元素
		}
	}
	
	public void action() {
		timer = new Timer(); // 主流程控制
		timer.schedule(new TimerTask() {
			public void run() {
				stepAction();
				repaint();
			}
	}, intervel, intervel);
}
		
		
		
//		// 鼠标监听事件
//		MouseAdapter l = new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) { // 鼠标点击
//				int x = e.getX();
//				int y = e.getY();
//				if(state==START){
//					if(x>rows.get(3).getBlackX() && x<rows.get(3).getBlackX()+100
//							&& y>rows.get(3).getBlackY() && y<rows.get(3).getBlackY()+150){
//						state = MOVING;
//					}
//				}
//				if(state==WAITING){
//					
//				}
//			}
//		
//		};
//		this.addMouseListener(l); // 处理鼠标点击操作
//		this.addMouseMotionListener(l); // 处理鼠标滑动操作
}
