package com.github.bkwak.calculatePI;

class MonteCarloPiTask implements Runnable {
    private int pointsNum;
    private Counter counter;

    public MonteCarloPiTask(int pointsNum, Counter counter) {
        this.pointsNum = pointsNum;
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < pointsNum; i++) {
            double x = Math.random(), y = Math.random();
            if (x * x + y * y <= 1) {
                counter.increment();
            }
        }
    }
}
