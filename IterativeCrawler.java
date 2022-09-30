/**
 * @author<Warisa_Khan>
 * @version<1.8>
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IterativeCrawler extends Crawler {

    /**
     * @param pendingPages is a list of pages that remains to be visited 
     */
    protected ArraySet<String> pendingPages;

    /**
     * constrcutor that creates the empty crawler 
     */

    public IterativeCrawler(){
        pendingPages = new ArraySet<String>();

    }

    /**
     * @param pageFileName 
     * @return void master crawl method which will start on a given page and visit all reachable pages 
     * adds page to the pendingPages and calls crawlRemianing 
     */

    public void crawl(String pageFileName){
        pendingPages.add(pageFileName);
        crawlRemaining();

 
    

    }

    /**
     * enters a loop that that crawls individual pages until there are no pending pages remaining 
     * when executing, the pendingPages set grows and shrinks but should evantually reduce to size 0 
     */

    public void crawlRemaining(){
        while(pendingPages.size() > 0) {
            crawlNextPage();
        }

    }

    /**
     * will add a page to be visited at a later time by the crawler 
     * iot can be used independently to add pages for later or during other methods in this class
     * @param pageFileName the page being added 
     */

    public void addPendingPage(String pageFileName){
        pendingPages.add(pageFileName);

    }

    /**
     * calls on the size function to be able to see the length of the pages 
     * @return int number of pages remaining to visit
     */

    public int pendingPagesSize(){
        return pendingPages.size();
        
    }

    /**
     * using a for each loop to add the elements to the string and return it 
     * @return String with each pendingpahe to visit on its own line 
     */

    public String pendingPagesString(){
        String find = "";
        List<String> count = pendingPages.asList();
        for (String element:count) {
            find = find + element + "\n";
        }

        return find;


    }

    /**
     * crawls a single page which is retrived and removed from the list are of pendingpages 
     * page added to the fpundPages for the crawler and any links are added either to 
     */

    public void crawlNextPage(){
        int find = pendingPages.size() - 1;
        String count = pendingPages.asList().remove(find);
        foundPages.add(count);

        // try block that adds the file to the document 
        try {

            //creates a JSOUP  dpcument from page 
            //exytratcs a list of LINKS from the document 
            File in = new File(count);
            Document doc = Jsoup.parse(in, "UTF-8");

            ArrayList<Element> links = doc.select("a[href");

            //for every item in links w a for each loop 

            for(Element item: links){
                String newPage = item.attr("href");

                // if LinkHREF is not a valid page, add it to skipped pages, and move on to the next item 

                if(! validPageLink(newPage)){
                    skippedPages.add(newPage);
                    continue;
                }

                //use the Util.relativeFileName(..) to get the LINKFILE 
            

                String nName = Util.relativeFileName(count, newPage);
                File in2 = new File(nName);

                //if LINKFILE is already in the found or skipped pages, move onto the next item 

                if(foundPages.contains(nName) == true || skippedPages.contains(nName) == true){
                    continue;
                }

                //iff linked file does not exsit, add it to the skipped pages and move on to the next item 

                if (in2.exists()== false){
                    skippedPages.add(nName);
                    continue;
                }

                //use the add pending pages with the linkname 

                addPendingPage(nName);
            }
                
                
            
        }

        // catches any exceptions 

        catch(Exception e){
            
        }

    }





    
}
