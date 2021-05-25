package thread_0525;

import java.util.Random;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-25 21:17
 */
public class ThreadDemo54 {
    static class MyBlockingQueue{
        private int[] values;  //实际存储数据的数组
        private int first;   //队首
        private int last;   //队尾
        private int size;   //实际的数量
        public MyBlockingQueue(int initial){
            values=new int[initial];
            first=0;
            last=0;
            size=0;
        }

        //添加元素
        public void offer(int val) throws InterruptedException {
            synchronized (this){
                //判断边界值
                if (size==values.length){
                    //队列满
                    this.wait();

                }
                values[last]=val;
                last++;
                size++;
                //判断是否为最后一个元素
                if (last==values.length){
                    last=0;
                }
                this.notify();
            }

        }

        //查询方法
        public int poll(){
            int result=-1;
            //判断边界值
            synchronized (this){
                if (size==0){
                    //队列为空  阻塞等待
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                result=values[first++];
                size--;
                if (first==values.length){
                    first=0;
                }
                this.notify();
            }

            return result;
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue=new MyBlockingQueue(100);
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                //每隔500毫秒生产一条数据
                while (true){
                    int num=new Random().nextInt(10);
                    System.out.println("生产了随机数:"+num);
                    try {
                        myBlockingQueue.offer(num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        //消费者
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int result=myBlockingQueue.poll();
                    System.out.println("消费了数据："+result);
                }
            }
        });
        t2.start();

    }
}
