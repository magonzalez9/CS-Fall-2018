/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancemain;
import java.util.*; 
/**
 *
 * @author Marco Gonzalez
 */
public class EmployeeBase {
    private int id; 
    
    // Database columns
    public static final int ID = 0;
    public static final int FIRST = 1; 
    public static final int LAST = 2; 
    public static final int GENDER = 3;
    
    protected List data_array;
     
    public EmployeeBase (int id, String first, String last, String gender){
        data_array = new MyList().getList(); 
 
        data_array.add(ID, this.id);
        data_array.add(FIRST, first);
        data_array.add(LAST, last); 
        data_array.add(GENDER, gender); 
    }
   
    public final String getBaseInfo (){
        if (data_array.isEmpty()) {
            return data_array.toString(); 
        } else {
            return "No Data Found!"; 
        }
    }
    
    public String getClassInfo(){
        return "This is the BASE class text"; 
    }
    
    public void updateData(int key, Object value){
       data_array.set(key, value);
    }
    
    public List getList(){
        return data_array; 
    }
}
