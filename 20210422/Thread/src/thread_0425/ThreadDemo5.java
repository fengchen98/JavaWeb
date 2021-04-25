package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */

/**
 * 方法2
 */
public class ThreadDemo5 {


    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
                System.out.println("当前线程的名称："+Thread.currentThread().getName());

            }
        };
        thread.start();
    }
}
