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
    private Dice dice = new Dice();
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations = new ArrayList();
    private EnemyStarShip currentEnemy;
    private GameStateController gameState = new GameStateController();
    
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
    
    public void init(ArrayList<String> names){
        GameState state = gameState.getState();
        if (state==GameState.CANNOTPLAY){
          //  ArrayList< No se bien si hay que crear aqui el vector, creo que lo tenemos mal lau
          CardDealer dealer = CardDealer.getInstance();
          for(int i = 0; i<names.size();++i){
              SuppliesPackage supplies = dealer.nextSuppliesPackage();
              SpaceStation station = new SpaceStation(names.get(i),supplies);
               int nh = dice.initWithNHangars();
               int nw = dice.initWithNWeapons();
               int ns = dice.initWithNShields();
               Loot l = new Loot(0, nw, ns, nh, 0);
               station.setLoot(l);
               spaceStations.add(station);
          }
          currentStationIndex = dice.whoStarts(names.size());
          currentStation=spaceStations.get(currentStationIndex);
          currentEnemy=dealer.nextEnemy();
          gameState.next(turns, spaceStations.size());
          
        }
    }
    
    public boolean nextTurn(){
        GameState state = gameState.getState();
        
        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
            
            if(stationState){
                currentStationIndex=(currentStationIndex+1)%(spaceStations.size());
                turns++;
                currentStation=spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", currentStation=" + currentStation + ", spaceStations=" + spaceStations + ", currentEnemy=" + currentEnemy + ", gameState=" + gameState + '}';
    }
    
    
}
