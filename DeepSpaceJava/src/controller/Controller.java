/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.View;
import deepspace.GameUniverse;

/**
 *
 * @author samuel Y Laura
 */



public class Controller {
    
private GameUniverse model;
private View view;

    public Controller (GameUniverse aModel, View aView) {
        model = aModel;
        view = aView;
        view.setController(this);
    }
    
    public void start (){
        model.init(view.getNames());
        view.updateView();
        view.showView();
    }
    
    public void finish(int i){
        System.exit(i);
    }
}
