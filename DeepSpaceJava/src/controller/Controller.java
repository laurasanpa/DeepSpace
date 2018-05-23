/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.View;
import deepspace.GameUniverse;
//prueba
import deepspace.ShieldToUI;
import deepspace.WeaponToUI;
import deepspace.LootToUI;
import deepspace.NumericDamageToUI;
import deepspace.HangarToUI;
import deepspace.SpecificDamageToUI;
import deepspace.EnemyToUI;
import deepspace.SpaceStationToUI;

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
    
    //Pruebas
    
    public ShieldToUI dameUnEscudoPrueba(){
        return new ShieldToUI(model.dameUnEscudoPrueba());
    }
    
     public WeaponToUI dameUnArmaPrueba(){
        return new WeaponToUI(model.dameUnArmaPrueba());
    }
     
     public LootToUI dameUnBotinPrueba(){
        return new LootToUI(model.dameUnBotinPrueba());
    }
     
     public NumericDamageToUI dameUnNumericoPrueba(){
         return new NumericDamageToUI(model.dameUnNumericoPrueba());
     }
    
     public HangarToUI dameUnHangarPrueba(){
         return new HangarToUI(model.dameUnHangarPrueba());
     }
     
     public SpecificDamageToUI dameUnEspecificoPrueba(){
         return new SpecificDamageToUI(model.dameUnEspecificoPrueba());
     }
     
     public EnemyToUI dameUnEnemigoPrueba(){
         return new EnemyToUI(model.dameUnEnemigoPrueba());
     }
     
    public SpaceStationToUI dameUnaEstacionPrueba(){
         return new SpaceStationToUI(model.dameUnaEstacionPrueba());
     }
}
