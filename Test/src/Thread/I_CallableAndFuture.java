package Thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Star Yang on 2016/11/24.
 */
public class I_CallableAndFuture {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello";
            }
        });

        System.out.println("等待结果中...");
        try {
            System.out.println("获取结果---" + future.get());
//            需要在规定时间内返回，否则会报异常
//            System.out.println("获取结果---"+future.get(1,TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();


        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
        for (int i = 0; i < 10; i++) {
            final int task = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return task;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("**********" + completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
