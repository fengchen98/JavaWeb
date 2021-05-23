package thread_0523;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 15:29
 */
public class ThreadDemo48 {
    static ThreadLocal<SimpleDateFormat> threadLocal=
            //ThreadLocal.withInitial(()->new SimpleDateFormat("mm:ss"));
    ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            System.out.println("执行了初始化方法");
            return new SimpleDateFormat("mm:ss");
        }
    });
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 1; i < 1001; i++) {
            int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date=new Date(finalI*1000);
                    myFormat(date);
                }
            });
        }
    }

    private static void myFormat(Date date) {
        String result=threadLocal.get().format(date);
        System.out.println("时间："+result);
    }
}
