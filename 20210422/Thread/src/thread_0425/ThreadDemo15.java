package thread_0425;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 21:15
 */



public class ThreadDemo15 {


    public static void main(String[] args) {
      Thread t1=new Thread(()->{
          for (int i = 0; i < 10; i++) {
              System.out.println(i);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
      //设置为守护线程
        t1.setDaemon(true);
      t1.start();
        System.out.println("是否为守护线程"+t1.isDaemon());
    }
}
