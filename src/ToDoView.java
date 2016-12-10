/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coder
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ToDoView  implements View{
    
    private BufferedReader br = null;
    private String action, temp, comm, value;
    private String []inputArray;
    public void draw(){
        // drawing.....
    }
    public void displayMessage(String message){
        System.out.println(message);
    }
    public void displayItems(ArrayList<String> items){
       for(int i=0;i<items.size();++i){
           System.out.println(items.get(i));
       }
    }
    public String[] getInput(){
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            int index = input.indexOf(" ");
            if(index==-1){
                inputArray = new String[]{" ", " ", " "};
                System.out.println("Invalid Command");
                return inputArray;
            }
            comm = input.substring(0, index);
            temp = input.substring(index+1); 
            index = temp.indexOf(" ");
            if(index!=-1){
                action =temp.substring(0, index);
                value = temp.substring(index+1);
            }
            else{
                action = temp;
                value = "";
            }
            if((action.equals("add")||action.equals("list")||action.equals("done"))&&(comm.equals("todo"))){
                inputArray = new String[]{action, comm, value};
                return inputArray;
            }
            else{
                System.out.println("Invalid Command");
                inputArray = new String[]{" ", " ", " "};
            }
        }
        catch(Exception e){
            System.out.println("Invalid Command");
            inputArray = new String[]{" ", " ", " "};
        }
        return inputArray;
    }
}
