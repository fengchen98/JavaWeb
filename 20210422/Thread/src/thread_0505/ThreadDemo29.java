package thread_0505;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-05 20:09
 */
public class ThreadDemo29 {
    //全局变量
    private static int number=0;
    private static final int maxsize=10000;
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        Object lock2=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    synchronized (lock){
                        number++;

                    }
                }

            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    synchronized (lock){
                        number--;
                    }
                }
            }
        });
        t2.start();
        //等待线程1和线程2执行完
        t1.join();
        t2.join();
        System.out.println(number);

    }
}
