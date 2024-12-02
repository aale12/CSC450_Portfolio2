package CSC450;

public class CSC450Portfolio {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int countUpLim = 20;
        int countDownLim = 20;
        System.out.println("Beginning Count...");
        // creating threads for counting
        Thread countUpThread = new Thread(() -> countUp(countUpLim));
        Thread countDownThread = new Thread(() -> countDown(countDownLim));
        // start counting up
        countUpThread.start();

        try {
            // wait for count up to finish
            countUpThread.join();
        } catch (InterruptedException e) {
            System.out.println("Counting Up Was Interrupted.");
        }

        // counting down
        countDownThread.start();
    }

    //method to count up
    private static void countUp(int limit) {
        for (int i = 0; i <= limit; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Counting up thread interrupted.");
                return;
            }
            System.out.println("Counting up: " + i);
        }
    }

    // method to count down
    private static void countDown(int limit) {
        for (int i = limit; i >= 0; i--) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Counting down thread interrupted.");
                return;
            }
            System.out.println("Counting down: " + i);
        }
    }
}
