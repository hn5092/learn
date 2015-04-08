

/*
 * 显示系统当前时间
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Time extends JPanel {  
	  JLabel label;
	  JTextField text;
    public static void main(String[] args) {  
    	

  /*
   * 重写run()将Date时间转换为SimpleDateFormat时间显示。
   * (non-Javadoc)
   * @see java.util.TimerTask#run()
   */
        Timer timer = new Timer();  
        TimerTask task = new TimerTask(){  
            public void run() { 
            	Calendar calendar=Calendar.getInstance();
        		Date date=(Date) calendar.getTime();
        		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        		String time=null;
        		//Timer timer = new Timer();
        		 time = format.format(date);
                System.out.println(time);  
            }             
        };  
      
       // Date time = new Date();  
        //long delay = 1000;  
        //long period = 5000;  
          
        //启动定时任务，立即执行壹次并退出  
//      timer.schedule(task, time);  
          
        //启动定时任务，立即执行壹次，然后每隔两秒执行壹次  
        timer.schedule(task, 0, 1000);  
          
        //启动定时任务，从现在起过两秒执行壹次然后退出  
//      timer.schedule(task, delay);  
          
        //启动定时任务，从现在起过两秒以后，每隔五秒执行壹次  
//      timer.schedule(task, delay, period);  
          
    }  
} 