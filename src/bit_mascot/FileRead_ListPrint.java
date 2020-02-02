package bit_mascot;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

import com.rometools.modules.mediarss.MediaEntryModule;
import com.rometools.modules.mediarss.types.*;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.*;

public class FileRead_ListPrint implements Runnable {
	public void run() {
        TimerTask task = new TimerTask() {
          @Override
            public void run() {
        	  try {
      			System.out.println("Image file list printing started...");
      			SyndFeed readFeed = getSyndFeedFromLocalFile("D:\\a.rss");
      			for(SyndEntry entry : readFeed.getEntries()){
      				for(Module module : entry.getModules()) {
      					if (module instanceof MediaEntryModule) {
      						MediaEntryModule mediaEntryModule = (MediaEntryModule) module;
      						MediaGroup[] mediaGroups = mediaEntryModule.getMediaGroups();
      						for(MediaGroup mediaGroup : mediaGroups) {
      							MediaContent[] mediaContents = mediaGroup.getContents();
      							for(MediaContent mediaContent : mediaContents) {
      								System.out.println(mediaContent.getReference());
      							}
      						}
      					}
      				}
      			}
      		} 
      		catch (Exception e) {
      			e.printStackTrace();
      		}
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 20*1000, 20*1000);
    }
	public static SyndFeed getSyndFeedFromLocalFile(String filePath) throws MalformedURLException, IOException, IllegalArgumentException, FeedException {

		File source = new File(filePath);
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(source));
		return feed;
	}
}