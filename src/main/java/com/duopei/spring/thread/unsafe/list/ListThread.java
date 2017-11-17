package com.duopei.spring.thread.unsafe.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListThread implements Runnable {

	private List<Object> list;
	private CountDownLatch countDownLatch;

	public ListThread() {
	}

	public ListThread(List<Object> list, CountDownLatch countDownLatch) {
		this.list = list;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// 给每个线程添加10个元素
		for (int i = 0; i < 10; i++) {
			list.add(new Object());
		}
		// 完成一个子线程
		countDownLatch.countDown();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			ThreadTest.test();
		}
	}

}

/**
 * 这里要比较的是arraylist 和Vector来测试
 * arraylist 是线程不安全的
 * Vector  线程安全的
 **/
class ThreadTest {

	public static void test() {
		// 用来测试的list集合
		List<Object> list = new ArrayList<Object>();
		//List<Object> list = new Vector<Object>();// TODO ArrayList/Vector模拟不同的场景
		// 线程数
		int threadCount = 10000;
		// 用来让主线等待thread 个执行完毕
		CountDownLatch count = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new ListThread(list, count));
			thread.start();
		}
		try {
			// 主线程所有都执行完成后，再向下执行
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}

}
