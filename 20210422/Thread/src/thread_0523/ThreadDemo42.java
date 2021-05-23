package thread_0523;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @program: Thread
 * @description:
 * @author: FENG CHEN
 * @create: 2021-05-23 10:58
 */
public class ThreadDemo42 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000));
        Future<Integer> future=executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int num=new Random().nextInt(10);
                System.out.println("线程池生成了随机数："+num);
                return num;
            }
        });
        System.out.println("Main得到返回值："+future.get());
    }
}
