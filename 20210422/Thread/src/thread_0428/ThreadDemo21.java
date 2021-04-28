package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:42
 */




public class ThreadDemo21 {
    public static void main(String[] args) throws InterruptedException {

        // 定义公共任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "上班");
                try {
                    // 表示工作时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        "下班");
            }
        };

        // 定义张三
        Thread t1 = new Thread(runnable, "张三");
        t1.start();

        // 等待张三执行完成
        t1.join(900);

        // 定义李四
        Thread t2 = new Thread(runnable, "李四");
        t2.start();

    }
}

