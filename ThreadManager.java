package codingmafia.project1;

import codingmafia.RunnableExample;
import codingmafia.TaskManager;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//steps
// read IndianNationalAnthem.txt
// Using data structures
//Find top 9 keywords and print then in order of decreasing frequency
// each line will have FREQUENCY and WORD
//Need to use thread to read the file
// HINTS:
// Use TaskManager
// Create one Runnable based class named FileReaderRunnable that has constructor to take a file path
// Submit one FileReaderRunnable object to read file and print result
//NOTE : make sure each word is converted to lowercase first for processing


public class ThreadManager {
    private ExecutorService executorService;
    private int poolSize;

    public ThreadManager(int poolSize) {
        this.poolSize = poolSize;
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void sumbit_thread(Runnable runnable) {
        executorService.submit(runnable);

    }

    private int getQueuesize() {
        ThreadPoolExecutor ex = (ThreadPoolExecutor) executorService;
        return ex.getQueue().size();

    }

    public void waitTillQueueIsFreeThenAddTask(Runnable runnable) {
        while (getQueuesize() >= poolSize) {
            try {
                Thread.currentThread().sleep(100);
                System.out.println("Sleeping phase!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sumbit_thread(runnable);
        System.out.println("new thread added to queue!");
    }

    public static void main(String[] args) {
        TaskManager t = new TaskManager(100);
        FileReaderRunnable r = new FileReaderRunnable("C:\\Users\\chhavi munjal\\Desktop\\tech\\src\\main\\java\\codingmafia\\project1\\NationalAnthem");
        t.waitTillQueueIsFreeThenAddTask(r);


    }

}






