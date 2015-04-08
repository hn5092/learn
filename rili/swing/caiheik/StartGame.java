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
	public static final int WIDTH = 415; // ����
	public static final int HEIGHT = 639;//	����
	
	private int state;
	private static final int START = 0;
	private static final int MOVING = 1;
	private static final int WAITING = 2;
	private static final int GAME_OVER = 3;
	
	private Timer timer; // ��ʱ��
	private int intervel = 10; // ʱ����(����)
	
	public static BufferedImage background;
	public static BufferedImage black;
	public static BufferedImage white;
	
	private List<BlackCell> blackcells = new ArrayList<BlackCell>();//��źڿ�ļ���
	private List<WhiteCell> whitecells = new ArrayList<WhiteCell>();//��Ű׿�ļ���
	public static List<Row> rows;	//�м���
	
	public StartGame(){		//�����ù��췽������ʼ����
		rows = new ArrayList<Row>();//��ʼ���м���
		rows.add(new Row(-150));	//��������У���������
		rows.add(new Row(0));		//�����һ��
		rows.add(new Row(150));		//����ڶ���
		rows.add(new Row(300));		//���������
		addBAW();				//�����кڰ׿���뼯��
		
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
		StartGame game = new StartGame(); // ������
		frame.add(game); // �������ӵ�JFrame��
		frame.setSize(WIDTH, HEIGHT); // ���ô�С
		frame.setAlwaysOnTop(true); // ��������������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ĭ�Ϲرղ���
		frame.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // ���ô����ͼ��
		frame.setLocationRelativeTo(null); // ���ô����ʼλ��
		frame.setVisible(true); // �������paint
		
		game.action(); 
	

	}
	
public void g(int a){
	Scanner scan = new Scanner(System.in);
	while(true){
		System.out.println("����������кڿ��λ�ã�1-4");	//����̨��������кڿ�ĺ�����
		int order = scan.nextInt();
		if(order == rows.get(3).getBlackPosition()+1){			
			rows = new StartGame().moveAction();				//������ȷ�����moveAction�����������¼���
		}else if(order == 5){
			
		}else{
			System.out.println("���������Ϸ����");	//���������Ϸ����
			break;									//����ѭ��
		}
	}	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // ������ͼ
		paintBlack(g); // ���ڿ�
		paintWhite(g); // ���׿�
	}
	//���ڿ�
	public void paintBlack(Graphics g) {
		for(int i=0;i<blackcells.size();i++){
			BlackCell b = blackcells.get(i);
			g.drawImage(b.getImage(), b.getX(), b.getY(), null);
		}
	}
	//���׿�
	public void paintWhite(Graphics g) {
		for(int i=0;i<whitecells.size();i++){
			WhiteCell w = whitecells.get(i);
			g.drawImage(w.getImage(), w.getX(), w.getY(), null);
		}
	}
	//��Ӻڰ׿鷽��
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
	//�����������ɾ��
	public List<Row> moveAction() {			
//		for(int i=0;i<rows.size();i++){
//			rows.get(i).drop();	//��������
//		}
		for(Row row : rows){
			row.drop();
		}
		
		rows.add(0,new Row());	//��������
		addBAW();			//��Ӻڰ׿�
		
		if(rows.size()>5){		//�������5��	
			rows.set(5,null);	//��ѵ�������Ϊ�գ�����Χ��
			rows.remove(5);		//�Ƴ���Ԫ��
		}
		repaint();				//�ػ�
		return rows;			//���ƶ�����ɾ����м��Ϸ���
	}
	
	public void enterAction() {			
//		for(int i=0;i<rows.size();i++){
//			rows.get(i).drop();	//��������
//		}	
		rows.add(0,new Row());	//��������
		addBAW();			//��Ӻڰ׿�
		
//		if(rows.size()>5){		//�������5��	
//			rows.set(5,null);	//��ѵ�������Ϊ�գ�����Χ��
//			rows.remove(5);		//�Ƴ���Ԫ��
//		}
	}
	
	int stepIndex=0;
	
	public void stepAction() {
		if (stepIndex % 50 == 0) {
			rows.add(0, new Row()); // ��������
			addBAW(); // ��Ӻڰ׿�
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
		if (rows.size() > 5) { // �������5��
			rows.set(5, null); // ��ѵ�������Ϊ�գ�����Χ��
			rows.remove(5); // �Ƴ���Ԫ��
		}
	}
	
	public void action() {
		timer = new Timer(); // �����̿���
		timer.schedule(new TimerTask() {
			public void run() {
				stepAction();
				repaint();
			}
	}, intervel, intervel);
}
		
		
		
//		// �������¼�
//		MouseAdapter l = new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) { // �����
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
//		this.addMouseListener(l); // �������������
//		this.addMouseMotionListener(l); // ������껬������
}
