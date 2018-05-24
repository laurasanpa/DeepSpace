/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.View;
import deepspace.GameUniverse;
import deepspace.GameState;
import deepspace.GameUniverseToUI;
import deepspace.CombatResult;
import java.util.ArrayList;
//prueba
import deepspace.ShieldToUI;
import deepspace.WeaponToUI;
import deepspace.LootToUI;
import deepspace.NumericDamageToUI;
import deepspace.HangarToUI;
import deepspace.SpecificDamageToUI;
import deepspace.EnemyToUI;
import deepspace.SpaceStationToUI;
import javax.swing.JOptionPane;


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
    
    public GameState getState (){
        return model.getState();
    }
    
    
    
    public GameUniverseToUI getUIversion(){
        return model.getUIversion();
    }
    
    public void discardMountedShieldBooster(int option){
        model.discardShieldBooster(option);
        view.updateView();
    }
    
    public void discardShieldBoosterInHangar(int option){
        model.discardShieldBoosterInHangar(option);
        view.updateView();
    }
    
    public void discardMountedWeapon(int option){
        model.discardWeapon(option);
        view.updateView();
    }
    public void discardWeaponInHangar(int option){
        model.discardWeaponInHangar(option);
        view.updateView();
    }
    
    public void discardHangar(){
        model.discardHangar();
        view.updateView();
    }
    
    public HangarToUI getHangar(){
        GameUniverseToUI a = model.getUIversion();
        SpaceStationToUI s = a.getCurrentStation();
        HangarToUI h = s.getHangar();
        return h;
    }
    
    public void discardMountedElements(ArrayList<Integer> selectedWeapons, ArrayList<Integer>  selectedShields,
            ArrayList<Integer> selectedWeaponsInHangar, ArrayList<Integer>  selectedShieldsInHangar ){
        for(int i=selectedWeapons.size()-1; i>=0;i--){
            discardMountedWeapon(selectedWeapons.get(i));
        }
        
        for(int i=selectedShields.size()-1; i>=0;i--){
            discardMountedShieldBooster(selectedShields.get(i));
        }
        
        for(int i=selectedWeaponsInHangar.size()-1; i>=0;i--){
            discardWeaponInHangar(selectedWeaponsInHangar.get(i));
        }
        
        for(int i=selectedShieldsInHangar.size()-1; i>=0;i--){
            discardShieldBoosterInHangar(selectedShieldsInHangar.get(i));
        }
        

        
        view.updateView();
        
        
    }
    
    public boolean haveAWinner(){
        return model.haveAWinner();
    }
    
    public CombatResult combat(){
        
        CombatResult result = model.combat();
        if(result==CombatResult.ENEMYWINS)
            view.acceptLost();
        if(result==CombatResult.STATIONWINS)
            view.acceptWin();
        if(result==CombatResult.STATIONESCAPES)
            view.acceptEscape();
        if(result==CombatResult.STATIONWINSANDCONVERTS)
            view.acceptConvert();
        if (haveAWinner()){
            view.acceptFinalWin();
            finish(0);
        }
        view.updateView();
        return result;
    }
    
    public void mountElements(ArrayList<Integer> selectedWeapons, ArrayList<Integer>  selectedShields){
        for(int i=selectedWeapons.size()-1; i>=0;i--){
            mountWeapon(selectedWeapons.get(i));
        }
        for(int i=selectedShields.size()-1; i>=0;i--){
            mountShieldBooster(selectedShields.get(i));
        }
        view.updateView();
    }
    
    public void mountShieldBooster(int option){
        model.mountShieldBooster(option);
//        view.updateView();
    }
    
    public void mountWeapon(int option){
        model.mountWeapon(option);
//        view.updateView();
    }
    
    public boolean nextTurn(){
       boolean result = model.nextTurn();
       view.updateView(); 
       return result;
    }
    
    public boolean canIGoOn(){
        return model.canIGoOn();
    }
    
    
  //  public void mountElements(ArrayList<Integer>)
    //Pruebas
    
//    public ShieldToUI dameUnEscudoPrueba(){
//        return new ShieldToUI(model.dameUnEscudoPrueba());
//    }
//    
//     public WeaponToUI dameUnArmaPrueba(){
//        return new WeaponToUI(model.dameUnArmaPrueba());
//    }
//     
//     public LootToUI dameUnBotinPrueba(){
//        return new LootToUI(model.dameUnBotinPrueba());
//    }
//     
//     public NumericDamageToUI dameUnNumericoPrueba(){
//         return new NumericDamageToUI(model.dameUnNumericoPrueba());
//     }
//    
//     public HangarToUI dameUnHangarPrueba(){
//         return new HangarToUI(model.dameUnHangarPrueba());
//     }
//     
//     public SpecificDamageToUI dameUnEspecificoPrueba(){
//         return new SpecificDamageToUI(model.dameUnEspecificoPrueba());
//     }
//     
//     public EnemyToUI dameUnEnemigoPrueba(){
//         return new EnemyToUI(model.dameUnEnemigoPrueba());
//     }
//     
//    public SpaceStationToUI dameUnaEstacionPrueba(){
//         return new SpaceStationToUI(model.dameUnaEstacionPrueba());
//     }
}
