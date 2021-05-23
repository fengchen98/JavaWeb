package thread_0523;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 10:14
 */
public class ThreadDemo40 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 11; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务：" + finalI + "线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
