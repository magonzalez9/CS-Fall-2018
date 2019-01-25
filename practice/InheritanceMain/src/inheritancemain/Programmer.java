
package inheritancemain;

/**
 *
 * @author Marco Gonzalez
 */
public class Programmer extends EmployeeBase{
    public static final int LEVEL = 4; 
    public static final int LANGUAGE = 5; 
    public static final int IS_FLUENT = 6; 
    
    public Programmer(int id, String first, String last, String gender, int level, String language, boolean is_fluent){
        super(id, first, last, gender); 
        this.data_array.add(LEVEL, level);
        this.data_array.add(LANGUAGE, language);
        this.data_array.add(IS_FLUENT, is_fluent); 
    }
    
    
}
