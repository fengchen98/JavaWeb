package thread_0525;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:懒汉模式
 * @author: FENG CHEN
 * @create: 2021-05-25 20:29
 */
public class ThreadDemo53 {
    static class Singleton{
        //1.创建私有的构造函数
        private Singleton(){

        }
        //2.创建私有的类对象
       private static volatile Singleton singleton=null;
        //3.提供统一的访问方法
        public static synchronized Singleton getInstance() throws InterruptedException {
            if (singleton==null){
                synchronized (Singleton.class){
                    if (singleton==null){
                        singleton=new Singleton();
                    }
                }

            }
            return singleton;
        }

    }

    private static Singleton s1=null;
    private static Singleton s2=null;
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s1=Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
       t1.start();
       s2=Singleton.getInstance();
       t1.join();
        System.out.println(s1==s2);
    }
}
