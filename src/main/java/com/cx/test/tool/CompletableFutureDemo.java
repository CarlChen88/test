package com.cx.test.tool;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 1.runAsync和supplyAsync
 * 2.结算结果完成的回调方法whenComplete/whenCompleteAsync/exceptionally
 * 3.thenApply当一个线程依赖另一个线程时，串行化执行
 * 4.handle是任务执行完成后对结果的处理
 * 5.thenAccept消费处理结果
 * 6.thenRun不关心任务处理的结果只要前一个任务执行完成就执行thenRun
 * 7.thenCombine合并任务
 * 8.thenAcceptBoth 消费两个任务的结果
 * 9.applyToEither谁执行返回的结果快，我们就用哪个CompletionStage的结果执行下一步的转化操作
 * 10.acceptEither两个CompletionStage,谁执行返回的结果快,就用哪个CompletionStage执行下一步的消费操作
 * 11.runAfterEither
 * 12.runAfterBoth
 * 13.thenCompose
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test6();
    }

    /**
     * thenApply
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            long result1 = new Random().nextInt(100);
            System.out.println("result1:" + result1);
            return result1;
        }).thenApply((result) -> {
            long result2 = result * 5;
            System.out.println("result2:"+result2);
            return result2;
        });
        System.out.println(future.get());
    }

    /**
     * handle
     */
    public static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> handle = CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return new Random().nextInt(100);
        }).handle((params, exception) -> {
            int result = 9;
            if (exception == null) {
                result = params * 2;
            } else {
                System.out.println("exception message:" + exception.getMessage());
            }
            return params * 2;
        });
        System.out.println(handle.get());
    }

    /**
     * thenAccept消费处理结果
     */
    public static void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() ->
                new Random().nextInt(100)
        ).thenAccept((params) -> {
            System.out.println("params:" + params * 23);
        });
        future.get();
    }

    public static void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world!";
        });
        CompletableFuture<String> combine = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + result2;
        });
        System.out.println(combine.get());
    }

    public static void test5() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return " world!";
        });
        future1.thenAcceptBoth(future2, (result1, result2) -> {
            System.out.println(result1+result2);
        });
    }
    public static void test6() throws ExecutionException, InterruptedException {
            CompletableFuture<Integer> f = CompletableFuture.supplyAsync(()-> {
                    int t = new Random().nextInt(3);
                    System.out.println("t1="+t);
                    return t;
            }).thenCompose((t)->{
                System.out.println("t1:"+t);
                return CompletableFuture.supplyAsync(()-> t*2);
            });
            System.out.println("thenCompose result : "+f.get());
        }

}
