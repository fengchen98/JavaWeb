package thread_0523;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 17:11
 */
public class ThreadDemo51 {
    static ThreadLocal<MyBigClass> threadLocal=new ThreadLocal<>();

    static class MyBigClass{
        private byte[] bytes=new byte[1024*1024];
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 5; i++) {
            int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("编号："+finalI+"执行了存储方法");
                    MyBigClass myBigClass=new MyBigClass();
                    threadLocal.set(myBigClass);
                }
            });
        }
    }
}
