/**
 * @author<Warisa_Khan>
 * @version<1.8>
 */
import java.util.List;

public abstract class Crawler {

    /**
     * @param foundPages is a set of pages that has been found 
     * @param skippedPages gives the set of pages that have been skipped due to being invalid or nonexistant
     */

    protected ArraySet<String> foundPages;

    protected ArraySet<String> skippedPages;

    /**
     * constructor that creates empty crawler 
     */

    public Crawler(){
        this.foundPages = new ArraySet<String>();
        this.skippedPages = new ArraySet<String>();


    }

    /**
     * interface that initiates crawl on a given page, child class overrides 
     * @param pageFileName
     */

    public abstract void crawl(String pageFileName);

    /**
     * 
     * @return unique pages that have been skipped so far 
     */
    
    public List<String> foundPagesList(){
        return foundPages.asList();
  

    }

    /**
     * 
     * @return the unique pages that have been skipped so far, may be invalid or links off of the local file system 
     */
    public List<String> skippedPagesList(){
        return skippedPages.asList();

    }

    /**
     * 
     * @return string of pages thjat have been found so far 
     */

    public String foundPagesString(){
        String find = "";
        for (int i = 0; i < foundPagesList().size(); i ++){
            find += foundPagesList().get(i) + "\n";
        }
        return find; 
    }

    /**
     * 
     * @return string of pages that have been skipped so far 
     */

    public String skippedPagesString(){
        String count = "";
        for (int i = 0; i < skippedPagesList().size(); i ++){
            count += skippedPagesList().get(i) + "\n";
        }
        return count; 

    }
    
    /**
     * 
     * @param pageFileName is being used to check boolean states 
     * @return true if given pageFileName is valid, else false 
     */

    public static boolean validPageLink(String pageFileName){
        boolean find = false; 
        if (pageFileName.startsWith("http://")){
            return find; 
        }

        else if (pageFileName.startsWith("https://")){
            return find; 
        }

        else if(pageFileName.startsWith("file://")){
            return find; 
        }

        else if(pageFileName.startsWith("javascript:")){
            return find; 
        }

        if(pageFileName.endsWith(".jpg")){
            return find; 
        }

        else if(pageFileName.endsWith(".png")){
            return find; 
        }

        else if (pageFileName.endsWith(".jpeg")){
            return find; 
        }

        else if(pageFileName.endsWith(".html")){
            find = true;
            return find;
        }

        else if (pageFileName.endsWith(".HTML")){
            find = true;
            return find; 
        }

        return find; 



        


    }
    
}
