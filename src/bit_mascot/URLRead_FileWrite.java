package bit_mascot;

import java.io.FileWriter;
import java.io.*;
import java.net.URL;
import java.util.*;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.*;

public class URLRead_FileWrite implements Runnable {
    public void run() {
        TimerTask task = new TimerTask() {
          @Override
            public void run() {
        	    try {
        		    URL feedSource = new URL("http://rss.cnn.com/rss/edition.rss");
        		    SyndFeedInput input = new SyndFeedInput();
        		    SyndFeed feed = input.build(new XmlReader(feedSource));
        		    Writer writer = new FileWriter("D:\\a.rss");
        		    SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
        		    syndFeedOutput.output(feed, writer);
        		    System.out.println("File Created.");
        		    writer.close();
        	    } 
        	    catch (IllegalArgumentException | FeedException | IOException e) {
        		  e.printStackTrace();
        	    } 
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 15*1000);
    }
}