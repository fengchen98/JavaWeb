package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:06
 */
public class ThreadDemo3 {
    private  static final long count=10_0000l;
    public static void main(String[] args) {
        concorrency();
        serial();
    }

    private static void serial() {
        Long stime=System.currentTimeMillis();
        for (int i = 0; i < 3*count; i++) {
            int a=0;
            a++;
        }
        Long etime=System.currentTimeMillis();
        System.out.println("单线程执行了："+(etime-stime));
    }

    private static void concorrency() {
        Long stime=System.currentTimeMillis();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        t1.start();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                int b=0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        });
        t2.start();

        int c=0;
        for (int i = 0; i <count ; i++) {
            c++;
        }
        Long etime=System.currentTimeMillis();
        System.out.println("多线程执行了："+(etime-stime));

    }
}
