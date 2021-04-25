package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

/**
 * 方法1：继承Thread
 */
public class ThreadDemo4 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("线程名称："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread=new MyThread();
        thread.start();
        System.out.println("当前线程的名称："+Thread.currentThread().getName());
    }
}
