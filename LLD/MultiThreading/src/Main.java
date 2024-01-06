import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(25, 50, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10), new CustomThreadFactory(), new CustomRejectHandler());
//        for (int i = 0; i < 40; i++) {
//            threadPoolExecutor.submit(() -> {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("Thread Name : " + Thread.currentThread().getName());
//                } catch (Exception e) {
//
//                }
//
//
//            });
//        }
//        threadPoolExecutor.shutdown();
//    }

        //TODO: Example for Future and it's methods.
//        Future<?> futureObj = threadPoolExecutor.submit(() -> {
//            try {
//                Thread.sleep(7000);
//                System.out.println("This is the task thread is executing");
//            } catch (Exception e) {
//
//            }
//        });
//
//        System.out.println("is done : " + futureObj.isDone());
//        try {
//            futureObj.get(2, TimeUnit.SECONDS);
//
//        } catch (TimeoutException | InterruptedException | ExecutionException e) {
//            System.out.println("TimeOut Exception occured");
//        }
//
//        try{
//            futureObj.get();
//
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("is done : " + futureObj.isDone());
//        System.out.println("is cancelled : " + futureObj.isCancelled());


        //TODO: Example of callable and it's methods
//        Future<?> futureObj1 = threadPoolExecutor.submit(() ->
//        {
//           System.out.println("Do something");
//        });
//
//        //In the above call we are not returing anything so it will call the runnable method.
//
//        Future<Integer> integerFuture = threadPoolExecutor.submit(() ->
//        {
//           return 45;
//        });
//
//        //In this above method we are returning integer type so it is calling callable method.
//    }
//}

        //TODO: Example of CompletableFuture and it's methods implementation

//        CompletableFuture<String> completableFutureObj = CompletableFuture.supplyAsync(() ->
//        {
//            try {
//                System.out.println("Thread name of supplyAsync : " + Thread.currentThread().getName());
//
//                Thread.sleep(5000);
//            } catch (Exception e) {
//
//            }
//            return "CONCEPT";
//
//        }, threadPoolExecutor).thenApply((String val) ->
//        {
//            System.out.println("Thread name of then Apply : " + Thread.currentThread().getName());
//            return "AND";
//
//        }).thenApplyAsync((String value) ->
//        {
//            System.out.println("Thread name of thenApplyAsync : " + Thread.currentThread().getName());
//            return "CODING";
//        })
//                .thenCompose((String vall) ->
//                {
//                    return CompletableFuture.supplyAsync(() -> vall + "world1");
//
//                })
//                .thenCompose((String vall) ->
//                {
//                    return CompletableFuture.supplyAsync(() -> vall + "world2");
//
//                }).
//                thenCompose((String vall) ->
//                {
//                    return CompletableFuture.supplyAsync(() -> vall + "world3");
//
//                });
//
//        completableFutureObj.thenAccept((String valll) ->
//        {
//            System.out.println("Printing value = " + valll);
//        });
//    }

        //TODO: shutdown, awaittermination and shutdownNow method example

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() ->
        {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            System.out.println("Shutdown Thread");
        });
        executorService.shutdown();
        try {
            boolean isTerminated = executorService.awaitTermination(6, TimeUnit.SECONDS);
            System.out.println("ISTERMINATED = " + isTerminated);
        }catch (Exception e){

        }
        executorService.shutdownNow();

        System.out.println("Main Thread");


        //TODO: Scheduled Threadpool Executor example

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        Future<String> future = service.schedule(() ->
        {
            System.out.println("hello");
            return "hello";
        }, 5, TimeUnit.SECONDS);


        try{
            System.out.println("Future object = " + future.get());
        }catch (Exception e){

        }

        //TODO: ThreadLocal and virtual vs platform thread

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set(Thread.currentThread().getName());



        System.out.println("Thread Name 1 = " + threadLocal.get());

        Thread thread = new Thread(() ->
        {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Thread name 2 = " + threadLocal.get());
        });




    }
}

    class CustomThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(r);
            th.setPriority(Thread.NORM_PRIORITY);
            th.setDaemon(false);
            return th;
        }
    }

    class CustomRejectHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task Rejected: " + r.toString());
        }


    }


