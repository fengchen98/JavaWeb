package thread_0523;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 15:48
 */
public class ThreadDemo49 {
    public static void main(String[] args) {
        User user=new User();
        user.setUsername("Java");
        ThreadLocalUtil.threadLocal.set(user);

        Order order=new Order();
        order.getOrder();

        Logger logger=new Logger();
        logger.addLog();
    }


    static class ThreadLocalUtil{
        static ThreadLocal<User> threadLocal=new ThreadLocal<>();
    }
    static class User{
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    static class Logger{
        public void addLog(){
            User user=ThreadLocalUtil.threadLocal.get();
            System.out.println("添加了日志"+user.getUsername());
        }
    }

    static class Order{
        public void getOrder(){
            User user=ThreadLocalUtil.threadLocal.get();
            System.out.println("订单列表"+user.getUsername());
        }
    }
}
