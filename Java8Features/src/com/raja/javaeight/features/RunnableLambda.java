package com.raja.javaeight.features;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException{

		/*
		 * Runnable task = new Runnable() {
		 * 
		 * @Override public void run() {
		 * System.out.println("Hi..Thread name is :"+Thread.currentThread().getName());
		 * } };
		 */
		
		Runnable taskLambda = ()-> System.out.println("Hi..Thread name is :"+Thread.currentThread().getName());
		
		for ( int i=0 ; i<4; i++) {
			Thread t  = new Thread(taskLambda);
			t.start();
			t.join();
		}
	}

}
