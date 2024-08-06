package org.example;

public class Consumer implements Runnable {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int sum = 0;
        try {
            while (true) {
                int number = buffer.remove();
                sum += number;
                System.out.println("Consumed: " + number + ", Current Sum: " + sum);
                Thread.sleep(150); // Simulate time taken to consume a number
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

