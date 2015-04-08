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
 * ʹ��Collections�����ϻ�Mapת��Ϊ�̰߳�ȫ��
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
		 * ת��Ϊ�̰߳�ȫ��List
		 */
		list 
			= Collections.synchronizedList(list);
		
		//���淵�صľ����̰߳�ȫ��list�ˣ�Ԫ��Ҳ��
		System.out.println(list);
		
		
		Set<String> set	
					= new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("three");
		
		//�����е�set����ת��Ϊһ���̰߳�ȫ��
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		
		Map<String, Integer> map 
							= new HashMap<String, Integer>();
		map.put("����", 89);
		map.put("��ѧ", 99);
		map.put("Ӣ��", 90);
		
		//�����е�Map����ת��Ϊһ���̰߳�ȫ��
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
	}
}
