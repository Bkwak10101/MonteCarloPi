package com.github.bkwak.calculatePI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        int threadsNum = 8, pointsNum = 1000000000;
        ExecutorService executor = Executors.newFixedThreadPool(threadsNum);
        Counter counter = new Counter();
        for (int i = 0; i < threadsNum; i++) {
            Runnable task = new MonteCarloPiTask(pointsNum / threadsNum, counter);
            executor.execute(task);
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        double pi = 4.0 * counter.getCount() / pointsNum;
        System.out.println("Pi: " + pi);
    }
}

