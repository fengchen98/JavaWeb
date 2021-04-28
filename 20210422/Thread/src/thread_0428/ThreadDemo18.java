package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 09:49
 */
//使用全局自定义变量终止线程
public class ThreadDemo18 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
//                while (!Thread.interrupted()){
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("我正在转账呢");
                }
                System.out.println("终止转账");
            }
        });
        thread.start();
        Thread.sleep(10);
        System.out.println("停止交易");
        thread.interrupt();

    }
}
