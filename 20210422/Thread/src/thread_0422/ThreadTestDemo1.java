package thread_0422;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-22 21:22
 */
public class ThreadTestDemo1 {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //让程序等待一定的时间
                try {
                    Thread.sleep(60*60*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        thread.start();
    }
}
