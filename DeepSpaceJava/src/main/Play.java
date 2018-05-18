/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import deepspace.GameUniverse;
import View.View;
import View.GUI.MainView;
import controller.Controller;
/**
 *
 * @author samuel
 */
public class Play {

    /**
     * @param args the command line arguments
     */
    public static void main() {
        GameUniverse model= new GameUniverse();
        View view = new MainView();
        Controller controller = new Controller(model, view);
        controller.start();
    }
    
}
