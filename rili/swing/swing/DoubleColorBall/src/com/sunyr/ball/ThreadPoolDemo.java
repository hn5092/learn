package swing.DoubleColorBall.src.com.sunyr.ball;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�
 * ���ڽ����
 * 1.�̵߳�����
 * 2.�߳������Ŀ���
 * @author Administrator
 *
 */

public class ThreadPoolDemo {
	public static void main(String[] args) {
		
		//����һ������Ϊ2���̵߳��̳߳�
		ExecutorService threadPool	
								= Executors.newFixedThreadPool(2);
		for (int i = 1; i <= 5; i++) {
			MyRunnable runnable
			               = new MyRunnable("����"+i);
			
			//�����񽻸��̳߳أ�ʹ�������߳�����
			threadPool.execute(runnable);
		}
		
		
	}
}

class MyRunnable implements Runnable{
	//�������췽��
	private String taskName;
	public MyRunnable(String taskName){
		this.taskName = taskName;
	}
	
	public void run() {
		//��ȡ���е�ǰ������߳�
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"����"+taskName);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+"����"+taskName+"���");
	}
	
}
