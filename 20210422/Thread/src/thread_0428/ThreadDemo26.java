package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:42
 */




public class ThreadDemo26 {

    static class Counter {
        // 定义的私有变量
        private int num = 0;
        // 任务执行次数
        private final int maxSize = 100000;

        // num++
        public void incrment() {
            for (int i = 0; i < maxSize; i++) {
                num++;
            }
        }

        // num--
        public void decrment() {
            for (int i = 0; i < maxSize; i++) {
                num--;
            }
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.incrment();
        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            counter.decrment();
        });
        t2.start();
        t2.join();

        System.out.println("最终的执行结果：" + counter.getNum());

    }

}
