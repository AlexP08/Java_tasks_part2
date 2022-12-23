public class ThreeThread {
    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            new Thread(new Thread2(), String.valueOf(i)).start();
        }
    }
}
