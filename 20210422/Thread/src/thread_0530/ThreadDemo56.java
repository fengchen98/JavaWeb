package thread_0530;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-30 09:44
 */
public class ThreadDemo56 {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            final int finalI=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(finalI*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    latch.countDown();
                }
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都到达终点，公布排名");

    }
}
