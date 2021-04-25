package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */


/**
 * 方法6:实现Callable+future
 * 创建线程并得到执行结果
 */
public class ThreadDemo11 {


    public static void main(String[] args) {
        String content="ABCD";
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (char item:content.toCharArray()) {
                    System.out.print(item);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (char item:content.toCharArray()) {
                    System.out.print(item);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }
}
