
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coder
 */
public class ToDo {
    public static void main(String ab[]) throws IOException{
        
        ViewFactory viewFactory = new ViewFactory();
        View cmdView = viewFactory.getView("cli");
        //ToDoView view = new ToDoView();
        ToDoModel model = new ToDoModel();
        String []input;
        String value;
        ArrayList<String> items;
        while(true){
            input = cmdView.getInput();
            if(input[0].equals(" ")||input[1].equals(" ")||input[2].equals(" ")){
                continue;
            }
            try{
                if(input[0].equals("add")){
                    value = input[2];
                    if(!(value.equals(" ")||value.equals("")))
                        model.addItem(value);
                    else 
                        cmdView.displayMessage("Invalid Command");
                }
                else
                if(input[0].equals("list")){
                    value = input[2];
                    if(value.equals(" ")) continue;
                    items = new ArrayList<>();
                    if(value.equals(""))
                     items = model.getAllItems();
                    else items = model.searchItem(value);
                    cmdView.displayItems(items);
                }
                else
                if(input[0].equals("done")){
                    int index = Integer.parseInt(input[2]);
                    model.markItem(index);
                }
            }
            catch(Exception e){
                System.out.println("Invalid Command");
            }
        } 
    }
}
