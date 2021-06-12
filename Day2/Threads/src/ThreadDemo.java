public class ThreadDemo {
    public static void main(String[] args){
        new SimpleThread("Thread object1").start();
        new SimpleThread("Thread object2").start();
        new Thread(new SimpleThread("runnable object")).start();
    }
}
