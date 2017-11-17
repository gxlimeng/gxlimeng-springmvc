package com.duopei.spring.thread.unsafe;

/**
 * 线程安全第一种因素：程序中有变量的读取、写入或判断操作
 * 
 * 
 * 线程安全：就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用。不会出现数据不一致或者数据污染。
 * 线程不安全：就是不提供数据访问保护，有可能出现多个线程先后更改数据造成所得到的数据是脏数据
 * 
 * 	线程安全问题都是由全局变量及静态变量引起的。
 * 若每个线程中对全局变量、静态变量只有读操作，而无写操作，一般来说，这个全局变量是线程安全的；若有多个线程同时执行写操作，一般都需要考虑线程同步，否则的话就可能影响线程安全
 * 
 * 
 * @author Administrator
 *
 */
public class UnsafeSequenceService {

	private int value;

	public  int getValue() {
		return value++;
	}

	public static void main(String[] args) throws InterruptedException {
		final UnsafeSequenceService us = new UnsafeSequenceService();
		Thread th1 = new Thread("th1") {
			@Override
			public void run() {
				System.out.println(super.getName() + ">" + us.getValue());
			}
		};

		Thread th2 = new Thread("th2") {
			@Override
			public void run() {
				System.out.println(super.getName() + ">" + us.getValue());
			}
		};

		th1.start();
		/**场景1》
		 * 如果不執行Thread.sleep(1000);
		 * 偶尔結果为：
		 * th1>0
		 * th2>1
		 * 或
		 * th2>0
		 * th1>1
		 * 
		 * 场景2》
		 * 如果执行Thread.sleep(1000);
		 * 结果为：
		 * 0 th1
		 * 1 th2
		 */
		//Thread.sleep(1000); //TODO 测试不同场景
		th2.start(); 
	}

}
