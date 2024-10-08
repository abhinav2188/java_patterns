package com.company.Concurrency.Futrue;

import java.util.concurrent.*;

public class Main {

        public static void main(String[] args) {

            BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(2);

            ThreadFactory threadFactory = new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread myThread = new Thread(r);
                    myThread.setPriority(Thread.NORM_PRIORITY);
                    myThread.setDaemon(false);
                    return myThread;
                }
            };

            RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    // reject
                    System.out.println("task rejected : "+r.toString());
                }
            };


            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 1000, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, rejectedExecutionHandler);

//        poolExecutor.allowCoreThreadTimeOut(true); // to allow core thread to suspend/end when idle for timeAlive time

            for(int i=0; i<7; i++){
                int finalI = i;
                poolExecutor.submit(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(3000);
                        }catch (Exception e){
                            // handle exception
                        }
                        System.out.println("task running : "+ finalI + " by : "+Thread.currentThread().getName());
                    }
                });
            }

            poolExecutor.shutdown();

        }



}
