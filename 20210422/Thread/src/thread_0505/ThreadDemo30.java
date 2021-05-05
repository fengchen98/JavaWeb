package thread_0505;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-05 20:50
 */
public class ThreadDemo30 {
    //全局变量
    private static int number=0;
    private static final int maxsize=10000;
    public static void main(String[] args) throws InterruptedException {
        Lock lock=new ReentrantLock();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    lock.lock();
                    try {
                        number++;
                    } finally {
                        lock.unlock();

                    }
                }
            }
        });
        t1.start();
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxsize; i++) {
                    lock.lock();
                    try {
                        number--;
                    } finally {
                        lock.unlock();

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
