package ri;
/*
 * ��ʾϵͳ��ǰʱ��
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
   * ��дrun()��Dateʱ��ת��ΪSimpleDateFormatʱ����ʾ��
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
          
        //������ʱ��������ִ��Ҽ�β��˳�  
//      timer.schedule(task, time);  
          
        //������ʱ��������ִ��Ҽ�Σ�Ȼ��ÿ������ִ��Ҽ��  
        timer.schedule(task, 0, 1000);  
          
        //������ʱ���񣬴������������ִ��Ҽ��Ȼ���˳�  
//      timer.schedule(task, delay);  
          
        //������ʱ���񣬴�������������Ժ�ÿ������ִ��Ҽ��  
//      timer.schedule(task, delay, period);  
          
    }  
} 