package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 21:15
 */



public class ThreadDemo14 {


    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名："+Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t1=new Thread(runnable,"张三");
            Thread t2=new Thread(runnable,"李四");
            Thread t3=new Thread(runnable,"王五");
            t1.setPriority(1);
            t3.setPriority(10);
            t1.start();
            t2.start();
            t3.start();

        }


    }
}
