package thread_0425;

import java.util.Random;

/**
 * @program: Thread
 * @description:演示线程分组
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */



public class ThreadDemo12 {


    public static void main(String[] args) {
       Runnable runnable=new Runnable() {
           @Override
           public void run() {
               System.out.println("开始起跑:"+Thread.currentThread().getName());
               int num=1+new Random().nextInt(5);
               try {
                   Thread.sleep(num*1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("我到终点了:"+Thread.currentThread().getName());
           }
       };
       ThreadGroup group=new ThreadGroup("赛跑一组");
       Thread t1=new Thread(group,runnable,"张三");
       Thread t2=new Thread(group,runnable,"李四");
       t1.start();
       t2.start();

       while (group.activeCount()!=0){

       }
        System.out.println("宣布成绩");
    }
}
