package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 09:49
 */
//使用全局自定义变量终止线程
public class ThreadDemo16 {
    private static boolean flag=false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("我正在转账呢");
                }
                System.out.println("终止转账");
            }
        });
        thread.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(310);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("停止交易");
                    flag=true;
                }
        });
        thread2.start();
        thread.join();
        thread2.join();
    }
}
