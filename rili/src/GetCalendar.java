
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class GetCalendar extends Num {
	/*
	 * ������ȡ�����ܼ�
	 */
	public static int gettoday(){
		Calendar calendar=Calendar.getInstance();
		int s=calendar.get(calendar.DAY_OF_MONTH);
		return s;
	}
	public static int getWeek(int a) {
		Calendar calendar = Calendar.getInstance();
	     calendar.add(calendar.MONTH, a);//�л����Ǹ��·�
//	     int s=calendar.get(calendar.MONTH);   //��õ�ǰ���·�
//	     s=s+1;
//	     System.out.println("����"+s);    
	     calendar.set(calendar.DAY_OF_MONTH,1);  //���õ�����µ�1��
		int i = calendar.get(calendar.DAY_OF_WEEK);//�õ��Ǹ���1�ŵ����ܼ�
//		System.out.println(i);
		return i == 1 ? 7 : i - 1;
	}
	public static int getWeek() {
		Calendar calendar = Calendar.getInstance();
		int i = calendar.get(calendar.DAY_OF_WEEK);
		return i == 1 ? 7 : i - 1;
	}
	 public static int getMonth(){
		 Calendar calendar =Calendar.getInstance();
		 int i=calendar.get(calendar.MONTH);
		 return  i+=1;
	 }
	 public static int getMonth(int a){
		 Calendar calendar =Calendar.getInstance();
		   calendar.add(calendar.MONTH,a);
		int  i=calendar.get(calendar.MONTH);
		 return  i+=1;
	 }
	 public static int getYear(){
		 Calendar calendar =Calendar.getInstance();
		 int i=calendar.get(calendar.YEAR);
		 return i;
		 
	 }
	 
	 public static String getlabel(int a){
		 Calendar calendar =Calendar.getInstance();
		 calendar.add(calendar.MONTH,a);
		 calendar.set(calendar.DAY_OF_MONTH,1); 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");//���ļ���ͳһ
		 Date date = calendar.getTime();
	String	time =sdf.format(date);
	return time;
	 }

}
