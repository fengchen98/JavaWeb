package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:40
 */
/**
 * 使用 interrupt 来终止线程
 */
public class ThreadDemo19 {
    public static void main(String[] args) throws InterruptedException {

        // 转账线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (!Thread.interrupted()) {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("终止状态" +
                                Thread.currentThread().isInterrupted());
                        break;
                    }
                    System.out.println("别烦我，我正在转账呢");
                }
                System.out.println("终止线程");
            }
        });
        t1.start();

        Thread.sleep(310);
        // 终止线程
        System.out.println("有内鬼，停止交易");
        t1.interrupt();

    }
}
