package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:06
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        String content="这，已不是第一次相约";
        for (char item:content.toCharArray()) {
            System.out.print(item);
            Thread.sleep(300);
        }
    }
}
