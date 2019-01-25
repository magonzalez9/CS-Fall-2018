/*
* Programming to an interface
 */
package inheritancemain;
import java.util.*;
/**
 *
 * @author Marco Gonzalez
 */
public class MyList {
    private List list; 
    public static int LIST_COUNT;
    
    public MyList(){
        list = new ArrayList();
        LIST_COUNT++; 
    }
    
    public List getList() {
        return list;
    }
}
