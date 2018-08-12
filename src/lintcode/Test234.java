package lintcode;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Legend
 * @data by on 18-8-3.
 * @descripton webpage-crawler
 */
class CrawlerThread extends Thread{

    private static BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
    private static List<String> results = new ArrayList<>();
    private static Map<String, Boolean> map = new HashMap<>();

    public static void setFirstUrl(String url) {
        blockingQueue.offer(url);
    }

    public static List<String> getResults() {
        return results;
    }

    @Override
    public void run() {
        while (true) {
            String url = "";
            try {
                url = blockingQueue.take();
            } catch (InterruptedException e) {
                break;
            }
            String domain = "";
            try {
                URL netUrl = new URL(url);
                domain = netUrl.getHost();
            } catch (MalformedURLException e) {
                // e.printStackTrace();
            }
            if (!map.containsKey(url) && domain.endsWith("wikipedia.org")) {
                map.put(url, true);
                results.add(url);
//                List<String> urls = HtmlHelper.parseUrls(url);
                List<String> urls = new ArrayList<>();
                for (String cur: urls) {
                    try {
                        blockingQueue.put(cur);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Test234 {

    public List<String> crawler(String url) {
        // write your code here
        CrawlerThread.setFirstUrl(url);
        CrawlerThread[] crawlerThreads = new CrawlerThread[7];
        for (int i=0;i<7;i++) {
            crawlerThreads[i] = new CrawlerThread();
            crawlerThreads[i].start();
        }

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0;i<7;i++) {
            crawlerThreads[i].stop();
        }

        return CrawlerThread.getResults();
    }
}
