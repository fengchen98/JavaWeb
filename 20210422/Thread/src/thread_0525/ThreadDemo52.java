package thread_0525;

/**
 * @program: Thread
 * @description:饿汉方式
 * @author: FENG CHEN
 * @create: 2021-05-25 18:52
 */
public class ThreadDemo52 {
    static  class Singleton{
        //1.先创建私有的构造函数(防止其他类直接创建)
        private Singleton(){

        }
        //2.定义私有变量
        private static Singleton singleton=new Singleton();
        //3.提供公共的获取实例的方法
        public static Singleton getInstance(){
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        System.out.println(singleton);
    }

}
