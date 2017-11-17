package com.duopei.spring.thread.unsafe.list;

import java.util.ArrayList;
import java.util.List;

public class ThreadTestT implements Runnable {

	private List<Object> list;

	public ThreadTestT() {
	}

	public ThreadTestT(List<Object> list) {
		this.list = list;
	}

	@Override
	public void run() {
		// 给每个线程添加10个元素
		for (int i = 0; i < 10; i++) {
			list.add(new Object());
		}
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
class ThreadTests {

	public static void test() {
		// 用来测试的list集合
		List<Object> list = new ArrayList<Object>();
		//List<Object> list = new Vector<Object>();// TODO ArrayList/Vector模拟不同的场景
		// 线程数
		// 用来让主线等待thread 个执行完毕
		for (int i = 0; i < 10000; i++) {
			Thread thread = new Thread(new ThreadTestT(list));
			thread.start();
		}
		System.out.println(list.size());
	}

}
