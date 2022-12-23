public class Thread3 extends Thread{ //3 задание (3 потока в ThreeThread2 - запускать оттуда)
    private StringBuilder sb;

    public Thread3(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        synchronized (sb) {
            for (int i = 0; i < 100; i++) {
                System.out.print(sb);
            }
            System.out.println();
            char ch = sb.charAt(0);
            sb.setCharAt(0, ++ch);
        }
    }
}
