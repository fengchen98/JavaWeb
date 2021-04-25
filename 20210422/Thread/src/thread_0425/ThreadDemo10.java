package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 方法6:实现Callable+future
 * 创建线程并得到执行结果
 */
public class ThreadDemo10 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("开始时间"+new Date());
//        //第一种休眠的方式
//        Thread.sleep(1000);
//        //第二种休眠的方式
//        TimeUnit.SECONDS.sleep(1);
          //第三种休眠的方式
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("结束时间"+new Date());

    }
}
