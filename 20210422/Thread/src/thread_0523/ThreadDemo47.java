package thread_0523;

import java.util.function.Supplier;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 15:16
 */
public class ThreadDemo47 {
    static ThreadLocal<String> threadLocal=ThreadLocal.withInitial(()->"java");

    public static void main(String[] args) {
        try {
            String result=threadLocal.get();
            System.out.println(result);
        }finally {
            threadLocal.remove();
        }

    }
}
