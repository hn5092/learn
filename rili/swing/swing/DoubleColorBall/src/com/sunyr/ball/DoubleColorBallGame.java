package swing.DoubleColorBall.src.com.sunyr.ball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class DoubleColorBallGame extends Panel implements ActionListener {
	public static final int WIDTH = 750;
	public static final int HEIGHT = 530;

	// 定义所要的图片
	public static BufferedImage background;
	public static BufferedImage redBall;
	public static BufferedImage blueBall;
	private static JButton startButton;
	private static JTextArea jta;
	private static BufferedImage button;

	private Integer RedNumber = 1;
	private RedBall redBall1 = new RedBall();// 定义6个红球
	private BlueBall blueBall1 = new BlueBall();
	private player p = new player();

	static {
		try {// 导入图片
			background = ImageIO.read(DoubleColorBallGame.class
					.getResource("background.png"));
			redBall = ImageIO.read(DoubleColorBallGame.class
					.getResource("redBall.png"));
			blueBall = ImageIO.read(DoubleColorBallGame.class
					.getResource("blueBall.png"));

		} catch (Exception e) {

		}
	}

	public void paint(Graphics g) {// 画板
		g.drawImage(background, 0, 0, null);
		paintRedBall(g);
		paintBlueBall(g);
		paintBlueNumber(g);
		paintRedNumber(g);
		paintNumber1(g);

	}

	public void paintRedNumber(Graphics g) {// 画红球的数字
		int x = 250; // x坐标
		int y = 250; // y坐标
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14); // 字体
		g.setColor(new Color(0x3A3B3B));
		g.setFont(font); // 设置字体
		for (int i = 0; i < 6; i++) {
			g.drawString(" " + redBall1.red1[i], x + (redBall1.width * (i)), y);
		}
	}

	public void paintBlueNumber(Graphics g) {// 画篮球的数字
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14); // 字体
		g.setColor(new Color(0x3A3B3B));
		g.setFont(font); // 设置字体
		g.drawString(" " + blueBall1.blue, 595, 248);
	}

	public void paintBlueBall(Graphics g) {// 画蓝球
		g.drawImage(blueBall1.image, blueBall1.x, blueBall1.y, null);
	}

	public void paintRedBall(Graphics g) {// 定义画笔,画红球

		for (int i = 4; i < 10; i++) {
			g.drawImage(redBall1.image, (redBall1.width * (i)), redBall1.y,
					null);

		}
	}

	public void paintNumber1(Graphics g) {// 玩家输入的号码
		int x = 25; // x坐标
		int y = 500; // y坐标
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 14); // 字体
		g.setColor(new Color(0x3A3B3B));
		g.setFont(font); // 设置字体
		for (int i = 0; i < 6; i++) {
			g.drawString(" " + p.No[i], x + (redBall1.width * (i)), y);
		}
	}

	private javax.swing.JButton getJButton() {// 添加按钮

		if (startButton == null) {
			startButton = new javax.swing.JButton();
			startButton.setBounds(593, 420, 118, 58);
			startButton.setText("START");
			startButton.addActionListener(this);
		}
		return startButton;
	}

	public JTextArea JTA() {// 定义输入框
		jta = new JTextArea(10, 15);
		jta.setTabSize(4);
		jta.setLocation(250, 420);
		jta.setSize(250, 40);
		jta.setFont(new Font("标楷体", Font.BOLD, 16));
		jta.setBackground(Color.green);
		jta.setText("21312");
		// jta.getText();//获取输入框内容
		return jta;
	}

	public void actionPerformed(ActionEvent e) {// 定义按钮监听事件
		if (e.getSource() == startButton) {
			System.out.println(jta.getText());
			redAndBlue();
			BlueNumber();
			repaint(250, 215, 399, 57);
		}
	}

	public static void main(String[] args) {// 主方法
		JFrame frame = new JFrame();// 定义画板
		DoubleColorBallGame game = new DoubleColorBallGame();
		frame.add(game.getJButton(), null);
		frame.add(game.JTA());

		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.redAndBlue();

	}

	/** 随机产生6个红球 + 一个蓝球 */
	public void redAndBlue() {
		Random rand = new Random();

		boolean[] flags = new boolean[33];
		int index;
		for (int i = 0; i < redBall1.red1.length; i++) {
			do {
				// 随机产生中奖的红球
				index = rand.nextInt(33);

			} while (flags[index]);

			redBall1.red1[i] = index;
			flags[index] = true;
		}

	}

	public void BlueNumber() {
		Random rand = new Random();

		int blue = rand.nextInt(17);

		blueBall1.blue = blue;
	}

}
