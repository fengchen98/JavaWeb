package thread_0523;

import java.util.function.Supplier;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 15:16
 */
public class ThreadDemo46 {
    static ThreadLocal<String> threadLocal=ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了初始化方法");
            return "java";
        }
    });

    public static void main(String[] args) {
        String result=threadLocal.get();
        System.out.println(result);
    }
}
