public class Thread2 implements Runnable{ //2 Задание (три потока запускать из класса ThreeThread)
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + " thread:\t" + i + " делится на 10 без остатка");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
    }
}
