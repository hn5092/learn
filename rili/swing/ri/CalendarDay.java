package ri;

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
import java.util.Random;
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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class CalendarDay extends JPanel implements ActionListener {
	// ���þ�̬ͼƬ
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
	private JLabel jLabel;// ʱ����ʾ��ǩ
	private JTextField jTextField; // �ı�
	private JButton jButton; // ��ť
	private JButton jButton2; // ��ť
	private JButton jButton3; // ��ť
	private JButton jButton4; // ��ť
	private JLabel label;// ʱ�����
	private JLabel label2;
	private JTextField text;
	private String time = null;
	static int[] a;// ÿһ��������X������
	static int[] b;// ûһ��������Y������
	static JTextArea jta = null;
	String str;
	private static int todayX; // ���������
	private static int todayY;// �����������
	static String name = new SimpleDateFormat("yyyy-MM-d").format(Calendar
			.getInstance().getTime()); // �������
	public static JFrame jFrame = new JFrame("Fly");// �������
	BufferedWriter bw = null;
 public static final  int luckNumber=(int) (Math.random()*100);
	static String luck ;
	static {
		if(luckNumber>90){
			luck=luckNumber+"��,�����,�ú����ܰ�(��)";
		}else if(luckNumber>60){
			luck=luckNumber+"��,Ŭ���㻹�ǲ����(С��)";
		} else if(luckNumber>10){
			luck=luckNumber+"��,����ͨͨ��(һ��)";
		}else {
			luck=luckNumber+"��,�浹ù,�벻����սһ���Լ�����Ʒ(̫˥��)";
		}
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
	 * ����
	 */

	/*
	 * ����ͼƬMAP����
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

	// ����MapͼƬ����
	Map<String, BufferedImage> buf = CalendarDay.buf();
	public Set<String> set = buf.keySet();

	//
	/*
	 * ����ͼƬ.�����ܼ���ʼ, �ѵ�һ������ܼ�Ȼ��ʼ˳������
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
		paintLuck(g);
	}

	/*
	 * ��������
	 */

	public void paintDay(Graphics g) {
		int week = getCalendar.getWeek(mon);
		// System.out.println(week); ��ʾ���ܼ�

		x = 29 + 49 * (week - 1);
		int y = 130;
		int h = buf.size();
		int month = getCalendar.getMonth(mon);
		switch (month) { // �ж�ÿ�����м���
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
		 * �÷���ͨ����֪��һ��ͼƬ�ĳ��� Ȼ�����α��� ͨ�����ѭ�������Եõ��������������
		 */
		for (int i = 1; i <= h; i++) {
			String str = "" + i; // ����������ַ��Ͳſ�����get()
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

	GetCalendar get = new GetCalendar(); // ����һ������õ�ʱ��

	public void paintDate(Graphics g) {
		int x = 150, y = 60;
		time = get.getlabel(mon);
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0x5580FF));
		g.drawString(time, x, y);

	}
	public void paintLuck(Graphics g) {
		int x = 140, y = 447;
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		g.setColor(new Color(0x5580FF));
		if(state==0){
			g.drawString("", x, y);
		}else{
		g.drawString(luck, x, y);
		}
	}
	/*
	 * ���������label����ʱ��
	 */
	public javax.swing.JLabel Clock() {
		label = new JLabel("current Time:");
		label.setBounds(400, 55, 200, 50);
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
		time = get.getlabel(mon);// ����������һ��
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0x5500FF));
		g.drawString(name + "�ռ�", x, y);

	}

	public void diaryweather(Graphics g) {
		int x = 410, y = 53;

		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.setColor(new Color(0xFF0000));
		g.drawString("����  ���� 11��~23��", x, y);

	}

	public void paintToday(Graphics g) {
		todayX = a[getCalendar.gettoday() - 1]; // ��ȡ���������
		todayY = b[getCalendar.gettoday() - 1]; // ͨ��ͼƬ�����ý��������
		g.drawImage(today, todayX, todayY, null);
	}

	public String getTime() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd�� " + "\n"
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
	// private Timer timer; // ����һ����ʱ��
	// private int interval = 1000; // ����һ��ʱ���� ����Ϊ��λ
	static int x = 0;
	static int y = 0;

	public void action() {
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) { // ��ȡ��������
				
					x = e.getX();
					y = e.getY();
			

			}

			public void mouseClicked(MouseEvent e) {
				if ( (x < 80 && x > 30 && y < 80 && y > 30)) {
					// ���xy�����Ƿ��ڷ�Χ��,�ǵĻ��Ǹ����·�
					mon--;
					repaint(0, 0, 377, 450); // ����repaint�ķ�Χ;
				}
				if ( (x > 330 && x < 380 && y < 80 && y > 30)) {
					mon++;
					repaint(0, 0, 377, 450);
				}

				for (int i = 0; i < a.length; i++) {
					if (x > a[i] && x < (a[i] + 49) && y > b[i]
							&& y < (b[i] + 50)) { // ��ʾ����ĵ�����һ��.
						i = i + 1;// �����0��ʼ,���ڴ�1��ʼ
						name = getCalendar.getlabel(mon);// �õ�����
						name = name + "-" + i;// ֱ�ӻ�þ�������� i������
						jta.setText("");// ���
						repaint(417, 97, 150, 30); // �ػ�.�ռ�����

						/*
						 * ���������������ȡ��һ���ֵ
						 */
						File file = new File("./�ռ�/" + name + ".txt");
						/*
						 * ÿ�ε��֮��,����ļ����ڵĻ�,��ֱ�Ӷ�ȡ,����ļ�������,��ֱ�Ӵ���һ���ļ� ��������
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
									new InputStreamReader( // ��ȡ�ļ�
											new FileInputStream("./�ռ�/" + name
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
		this.addMouseListener(l); // ����ļ���
		this.addMouseMotionListener(l); // ���Ļ����¼�
	}

	private javax.swing.JButton getJButton() {
		if (jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setBounds(380, 425, 71, 27);
			jButton.setText("����");
			jButton.addActionListener(this);

		}
		return jButton;
	}

	private javax.swing.JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setBounds(460, 425, 71, 27);
			jButton2.setText("���");
			jButton2.addActionListener(this);

		}
		return jButton2;
	}

	private javax.swing.JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new javax.swing.JButton();
			jButton3.setBounds(540, 425, 71, 27);
			jButton3.setText("����");
			jButton3.addActionListener(this);

		}
		return jButton3;
	}

	private javax.swing.JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new javax.swing.JButton();
			jButton4.setBounds(50, 425, 90, 27);
			jButton4.setText("��������");
			jButton4.addActionListener(this);

		}
		return jButton4;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jButton) {
			BufferedWriter bw = null;
			// ��ȡ�õ������ַ�
			try {
				bw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream("./�ռ�/" + name + ".txt"), "gbk"));
				for (String value : jta.getText().split("\n")) {// ��ȡ���� //
																// .gettext��
					bw.write(value);
					System.out.println(value);
					bw.newLine();// ����
					System.out.println("��������");
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
		if (e.getSource() == jButton3) {

			new watch(true);
			jFrame.setVisible(false);

		}
		if (e.getSource() == jButton4) {
				state=1;
				repaint(140,407,200,50);
		}
	}

	/**
	 * �������ı��������
	 * 
	 * @param args
	 */
	/**
	 * �ȼ����û���ļ�,û�оʹ��� �еĻ�������һ��,Ȼ��д��������е�ʱ���д
	 * 
	 * @param str
	 * @return
	 */

	public JTextArea JTA(String str) {
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setLocation(377, 129);
		jta.setSize(230, 294);
		jta.setFont(new Font("�꿬��", Font.BOLD, 16));
		jta.setLineWrap(true);// �����Զ����й���
		jta.setWrapStyleWord(true);// ������в����ֹ���
		jta.setBackground(Color.pink);
		add(new JScrollPane(jta), BorderLayout.EAST);

		File file = new File("./�ռ�/" + str + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader( // ��ȡ�ļ�
					new FileInputStream("./�ռ�/" + str + ".txt"), "gbk"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				jta.append(line);
				// �߳���ͣ,�Կ�����ȡ����Ч��

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return jta;
	}

	public static void main(String[] args) {

		CalendarDay game = new CalendarDay();// �µĻ���
		jFrame.add(game.getJButton(), null);
		jFrame.add(game.getJButton2(), null);
		jFrame.add(game.getJButton3(), null);
		jFrame.add(game.getJButton4(), null);
		jFrame.add(game.Clock());
		jFrame.add(game.JTA(new SimpleDateFormat("yyyy-MM-d").format(Calendar
				.getInstance().getTime())));
		jFrame.add(game); // ��ӻ���
		jFrame.setSize(WIDTH, HEIGHT);// ��С
		jFrame.setUndecorated(true);
		jFrame.setAlwaysOnTop(true); // ʼ����ǰ
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);// �������λ�� nuLl����
		jFrame.setVisible(true);// �ɼ� �������panit()

		game.action();

	}

}
