public class ThreeThread2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        Thread3[] threads = new Thread3[]{
                new Thread3(sb),
                new Thread3(sb),
                new Thread3(sb)
        };
        for (Thread3 thread : threads) {
            thread.start();
        }
    }
}
