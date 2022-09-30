/**
 * @author<Warisa_Khan>
 * @version<1.8>
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RecursiveCrawler extends Crawler {

    /**
     * creates empty crawler 
     */
    public RecursiveCrawler(){
        super();

    }

    /**
     * implementation of crawling 
     * @param pageFileName being used to initiate craweler
     * @return void just creating the crawler
     */

    @Override
    public void crawl(String pageFileName){
        foundPages.add(pageFileName);
       

        try{

            // reading files and creating new variables 
            File input = new File(pageFileName);
            Document doc =Jsoup.parse(input, "UTF-8");
            ArrayList<Element> links = doc.select("a[href]");

            for (Element item : links){

                //extract LINKHREF from the item 
                String newPage = item.attr("href");

                //if the LINKEDHREF is not a valid page
                //adds it to the skipepdPahes and move on to the next item 

                if (! validPageLink(newPage)){
                    skippedPages.add(newPage);
                    continue; 
                }

                //uses the Util.relartiveFileName(..)to get to the Linkfile 

                String newName = Util.relativeFileName(pageFileName, newPage);
                File file = new File(newName);

                //if the LinkFIle does not exist, add it to the SKipped pages and mobe on to the next item 

                if (foundPages.contains(newName) == true || skippedPages.contains(newName) == true){
                    continue;
                }

                if (! file.exists()){
                    skippedPages.add(newName);
                    continue;
                }

                // use the recursion and recursibvley visit Linkfile as it is a valid page

                crawl(newName);

            }

          


        }

        // catch the exception here 
        catch(IOException e){
                
        }

    }
    
}
