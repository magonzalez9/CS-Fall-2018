/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistmain;

/**
 *
 * @author Marco
 */
public class Test {
    int length; 
    int width; 
    int height; 
    static int area = 69;

    public static int getLength() {
        return 420;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int calculate(){
        area = width * height*length;
        return area;
    }

    
}
