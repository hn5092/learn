
import java.util.Calendar;


public class Day extends Num{
public Day(int x,int y){
	width = image.getWidth();
	height = image.getHeight(); 
	this.x=x;
	this.y=y;
	
}
public static int getweek() {
	Calendar calendar = Calendar.getInstance();
	int i = calendar.get(calendar.DAY_OF_WEEK);
	return i == 1 ? 7 : i - 1;
}
}
