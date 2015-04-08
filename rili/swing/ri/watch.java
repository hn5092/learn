package ri;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;



//����ʱ��
public class watch extends JFrame implements Runnable{
	boolean flag=false;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	Thread clock;
	final int Xpoint = 100;
	final int Ypoint = 150;
	final int R = 65;
	int xHour = 0, yHour = 0, xSecond = 0, ySecond = 0, xMin = 0, yMin = 0;
private static BufferedImage colock;
static {
	try {colock = ImageIO.read(CalendarDay.class
			.getResource("colock1.png"));}catch(Exception e){
				e.printStackTrace();
			}}
	public watch(boolean b) {
	    com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.3f); //ʵ��jFrame
		setAlwaysOnTop(true); // ʼ����ǰ
		setFont(new Font("����", Font.BOLD, 12)); // ����ʱ�ӵ���ʾ����
		start(); // ��ʼ����
		setLocationRelativeTo(null);
		setSize(200, 250); // ���ô��ڳߴ�
//		setUndecorated(true);
		setVisible(b); // ���ڿ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ���ʱ�˳�����
//		setBackground(new Color(0,0,0,0));
		
	}

	public void start() { // ��ʼ����
		if (clock == null)// �������Ϊ��ֵ
		{
			clock = new Thread(this); // ʵ��������
			clock.start(); // ��ʼ����
		}
	}

	public void run()// ���н���
	{
		while (clock != null) {
//			g.clearRect(29, 79, 130, 180);
			repaint(29, 79, 130, 180); // ����paint�����ػ����
			try {
				Thread.sleep(1000); // �߳���ͣһ��(1000����)
			} catch (InterruptedException ex) {
				ex.printStackTrace(); // ���������Ϣ
			}
		}
	}

	public void stop()// ֹͣ����
	{
		clock = null;
	}

	public void paint(Graphics g)// ���������paint����
	{     super.paint(g);
		Graphics2D g2 = (Graphics2D) g; // �õ�Graphics2D����
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		Calendar now = new GregorianCalendar(); // ʵ������������
		now.setTime(new Date());// dateFormat.format(now.getTime())
		String timeInfo = ""; // �����Ϣ
//		System.out.println(timeInfo);
		int hour = now.get(Calendar.HOUR_OF_DAY); // �õ�Сʱ��
		int minute = now.get(Calendar.MINUTE); // �õ�����
		int second = now.get(Calendar.SECOND); // �õ�����
		if (hour <= 9){
			timeInfo += "0" + hour + ":"; // ��ʽ�����
		}
		else{
			timeInfo += hour + ":"; 
		}
			if (minute <= 9){
			timeInfo += "0" + minute + ":";
			}else{
			timeInfo += minute + ":";
		
			}if (second <= 9){
			timeInfo += "0" + second;
			}else{
			timeInfo += second;
			}
		g.setColor(new Color(0,0,0,0)); // ���õ�ǰ��ɫΪ��ɫ
		
		Dimension dim = getSize(); // �õ����ڳߴ�
		g.fillRect(29, 79, 130, 180); // ��䱳��ɫΪ��ɫ
		g.setColor(Color.red); // ���õ�ǰ��ɫΪ��ɫ
		g.drawString(timeInfo, 70, 240); // ��ʾʱ���ַ���
		g.setColor(Color.green);
		g.drawString(dateFormat.format(now.getTime()),35, 60); //����
		g.setColor(Color.black);
		g.setFont(new Font("SAN_SERIF", Font.BOLD, 10));
		for (int i = 0, num =12; i < 360; i += 6,num--) {
			double alfa = Math.toRadians(i);
			int xPos = Xpoint + (int) (R * Math.sin(alfa));
			int yPos = Ypoint - (int) (R * Math.cos(alfa));
			System.out.println("x"+i+"="+xPos);
			System.out.println("y="+yPos);
			
//			if (i==0||i==90) {
//				if (num % 3 == 0){
//					g.setColor(Color.red); // ����3,6,9,12Ϊ��ɫ
//					g.drawString("" + num, xPos - 5, yPos + 3); // д����
//					num+= (num + 1);
//				}else {
//					g.setColor(Color.black); // ��������Ϊ��ɫ
//				}
//				
//			}
//			else{ 
				
				g.setColor(Color.black);
//				g.drawString(".", xPos, yPos);
			
//			}
		}
//				g.drawString("" + 12, 180 - 5, 100 + 3); // д����
//				g.drawString("" + 3, 260 - 5, 180 + 3); // д����
//				g.drawString("" + 6, 180 - 5, 260 + 3); // д����
//				g.drawString("" + 9, 100 - 5, 180 + 3); // д����
			
		g.setColor(Color.black);
		g.drawImage(colock, Xpoint - 4-R, Ypoint - 4-R,null);//ʱ�ӵ�λ��
		g.fillOval(Xpoint - 4, Ypoint - 4, 8, 8);//��ԭ��
		// ������
		xSecond = (int) (Xpoint + (R - 10)
				* Math.sin(second * (2 * Math.PI / 60)));
		ySecond = (int) (Ypoint - (R - 10)
				* Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(Xpoint, Ypoint, xSecond, ySecond);
		// ������
		xMin = (int) (Xpoint + (R - 20)
				* Math.sin((minute + second / 60) * (2 * Math.PI / 60)));
		yMin = (int) (Ypoint - (R - 20)
				* Math.cos((minute + second / 60) * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(Xpoint, Ypoint, xMin, yMin);
		// ��ʱ��
		xHour = (int) (Xpoint + (R - 30)
				* Math.sin((hour + minute / 60 + second / 60 / 60)
						* (2 * Math.PI / 12)));
		yHour = (int) (Ypoint - (R - 30)
				* Math.cos((hour + minute / 60 + second / 60 / 60)
						* (2 * Math.PI / 12)));
		g.setColor(Color.red);
		g.drawLine(Xpoint, Ypoint, xHour, yHour);
	
	}
//	JButton jbutton;
//	     javax.swing.JButton getJButton() {
//		
//			jbutton = new javax.swing.JButton();
//			jbutton.setBounds(0, 0, 30, 10);
//			jbutton.setText("����");
//			jbutton.setBackground(Color.black);
//			jbutton.addActionListener(this);
//
//		
//		return jbutton;
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
