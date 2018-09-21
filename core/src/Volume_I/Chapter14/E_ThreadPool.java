package Volume_I.Chapter14;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Created by Star Yang on 2017/3/20.
 */
public class E_ThreadPool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory: (e.g. /usr/local/jdk5.0/src): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword: (e.g. volatile): ");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();
        Counter counter = new Counter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + " matching files.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
        int largePoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("Largest Pool Size = " + largePoolSize);
    }
}

class Counter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public Counter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();

        for (File file : files) {
            if (file.isDirectory()) {
                Counter counter = new Counter(file, keyword, pool);
                Future<Integer> result = pool.submit(counter);
                results.add(result);
            } else {
                if (search(file)) count++;
            }

            for (Future<Integer> result : results) {
                count += result.get();
            }
        }
        return count;
    }

    public boolean search(File file) {
        try {
            Scanner in = new Scanner(file);
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) found = true;
            }
            return found;
        } catch (IOException e) {
            return false;
        }
    }
}
