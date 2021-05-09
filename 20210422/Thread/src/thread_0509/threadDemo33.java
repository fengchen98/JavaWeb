package thread_0509;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-09 11:10
 */
public class threadDemo33 {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1进入线程方法");
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1执行完成");
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        //唤醒线程
        synchronized (lock){
            lock.notify();
        }
    }
}
