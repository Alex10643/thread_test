public class Main {
    static boolean isWin = false;
    public static void main(String[] args) {
        int random = (int) (Math.random() * 1_000_000_000);
        System.out.println(random);
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (!isWin) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread player = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isWin) {
                    int guessNumber = (int) (Math.random() * 1_000_000_000);
                    if (guessNumber == random) {
                        isWin = true;
                        System.out.println(guessNumber);
                    }
                }
            }
        });
        timer.start();
        player.start();
    }
}