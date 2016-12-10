
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
public interface View {
    public void draw();
    public void displayMessage(String message);
    public void displayItems(ArrayList<String> items);
    public String[] getInput();
}
