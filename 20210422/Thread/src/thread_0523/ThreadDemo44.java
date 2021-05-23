package thread_0523;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 11:11
 */
public class ThreadDemo44 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 10; i++) {
            int finalI=i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("编号：%d,线程名：%s",finalI,Thread.currentThread().getName()));
                }
            });
        }
        executor.shutdown();
    }
}
