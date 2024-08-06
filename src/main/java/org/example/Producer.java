package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final Random random;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = random.nextInt(100);
                System.out.println("Produced: " + number);
                buffer.add(number);
                Thread.sleep(100); // Simulate time taken to produce a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

