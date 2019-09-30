package com.collabera.threads;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
	
	private Queue<Integer> sharedQueue;
	
	public Consumer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	
	public void run() {
		
		// infinite loop
		while(true) {
			synchronized(sharedQueue) {
				// if size of queue is 5, producer has to go into
				// waiting state
				while (sharedQueue.isEmpty()) {
					try {
						System.out.println("Consumer is waiting to produce object by producer");
						// since there is nothing to consumer Consumer has to go into waiting state
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				// poll() retrieves and removes the head of the queue
				int data = sharedQueue.poll();
				System.out.println("Consumer::"+data);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sharedQueue.notify();
				
			}
			
			
		}
		
	}

}
