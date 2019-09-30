package com.collabera.threads;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	
	private Queue<Integer> sharedQueue;
	private final int MAX_SIZE = 5;
	
	public Producer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	
	public void run() {
		
		// infinite loop
		while(true) {
			synchronized(sharedQueue) {
				// if size of queue is 5, producer has to go into
				// waiting state
				while (sharedQueue.size() == 5) {
					try {
						System.out.println("Producer is waiting to consume object by consumer");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Random random = new Random();
				int data = random.nextInt(MAX_SIZE);
				sharedQueue.add(data);
				System.out.println("Produced::"+data);
				// once the producer thread is placed into a waiting state, and the notify() method is called
				// on sharedQueue then the Consumer thread is awakened because it shares this resource.
				sharedQueue.notify();
				
			}
			
			
		}
		
	}

}
