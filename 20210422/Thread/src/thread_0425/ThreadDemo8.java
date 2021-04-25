package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

/**
 * 方法5:实现Runnable,使用匿名内部类+lambada
 */
public class ThreadDemo8 {


    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("当前线程的名称："+Thread.currentThread().getName());
        });
        thread.start();
    }
}
