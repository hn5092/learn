
import java.awt.Insets;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Clock extends JFrame {

    JLabel label;
    JTextField text;
    String time = null;
    
    public Clock() {
//        label = new JLabel("current Time:");
        text = new JTextField();
        setBounds(400, 300, 300, 100);
        setLayout(null);
//        label.setBounds(10, 10, 100, 20);
        text.setBounds(110, 10, 150, 20);
//        add(label);
        add(text);
        text.setText(getTime());
        setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1);
    }

    public String getTime() {
    	Calendar calendar = Calendar.getInstance();
    	  Date date = (Date) calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:ms");
        time = format.format(date);

         return time;
    }

    public static void main(String[] args) {
         new Clock();
    }

    private class RemindTask extends TimerTask {
         public void run() {
             text.setText(getTime());
         }
    }
}
