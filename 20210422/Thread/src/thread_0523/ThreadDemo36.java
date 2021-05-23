package thread_0523;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 09:48
 */
public class ThreadDemo36 {
    private  static int count=1;

    public static void main(String[] args) {
        ThreadFactory threadFactory=new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread=new Thread(r);
                thread.setName("myThreadPool-"+(count++));
                return thread;
            }
        };
        ThreadPoolExecutor executor=
                new ThreadPoolExecutor(5,5,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000),threadFactory);
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }
    }
}
