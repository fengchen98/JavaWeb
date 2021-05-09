package thread_0509;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-09 10:00
 */
public class ThreadDemo31 {
    public static void main(String[] args) {
        Object lockA=new Object();
        Object lockB=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA){
                    System.out.println("线程1得到锁A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1尝试获取锁B");
                    synchronized (lockB){
                        System.out.println("线程1得到锁B");
                    }
                }
            }
        },"t1");
        t1.start();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB){
                    System.out.println("线程2得到锁B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2尝试获取锁A");
                    synchronized (lockA){
                        System.out.println("线程1得到锁A");
                    }
                }
            }
        },"t2");
        t2.start();

    }
}
