/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
import java.util.ArrayList;
/**
 *
 * @author samuel y Laura
 */
public class GameUniverse {
    private static int WIN =10;
    private int currentStationIndex;
    private int turns;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    private EnemyStarShip currentEnemy;
    private GameStateController gameState;
    
    GameUniverse(){
        currentEnemy=null;
        currentStation=null;
        gameState= new GameStateController();
        dice = new Dice();
        spaceStations = null;
        currentStationIndex=0;
        turns=0;
    }
    
    
    public void discardHangar(){
        if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    }
    
    public void mountShieldBooster(int i){
        if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.mountShieldBooster(i);
    }
    
    public void discardShieldBooster(int i){
              if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }
    
    
    public void discardShieldBoosterInHangar(int i){
              if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    public void mountWeapon(int i){
        if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.mountWeapon(i);
    }
    
    public void discardWeapon(int i){
              if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.discardWeapon(i);
    }
    
    public void discardWeaponInHangar(int i){
              if (gameState.getState()==GameState.INIT || gameState.getState()==GameState.AFTERCOMBAT)
            currentStation.discardWeaponInHangar(i);
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public GameState getState(){
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIVersion(){
        return new GameUniverseToUI(currentStation, currentEnemy);
    }
    
    public boolean haveAWinner(){
        return (currentStation.getNMedals()==10);       
    }
    
    public void init(String name){
        throw new UnsupportedOperationException();
    }
    
    public boolean nextTurn(){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", currentStation=" + currentStation + ", spaceStations=" + spaceStations + ", currentEnemy=" + currentEnemy + ", gameState=" + gameState + '}';
    }
    
    
}
