package thread_0530;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-30 10:02
 */
public class ThreadDemo57 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了Runnable()");
            }
        });
        for (int i = 1 ; i < 11; i++) {
            final int finalI=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(finalI*200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(Thread.currentThread().getName()+"等待其他人");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达了终点");
                }
            }).start();
        }
    }
}
