/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompractice;

/**
 *
 * @author Marco Gonzalez
 */
public class Person {
    String name; 
    int age; 
    
    public Person(String name, int age){
        this.name = name; 
        this.age = age; 
    }
    
    public Person(Person obj){
        this.name = obj.name;
        this.age = obj.age; 
    }
    

    
    public String toString(){
        return "name: " + name + " | " + "age: " + age; 
    }
}
