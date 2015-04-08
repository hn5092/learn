package swing.DoubleColorBall.src.com.sunyr.ball;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 用于解决：
 * 1.线程的重用
 * 2.线程数量的控制
 * @author Administrator
 *
 */

public class ThreadPoolDemo {
	public static void main(String[] args) {
		
		//创建一个容量为2个线程的线程池
		ExecutorService threadPool	
								= Executors.newFixedThreadPool(2);
		for (int i = 1; i <= 5; i++) {
			MyRunnable runnable
			               = new MyRunnable("任务"+i);
			
			//将任务交给线程池，使其分配空线程运行
			threadPool.execute(runnable);
		}
		
		
	}
}

class MyRunnable implements Runnable{
	//创建构造方法
	private String taskName;
	public MyRunnable(String taskName){
		this.taskName = taskName;
	}
	
	public void run() {
		//获取运行当前任务的线程
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"运行"+taskName);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println(t.getName()+"任务"+taskName+"完毕");
	}
	
}
