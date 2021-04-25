package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 方法6:实现Callable+future
 * 创建线程并得到执行结果
 */
public class ThreadDemo9 {

    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int num=new Random().nextInt(10);
            System.out.println("子线程的名称："+Thread.currentThread().getName()+"随机数:"+num);

            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable=new MyCallable();
        //创建FutureTask来接收返回值
        FutureTask<Integer> futureTask=new FutureTask<>(myCallable);

        Thread thread=new Thread(futureTask);
        thread.start();
        int result=futureTask.get();
        System.out.println(String.format("线程名：%s,数字：%d",Thread.currentThread().getName(),result));
    }
}
