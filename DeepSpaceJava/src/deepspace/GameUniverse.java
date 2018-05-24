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
    private static int WIN =1;
    private int currentStationIndex;
    private int turns;
    private Dice dice = new Dice();
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    private EnemyStarShip currentEnemy;
    private GameStateController gameState = new GameStateController();
    private boolean haveSpaceCity;
    
    public GameUniverse(){
        currentEnemy=null;
        currentStation=null;
        gameState= new GameStateController();
        dice = new Dice();
        spaceStations = new ArrayList();
        currentStationIndex=0;
        turns=0;
    }
    
    boolean gethaveSpaceCity(){
        return haveSpaceCity;
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
        
        GameCharacter ch = dice.firstShot();
        boolean enemyWins;
        float fire;
        ShotResult result;
        CombatResult combatResult; 
        if ( ch == GameCharacter.ENEMYSTARSHIP ) {
            fire = enemy.fire();
            result = station.receiveShot(fire);

            if( result == ShotResult.RESIST){
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            } else
                 enemyWins = true;
        } else {
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);
}
        
    if(enemyWins) {
         float s = station.getSpeed();
         boolean moves = dice.spaceStationMoves(s);

         if (!moves) {
             Damage damage = enemy.getDamage();
             station.setPendingDamage(damage);
             combatResult = CombatResult.ENEMYWINS;
         } else {
             station.move();
             combatResult = CombatResult.STATIONESCAPES;
         }            
     } else {
        
        Loot aLoot = enemy.getLoot();
        station.setLoot(aLoot);
        if(aLoot.getEfficient()){
            makeStationEfficient();
            combatResult= CombatResult.STATIONWINSANDCONVERTS;
        } else if (aLoot.spaceCity()){
            createSpaceCity();
            combatResult= CombatResult.STATIONWINSANDCONVERTS;
        } else
        combatResult= CombatResult.STATIONWINS;
    } 
        gameState.next(turns,spaceStations.size());
        return combatResult;
    }
 
    
    public CombatResult combat(){
        GameState state = gameState.getState();
        if(state==GameState.BEFORECOMBAT|| state == GameState.INIT){
            return combat(currentStation,currentEnemy);
        }else
            return CombatResult.NOCOMBAT;
    }
    
    
    
    private void createSpaceCity(){
        if(haveSpaceCity==false){
            currentStation = new SpaceCity(currentStation, spaceStations);
            haveSpaceCity=true;
        }
    }
    
    public GameState getState(){
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(currentStation, currentEnemy);
    }
    
    public boolean haveAWinner(){
        return (currentStation.getNMedals()==WIN);       
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
    
    private void makeStationEfficient(){
        boolean change = dice.extraEfficiency();
        if(change)
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);
        else 
            currentStation = new PowerEfficientSpaceStation(currentStation);
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
    
    //DUDA
    
    public boolean canIGoOn(){
        return(getState()==GameState.AFTERCOMBAT && currentStation.validState());
    }

    @Override
    public String toString() {
        return "GameUniverse{" + "currentStationIndex=" + currentStationIndex + ", turns=" + turns + ", dice=" + dice + ", currentStation=" + currentStation + ", spaceStations=" + spaceStations + ", currentEnemy=" + currentEnemy + ", gameState=" + gameState + '}';
    }
    
    //Pruebas
    
//    public ShieldBooster dameUnEscudoPrueba(){
//        return new ShieldBooster("Lola", (float) 2.0, 3);
//    }
//    
//    public Weapon dameUnArmaPrueba(){
//        return new Weapon("Lolo",WeaponType.LASER, 1);
//    }
//    
//    public Loot dameUnBotinPrueba(){
//        return new Loot(1,2,3,4,5);
//    }
//    
//    public NumericDamage dameUnNumericoPrueba(){
//        return new NumericDamage(2,3);
//    }
//    
//    public Hangar dameUnHangarPrueba(){
//        Hangar h = new Hangar(3);
//        h.addWeapon(dameUnArmaPrueba());
//        h.addWeapon(dameUnArmaPrueba());
//        h.addWeapon(dameUnArmaPrueba());
//        return h;
//    }
//    
//    
//    public SpecificDamage dameUnEspecificoPrueba(){
//        ArrayList<WeaponType> aux = new ArrayList();
//        aux.add(WeaponType.LASER);
//        aux.add(WeaponType.PLASMA);
//        aux.add(WeaponType.LASER);
//        
//        return new SpecificDamage(aux,2);
//    }
//    
//    public EnemyStarShip dameUnEnemigoPrueba(){
//        return new EnemyStarShip("LauritaSanpa",(float) 4.0,(float)3.0,dameUnBotinPrueba(),dameUnEspecificoPrueba());
//    } 
//    
//    public SpaceStation dameUnaEstacionPrueba(){
//        
//        SuppliesPackage paq = new SuppliesPackage(2,1,1);
//        SpaceStation sp = new SpaceStation("Laurita", paq);
//        Hangar h = new Hangar(3);
//        h.addWeapon(dameUnArmaPrueba());
//        h.addWeapon(dameUnArmaPrueba());
//        h.addShieldBooster(dameUnEscudoPrueba());
//        sp.receiveHangar(h);
//        sp.mountWeapon(0);
//        sp.mountWeapon(0);
//        sp.mountShieldBooster(0);
//         h.addWeapon(dameUnArmaPrueba());
//         
//        ArrayList<WeaponType> aux = new ArrayList();
//        aux.add(WeaponType.LASER);
//        aux.add(WeaponType.PLASMA);
//        aux.add(WeaponType.LASER);
//        
//        SpecificDamage d =new SpecificDamage(aux,2);
//        sp.setPendingDamage(d);
//        return sp;
//        
//    } 
}
