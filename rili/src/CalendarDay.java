
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalendarDay extends JPanel implements ActionListener {
	// 设置静态图片
	public static final int WIDTH = 635;
	public static final int HEIGHT = 454;
	public static BufferedImage bacakground;
	public static BufferedImage number_1;
	public static BufferedImage number_2;
	public static BufferedImage number_3;
	public static BufferedImage number_4;
	public static BufferedImage number_5;
	public static BufferedImage number_6;
	public static BufferedImage number_7;
	public static BufferedImage number_8;
	public static BufferedImage number_9;
	public static BufferedImage number_10;
	public static BufferedImage number_11;
	public static BufferedImage number_12;
	public static BufferedImage number_13;
	public static BufferedImage number_14;
	public static BufferedImage number_15;
	public static BufferedImage number_16;
	public static BufferedImage number_17;
	public static BufferedImage number_18;
	public static BufferedImage number_19;
	public static BufferedImage number_20;
	public static BufferedImage number_21;
	public static BufferedImage number_22;
	public static BufferedImage number_23;
	public static BufferedImage number_24;
	public static BufferedImage number_25;
	public static BufferedImage number_26;
	public static BufferedImage number_27;
	public static BufferedImage number_28;
	public static BufferedImage number_29;
	public static BufferedImage number_30;
	public static BufferedImage number_31;
	public static BufferedImage today;
	public static final int DAY = 0;
	public static final int MONTH = 1;
	public static int mon = 0;
	public int state = 0;
	private JLabel jLabel;// 时钟显示标签
	private JTextField jTextField; // 文本
	private JButton jButton; // 按钮
	private JButton jButton2; // 按钮
	private JButton jButton3; // 按钮
	private JLabel label;// 时间标题
	private JLabel label2;
	private JTextField text;
	private String time = null;
	static int[] a;// 每一个天数的X的坐标
	static int[] b;// 没一个天数的Y的坐标
	static JTextArea jta = null;
	String str;
	private static int todayX; // 今天的坐标
	private static int todayY;// 今天的纵坐标
	static String name = new SimpleDateFormat("yyyy-MM-d").format(Calendar
			.getInstance().getTime()); // 获得日期

	public static JFrame jFrame = new JFrame("Fly");// 创建框架		
	BufferedWriter bw = null;
	static {
		try {
			today = ImageIO.read(CalendarDay.class.getResource("today.png"));
			bacakground = ImageIO.read(CalendarDay.class.getResource("gr.png"));
			number_1 = ImageIO.read(CalendarDay.class
					.getResource("number_1.png"));
			number_2 = ImageIO.read(CalendarDay.class
					.getResource("number_2.png"));
			number_3 = ImageIO.read(CalendarDay.class
					.getResource("number_3.png"));
			number_4 = ImageIO.read(CalendarDay.class
					.getResource("number_4.png"));
			number_5 = ImageIO.read(CalendarDay.class
					.getResource("number_5.png"));
			number_6 = ImageIO.read(CalendarDay.class
					.getResource("number_6.png"));
			number_7 = ImageIO.read(CalendarDay.class
					.getResource("number_7.png"));
			number_8 = ImageIO.read(CalendarDay.class
					.getResource("number_8.png"));
			number_9 = ImageIO.read(CalendarDay.class
					.getResource("number_9.png"));
			number_10 = ImageIO.read(CalendarDay.class
					.getResource("number_10.png"));
			number_11 = ImageIO.read(CalendarDay.class
					.getResource("number_11.png"));
			number_12 = ImageIO.read(CalendarDay.class
					.getResource("number_12.png"));
			number_13 = ImageIO.read(CalendarDay.class
					.getResource("number_13.png"));
			number_14 = ImageIO.read(CalendarDay.class
					.getResource("number_14.png"));
			number_15 = ImageIO.read(CalendarDay.class
					.getResource("number_15.png"));
			number_16 = ImageIO.read(CalendarDay.class
					.getResource("number_16.png"));
			number_17 = ImageIO.read(CalendarDay.class
					.getResource("number_17.png"));
			number_18 = ImageIO.read(CalendarDay.class
					.getResource("number_18.png"));
			number_19 = ImageIO.read(CalendarDay.class
					.getResource("number_19.png"));
			number_20 = ImageIO.read(CalendarDay.class
					.getResource("number_20.png"));
			number_21 = ImageIO.read(CalendarDay.class
					.getResource("number_21.png"));
			number_22 = ImageIO.read(CalendarDay.class
					.getResource("number_22.png"));
			number_23 = ImageIO.read(CalendarDay.class
					.getResource("number_23.png"));
			number_24 = ImageIO.read(CalendarDay.class
					.getResource("number_24.png"));
			number_25 = ImageIO.read(CalendarDay.class
					.getResource("number_25.png"));
			number_26 = ImageIO.read(CalendarDay.class
					.getResource("number_26.png"));
			number_27 = ImageIO.read(CalendarDay.class
					.getResource("number_27.png"));
			number_28 = ImageIO.read(CalendarDay.class
					.getResource("number_28.png"));
			number_29 = ImageIO.read(CalendarDay.class
					.getResource("number_29.png"));
			number_30 = ImageIO.read(CalendarDay.class
					.getResource("number_30.png"));
			number_31 = ImageIO.read(CalendarDay.class
					.getResource("number_31.png"));

		} catch (Exception ex) {
		}
	}
	private static GetCalendar getCalendar = new GetCalendar();

	/*
	 * 构造
	 */

	/*
	 * 创建图片MAP集合
	 */
	public static Map<String, BufferedImage> buf() {
		Map<String, BufferedImage> buf = new HashMap<String, BufferedImage>();
		buf.put("1", number_1);
		buf.put("2", number_2);
		buf.put("3", number_3);
		buf.put("4", number_4);
		buf.put("5", number_5);
		buf.put("6", number_6);
		buf.put("7", number_7);
		buf.put("8", number_8);
		buf.put("9", number_9);
		buf.put("10", number_10);
		buf.put("11", number_11);
		buf.put("12", number_12);
		buf.put("13", number_13);
		buf.put("14", number_14);
		buf.put("15", number_15);
		buf.put("16", number_16);
		buf.put("17", number_17);
		buf.put("18", number_18);
		buf.put("19", number_19);
		buf.put("20", number_20);
		buf.put("21", number_21);
		buf.put("22", number_22);
		buf.put("23", number_23);
		buf.put("24", number_24);
		buf.put("25", number_25);
		buf.put("26", number_26);
		buf.put("27", number_27);
		buf.put("28", number_28);
		buf.put("29", number_29);
		buf.put("30", number_30);
		buf.put("31", number_31);

		return buf;
	}

	// 创建Map图片数组
	Map<String, BufferedImage> buf = CalendarDay.buf();
	public Set<String> set = buf.keySet();

	//
	/*
	 * 绘制图片.根据周几开始, 把第一个填好周几然后开始顺序排列
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		g.drawImage(bacakground, 0, 0, null);
		paintDay(g);
		paintDate(g);
		diaryDate(g);
		paintToday(g);
		diaryweather(g);
	}

	/*
	 * 绘制日期
	 */

	public void paintDay(Graphics g) {
		int week = getCalendar.getWeek(mon);
		// System.out.println(week); 显示是周几

		x = 29 + 49 * (week - 1);
		int y = 130;
		int h = buf.size();
		int month = getCalendar.getMonth(mon);
		switch (month) { // 判断每个月有几天
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 9:
		case 11:
			h = 30;
			break;
		case 2:
			if (getCalendar.getYear() % 400 == 0
					|| getCalendar.getYear() % 100 != 0
					&& getCalendar.getYear() % 4 == 0) {
				h = 29;
			} else {
				h = 28;
			}

			break;
		}
		a = new int[h];
		b = new int[h];
		/*
		 * 该方法通过得知第一个图片的长度 然后依次遍历 通过这个循环还可以得到他们坐标的数组
		 */
		for (int i = 1; i <= h; i++) {
			String str = "" + i; // 把这个换成字符型才可以用get()
			if (x > 320 && i != 1) {
				x = x - 343;
				y = y + 49;
			}
			if (x < 300 && i != 1) {
				x += 49;
			}
			g.drawImage(buf.get(str), x, y, null);

			a[i - 1] = x;
			b[i - 1] = y;
		}
	}

	GetCalendar get = new GetCalendar(); // 创建一个对象得到时间

	public void paintDate(Graphics g) {
		int x = 150, y = 60;
		time = get.getlabel(mon);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0x5580FF));
		g.drawString(time, x, y);

	}

	/*
	 * 在面板上用label画出时间
	 */
	public javax.swing.JLabel Clock() {
		label = new JLabel("current Time:");
		label.setBounds(400, 50, 200, 50);
		add(label);
		label.setText(getTime());
		label.setFont(new java.awt.Font("Dialog", 1, 15));
		setVisible(true);
		Timer timer = new Timer();
		timer.schedule(new RemindTask(), 0, 1000);
		return label;
	}

	public void diaryDate(Graphics g) {
		int x = 420, y = 120;
		time = get.getlabel(mon);// 获得鼠标点的那一天
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0x5500FF));
		g.drawString(name + "日记", x, y);

	}
	public void diaryweather(Graphics g) {
		int x = 410, y = 53;
		
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0xFF0000));
		g.drawString("昆明  多云 11°~23°", x, y);

	}

	public void paintToday(Graphics g) {
		todayX = a[getCalendar.gettoday() - 1]; // 获取今天的坐标
		todayY = b[getCalendar.gettoday() - 1]; // 通过图片坐标获得今天的坐标
		g.drawImage(today, todayX, todayY, null);
	}

	public String getTime() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 " + "\n"
				+ "HH:mm:ss");
		time = format.format(date);

		return time;
	}

	private class RemindTask extends TimerTask {
		public void run() {
			label.setText(getTime());
		}
	}

	//
	// private Timer timer; // 创建一个计时器
	// private int interval = 1000; // 定义一个时间间隔 毫秒为单位
	static int x = 0;
	static int y = 0;

	public void action() {
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) { // 获取鼠标的坐标
				if (state == DAY) {
					x = e.getX();
					y = e.getY();
				}

			}

			public void mouseClicked(MouseEvent e) {
				if (state == DAY && (x < 80 && x > 30 && y < 80 && y > 30)) {
					// 检测xy坐标是否在范围内,是的话是更换月份
					mon--;
					repaint(0, 0, 377, 450); // 控制repaint的范围;
				}
				if (state == DAY && (x > 330 && x < 380 && y < 80 && y > 30)) {
					mon++;
					repaint(0, 0, 377, 450);
				}

				for (int i = 0; i < a.length; i++) {
					if (x > a[i] && x < (a[i] + 49) && y > b[i]
							&& y < (b[i] + 50)) { // 显示点击的的是哪一天.
						i = i + 1;// 数组从0开始,日期从1开始
						name = getCalendar.getlabel(mon);// 得到年月
						name = name + "-" + i;// 直接获得具体的哪天 i是天书
						jta.setText("");// 清空
						repaint(417, 97, 150, 30); // 重绘.日记区域

						/*
						 * 下面代码是用来读取哪一天的值
						 */
						File file = new File("./日记/" + name + ".txt");
						/*
						 * 每次点击之后,如果文件存在的话,就直接读取,如果文件不存在,就直接创建一个文件 用来保存
						 */
						if (!file.exists()) {
							try {
								file.createNewFile();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						BufferedReader reader = null;
						try {
							reader = new BufferedReader(
									new InputStreamReader( // 读取文件
											new FileInputStream("./日记/" + name
													+ ".txt"), "gbk"));
							String line = null;
							while ((line = reader.readLine()) != null) {
								jta.append(line);
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						} finally {
							try {
								reader.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		};
		this.addMouseListener(l); // 点击的监听
		this.addMouseMotionListener(l); // 鼠标的滑动事件
	}

	private javax.swing.JButton getJButton() {
		if (jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(380, 425, 71, 27);
			jButton.setText("保存");
			jButton.addActionListener(this);

		}
		return jButton;
	}

	private javax.swing.JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setBounds(460, 425, 71, 27);
			jButton2.setText("清空");
			jButton2.addActionListener(this);

		}
		return jButton2;
	}
	private javax.swing.JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new javax.swing.JButton();
			jButton3.setBounds(540, 425, 71, 27);
			jButton3.setText("迷你");
			jButton3.addActionListener(this);

		}
		return jButton3;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton) {
			BufferedWriter bw = null;
			// 获取得到他的字符
			try {
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("./日记/" + name + ".txt"), "gbk"));
				for (String value : jta.getText().split("\n")) {// 获取数组 //
																// .gettext的
					bw.write(value);
					System.out.println(value);
					bw.newLine();// 换行
					System.out.println("到这里了");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		if (e.getSource() == jButton2) {
			jta.setText("");
		}
		if(e.getSource()==jButton3){
			
			new watch(true);
			jFrame.setVisible(false);
			
		}
	}

	/**
	 * 以下是文本框的制作
	 * 
	 * @param args
	 */
	/**
	 * 先检查有没有文件,没有就创建 有的话就载入一个,然后写入操作进行的时候就写
	 * 
	 * @param str
	 * @return
	 */
	
	public JTextArea JTA(String str) {
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setLocation(377, 129);
		jta.setSize(230, 294);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));
		jta.setLineWrap(true);// 激活自动换行功能
		jta.setWrapStyleWord(true);// 激活断行不断字功能
		jta.setBackground(Color.pink);
		add(new JScrollPane(jta), BorderLayout.EAST);

		File file = new File("./日记/" + str + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader( // 读取文件
					new FileInputStream("./日记/" + str + ".txt"), "gbk"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				jta.append(line);
				// 线程暂停,以看到读取过程效果

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return jta;
	}

	public static void main(String[] args) {
      
		
		CalendarDay game = new CalendarDay();// 新的画板
		jFrame.add(game.getJButton(), null);
		jFrame.add(game.getJButton2(), null);
		jFrame.add(game.getJButton3(), null);
		jFrame.add(game.Clock());
		jFrame.add(game.JTA(new SimpleDateFormat("yyyy-MM-d").format(Calendar
				.getInstance().getTime())));
		jFrame.add(game); // 添加画板
		jFrame.setSize(WIDTH, HEIGHT);// 大小
		 jFrame.setUndecorated(true);
		jFrame.setAlwaysOnTop(true); // 始终最前
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);// 设置相对位置 nuLl居中
		jFrame.setVisible(true);// 可见 尽快调用panit()
		jFrame.setBackground(new Color(0,0,0,0));
		game.action();

	}

	
	
}
