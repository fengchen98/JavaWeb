package thread_0428;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-28 11:42
 */




public class ThreadDemo22 {
    public static void main(String[] args) {

        // 打印所有线程
        for (Thread.State item : Thread.State.values()) {
            System.out.println(item);
        }


    }
}
