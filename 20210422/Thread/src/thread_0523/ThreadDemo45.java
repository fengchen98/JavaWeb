package thread_0523;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 14:58
 */
public class ThreadDemo45 {
    static ThreadLocal<String> threadLocal=new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            System.out.println("执行了初始化的方法");
            return "JAVA";
        }
    };

    public static void main(String[] args) {
        threadLocal.set("MYSQL");
        String result=threadLocal.get();
        System.out.println(result);
    }
}
