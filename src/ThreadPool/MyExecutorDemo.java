package ThreadPool;


import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

public class MyExecutorDemo {
    //执行的任务数量
    private static int MAX = 50;

    public static void main(String args[]) {
        try {
            myThreadPool();
//            fixedThreadPool(4);
//            newCachedThreadPool();
//            newSingleThreadPool();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void myThreadPool()
            throws InterruptedException, ExecutionException {
        ThreadFactory springThreadFactory = new CustomizableThreadFactory("springThread-pool-");
        ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-").build();
        ThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
                .namingPattern("basicThreadFactory-").build();


        ExecutorService exec = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10), springThreadFactory);
        exec.submit(() -> {
            System.out.println("--记忆中的颜色是什么颜色---");
        });

    }

    private static void fixedThreadPool(int corePoolSize)
            throws InterruptedException, ExecutionException {
        //创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(corePoolSize);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            //1.保证了执行完毕
            //提交任务
            Future<Integer> task = exec.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("执行线程" + Thread.currentThread().getName());
                    return fibc(30);
                }
            });
            //获取执行结果
            System.out.println("第" + i + "次计算，结果为" + task.get());

            //2.只为执行
//            exec.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("执行线程为：" + Thread.currentThread().getName() +
//                            "，结果为：" + fibc(20));
//                }
//            });

            if (i == MAX - 1) {
                System.err.println("fix耗时：" + (System.currentTimeMillis() - startTime));
            }
        }
    }

    private static void newCachedThreadPool() throws ExecutionException,
            InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            //1.保证了执行完毕
            //提交任务
            Future<Integer> task = exec.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("执行线程" + Thread.currentThread().getName());
                    return fibc(30);
                }
            });
            //获取执行结果
            System.out.println("第" + i + "次计算，结果为" + task.get());

            //2.只为执行
//            exec.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("执行线程为：" + Thread.currentThread().getName() +
//                            "，结果为：" + fibc(20));
//                }
//            });
            if (i == MAX - 1) {
                System.err.println("cached耗时：" + (System.currentTimeMillis() - startTime));
            }
        }
    }

    private static void newSingleThreadPool() throws ExecutionException,
            InterruptedException {

        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("执行线程" + Thread.currentThread().getName() + "位置" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            singleThreadExecutor.execute(runnable);

        }
    }

    //模拟耗时操作，定义一个斐波那契数列
    private static int fibc(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibc(num - 1) + fibc(num - 2);
    }

}
