public class Thread1 extends Thread{ //Первое задание про потоки
    Thread1(String name){
        super(name);
    }

    public void run() {
        System.out.printf("%s работает \n", Thread.currentThread().getName());
        int counter = 1;
        while (!isInterrupted()){
            System.out.println("Цикл" + counter++);
        }
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            System.out.println("Ошибка");
            interrupt();
        }

    }
}
