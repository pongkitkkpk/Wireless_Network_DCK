public class Javasynctest_chatgpt {

    // Shared variable among threads
    private static volatile int balance = 0;

    public static void main(String[] args) {
        // Create and start three threads
        Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");
        Thread thread3 = new Thread(new MyRunnable(), "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final balance value
        System.out.println("Final balance: " + balance);
    }

    // Runnable class that implements the thread behavior
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Each thread runs 10,000 rounds
            for (int i = 0; i < 10000; i++) {
                // Synchronize the access to the shared variable
                synchronized (Javasynctest_chatgpt.class) {
                    balance++; // Increment the balance
                }
            }
        }
    }
}
