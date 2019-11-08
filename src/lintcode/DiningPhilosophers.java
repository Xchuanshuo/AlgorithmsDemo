package lintcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private final int peopleNum = 5;
    private Semaphore eatLimit;
    private Lock[] forkLocks = new Lock[peopleNum];

    public DiningPhilosophers() {
        for (int i = 0;i < peopleNum;i++) {
            this.forkLocks[i] = new ReentrantLock();
        }
        this.eatLimit = new Semaphore(peopleNum - 1);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % peopleNum;
        try {
            eatLimit.acquire();
            forkLocks[leftFork].lock();
            pickLeftFork.run();
            forkLocks[rightFork].lock();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forkLocks[leftFork].unlock();
            forkLocks[rightFork].unlock();
            eatLimit.release();
        }
    }
}