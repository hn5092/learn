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



//数字时钟
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
	    com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.3f); //实现jFrame
		setAlwaysOnTop(true); // 始终最前
		setFont(new Font("宋体", Font.BOLD, 12)); // 设置时钟的显示字体
		start(); // 开始进程
		setLocationRelativeTo(null);
		setSize(200, 250); // 设置窗口尺寸
//		setUndecorated(true);
		setVisible(b); // 窗口可视
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出程序
//		setBackground(new Color(0,0,0,0));
		
	}

	public void start() { // 开始进程
		if (clock == null)// 如果进程为空值
		{
			clock = new Thread(this); // 实例化进程
			clock.start(); // 开始进程
		}
	}

	public void run()// 运行进程
	{
		while (clock != null) {
//			g.clearRect(29, 79, 130, 180);
			repaint(29, 79, 130, 180); // 调用paint方法重绘界面
			try {
				Thread.sleep(1000); // 线程暂停一秒(1000毫秒)
			} catch (InterruptedException ex) {
				ex.printStackTrace(); // 输出出错信息
			}
		}
	}

	public void stop()// 停止进程
	{
		clock = null;
	}

	public void paint(Graphics g)// 重载组件的paint方法
	{     super.paint(g);
		Graphics2D g2 = (Graphics2D) g; // 得到Graphics2D对象
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		Calendar now = new GregorianCalendar(); // 实例化日历对象
		now.setTime(new Date());// dateFormat.format(now.getTime())
		String timeInfo = ""; // 输出信息
//		System.out.println(timeInfo);
		int hour = now.get(Calendar.HOUR_OF_DAY); // 得到小时数
		int minute = now.get(Calendar.MINUTE); // 得到分数
		int second = now.get(Calendar.SECOND); // 得到秒数
		if (hour <= 9){
			timeInfo += "0" + hour + ":"; // 格式化输出
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
		g.setColor(new Color(0,0,0,0)); // 设置当前颜色为白色
		
		Dimension dim = getSize(); // 得到窗口尺寸
		g.fillRect(29, 79, 130, 180); // 填充背景色为白色
		g.setColor(Color.red); // 设置当前颜色为橙色
		g.drawString(timeInfo, 70, 240); // 显示时间字符串
		g.setColor(Color.green);
		g.drawString(dateFormat.format(now.getTime()),35, 60); //日期
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
//					g.setColor(Color.red); // 数字3,6,9,12为红色
//					g.drawString("" + num, xPos - 5, yPos + 3); // 写数字
//					num+= (num + 1);
//				}else {
//					g.setColor(Color.black); // 其余数字为黑色
//				}
//				
//			}
//			else{ 
				
				g.setColor(Color.black);
//				g.drawString(".", xPos, yPos);
			
//			}
		}
//				g.drawString("" + 12, 180 - 5, 100 + 3); // 写数字
//				g.drawString("" + 3, 260 - 5, 180 + 3); // 写数字
//				g.drawString("" + 6, 180 - 5, 260 + 3); // 写数字
//				g.drawString("" + 9, 100 - 5, 180 + 3); // 写数字
			
		g.setColor(Color.black);
		g.drawImage(colock, Xpoint - 4-R, Ypoint - 4-R,null);//时钟的位置
		g.fillOval(Xpoint - 4, Ypoint - 4, 8, 8);//画原点
		// 画秒针
		xSecond = (int) (Xpoint + (R - 10)
				* Math.sin(second * (2 * Math.PI / 60)));
		ySecond = (int) (Ypoint - (R - 10)
				* Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(Xpoint, Ypoint, xSecond, ySecond);
		// 画分针
		xMin = (int) (Xpoint + (R - 20)
				* Math.sin((minute + second / 60) * (2 * Math.PI / 60)));
		yMin = (int) (Ypoint - (R - 20)
				* Math.cos((minute + second / 60) * (2 * Math.PI / 60)));
		g.setColor(Color.red);
		g.drawLine(Xpoint, Ypoint, xMin, yMin);
		// 画时针
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
//			jbutton.setText("迷你");
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
