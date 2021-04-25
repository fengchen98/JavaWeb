package thread_0425;

import java.util.Random;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-25 19:34
 */



public class ThreadDemo13 {


    public static void main(String[] args) {
      Thread t1=new Thread(()->{
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      },"张三");
        t1.start();
        System.out.println("状态："+t1.getState());
        System.out.println("ID："+t1.getId());
        System.out.println("名称："+t1.getName());
        //优先级最小为1，最大为10，默认为5
        System.out.println("优先级："+t1.getPriority());
        System.out.println("是否为后台线程："+t1.isDaemon());
        System.out.println("是否存货："+t1.isAlive());
        System.out.println("是否被中断："+t1.isInterrupted());


    }
}
