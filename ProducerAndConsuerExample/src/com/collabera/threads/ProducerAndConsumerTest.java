package com.collabera.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerTest {

	public static void main(String[] args) {
		// shared resource
		Queue<Integer> sharedQueue = new LinkedList<>();
		
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
		
		Thread prouderThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		prouderThread.start();
		consumerThread.start();
		

	}

}
