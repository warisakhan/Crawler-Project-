import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author<Warisa_Khan>
 * @version<1.8>
 * concrete class that implements Iterable interface 
 */

public class ArraySet<T extends Comparable<T>>{
    private List<T> list;

    /**
     * creates an empty ArraySet 
     */

    public ArraySet(){
        list = new ArrayList<T>();

        

    }

    /**
     * 
     * @return int - the size of the set which is the number of unique items in it 
     */

    public int size(){
        return list.size();

    }

    /**
     * 
     * @return List contect of the set as a shallow copy of the list 
     */

    public List<T> asList(){
        return list;

    }

    /**
     * 
     * @param query item 
     * @return true if query item is p[resent in the set and false otherwise ]
     */

    public boolean contains(T query){
        boolean find = false;
        if(list.contains(query)){
            find = true;
            return find;
            
        }

        else {
            return find; 
        }

    }

    /**
     * ensures specific item is unique 
     * @param item
     * @return if given item added to the set returns true, if item is already present, returns false 
     * if item null returns runtime exception
     */

    public boolean add(T item){

        int count = Collections.binarySearch(list, item);
      
        boolean find = false;
        if (item == null){
            throw new RuntimeException("Arrayset does not support null items");

        }

        if(list.contains(item)){
            find = false;
            return false;
        }

        if(count < 0){
            count = (-count) - 1;
           
            
          

        }

        else{
            return find; 
            
        }

        list.add(count, item);
        find = true;
        return find;
 

    }

    /**
     * 
     * @param query item 
     * @return item that is set equal to the query item, if no item in the set is equal, returns null 
     */

    public T get(T query){
        if (! list.contains(query)){
            return null ; 

        }

      T find = null;
      for (int i = 0; i < list.size(); i ++){
          if (list.get(i).compareTo(query) == 0){
              find = list.get(i);
          }


      }

      return find; 

    }

    /**
     * @return String representation of the set and its contents 
     */

    public String toString(){
    String find = "";
    //     for (int i = 0; i < list.size() - 1; i ++){
    //         find += list.get(i) + ", ";

    //     }

    //     find += list[-1];
    //     return find; 
       if(list.size() == 0){
           find = "[]";
       
       }
       
       else {
           find = list.toString();

       }

       return find; 
           
       
        
    }

    /**
     * 
     * @return iterator of the set, uses a helper method 
     */

    public Iterator<T> iterator(){
        return new ArrayIterator();

    

    }

    /**
     * iterator that is a private inner class 
     */

    private class ArrayIterator implements Iterator<T>{
        private ArrayList<T> tempArrayList;
        private int index;
	  
		public boolean hasNext()
		{
			return index<list.size();
		}
		 public T next(){
			 T result =  this.tempArrayList.get(this.index);
			 this.index += this.index + 1;
			 return result;
		 }

    }



    

}