# RSS-Feed-Reading-Writing-using-multi-threading-and-rome-library-in-Java
This project can read a rss feed on the url "http://rss.cnn.com/rss/edition.rss". 
Then it creates a rss file in the local drive and writes the xml output it read from the url.
Upto this operation all actions are performed using a single thread.
Another threads then reads the file resides in the local drive and prints all the JPG image references listed in the xml file in the console.
The 1st thread is repeated after every 15 seconds and the 2nd thread is repeated after every 20 seconds.
