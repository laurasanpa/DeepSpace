/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import controller.Controller;
import java.util.ArrayList;
/**
 *
 * @author samuel
 */
public interface View {
    
    public void setController(Controller c);
    public void updateView();
    public void showView();
    public void acceptLost();
    public void acceptWin();
    public void acceptEscape();
    public void acceptConvert();
    public void acceptFinalWin();
    
    public ArrayList<String> getNames();
}
