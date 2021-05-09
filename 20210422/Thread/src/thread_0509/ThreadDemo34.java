package thread_0509;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-09 11:46
 */
public class ThreadDemo34 {
    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1拥有锁lock，进入休眠");
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1执行完成，释放lock");
                }
            }
        });
        t1.start();

        Thread.sleep(1000);
        //主线程试图获取锁
        synchronized (lock){
            System.out.println("主线程获取到锁lock");
        }
    }
}
