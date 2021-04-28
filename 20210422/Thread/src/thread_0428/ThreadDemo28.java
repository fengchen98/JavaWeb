package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:42
 */



public class ThreadDemo28 {

    static class Counter {

        // 任务执行次数
        private final int maxSize = 100000;

        // num++
        public int incrment() {
            int num1 = 0;
            for (int i = 0; i < maxSize; i++) {
                num1++;
            }
            return num1;
        }

        // num--
        public int decrment() {
            int num2 = 0;
            for (int i = 0; i < maxSize; i++) {
                num2--;
            }
            return num2;
        }
    }

    private static int num1 = 0;
    private static int num2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            num1 = counter.incrment();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            num2 = counter.decrment();
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终的执行结果：" + (num1 + num2));

    }

}
