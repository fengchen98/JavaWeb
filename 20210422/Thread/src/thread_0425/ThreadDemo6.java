package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

/**
 * 方法3:实现Runnable
 */
public class ThreadDemo6 {

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("当前线程的名称："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
