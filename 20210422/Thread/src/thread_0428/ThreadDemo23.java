package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:42
 */




public class ThreadDemo23 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        // 休眠线程
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        System.out.println("start之前的状态：" + t1.getState());
        t1.start();
        System.out.println("start之后的状态：" + t1.getState());
        Thread.sleep(100);
        System.out.println("t1的状态：" + t1.getState());

        // 等待线程程序完成
        t1.join();
//        while (!t1.isAlive()) {
//        }

        System.out.println("线程执行完成之后的状态：" + t1.getState());

    }
}

