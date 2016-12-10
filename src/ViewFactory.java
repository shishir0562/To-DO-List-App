/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coder
 */
public class ViewFactory {
    
    public View getView(String viewType){
        
        if(viewType==null) return null;
        if(viewType.equalsIgnoreCase("cli")) return new ToDoView();
        return null;
    }
}
