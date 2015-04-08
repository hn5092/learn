package swing.DoubleColorBall.src.com.sunyr.ball;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * 使用Collections将集合或Map转换为线程安全的
 * @author Administrator
 *
 */


public class SyncAPIDemo {
	public static void main(String[] args) {
		List<String> list 
						= new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		
		/**
		 * 转换为线程安全的List
		 */
		list 
			= Collections.synchronizedList(list);
		
		//上面返回的就是线程安全的list了，元素也在
		System.out.println(list);
		
		
		Set<String> set	
					= new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		
		//将现有的set集合转换为一个线程安全的
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		Map<String, Integer> map 
							= new HashMap<String, Integer>();
		map.put("语文", 89);
		map.put("数学", 99);
		map.put("英语", 90);
		
		//将现有的Map集合转换为一个线程安全的
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
	}
}
