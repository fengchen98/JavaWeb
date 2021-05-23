package thread_0523;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 09:24
 */
public class ThreadDemo35 {
    public static void main(String[] args) {
        //参数1：核心线程数量
        //参数2：最大线程数量，要大于等于核心线程数
        //参数3：最大生命周期
        //参数4：时间单位
        //参数5：时间队列
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 6; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }

    }
}
