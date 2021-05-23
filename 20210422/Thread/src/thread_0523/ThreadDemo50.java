package thread_0523;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 16:48
 */
public class ThreadDemo50 {
    static ThreadLocal<String> threadLocal =
            new ThreadLocal<>();

    //脏数据的解决方案：
    //1、避免使用静态属性，因为会复用
    //2、万物皆可remove 用完之后进行remove


//    //脏数据
//    public static void main(String[] args) {
//        ThreadPoolExecutor executor =
//                new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
//                        new LinkedBlockingQueue<>(1000));
//        for (int i = 0; i <2 ; i++) {
//            MyTask t1 = new MyTask();
//            executor.execute(t1);
//        }
//    }
//    结果：
//    Thread-0:session infoThread-0
//    Thread-1:session infoThread-0


//    正常情况
    public static void main(String[] args) {
        MyTask t1 = new MyTask();
        t1.start();

        MyTask t2 = new MyTask();
        t2.start();
    }

    static class MyTask extends Thread{
        //用户的标识，每个线程有自己的用户信息
        //标识是否第一次访问
        static boolean firstFlag=true;

        @Override
        public void run() {
            if(firstFlag==true){
                //第一次访问 存储用户信息
                threadLocal.set("session info "+this.getName());
                firstFlag=false;
            }
            //得到用户信息
            String result = threadLocal.get();
            System.out.println(this.getName()+":"+result);

        }
    }
}
