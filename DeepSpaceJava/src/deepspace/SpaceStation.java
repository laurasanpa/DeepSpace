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
public class SpaceStation implements SpaceFighter{
    
    private static int MAXFUEL = 100;
    private static double SHIELDLOSSPERUNIT = 0.1;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons = new ArrayList();
    private ArrayList<ShieldBooster> shieldBoosters = new ArrayList();
    private Hangar hangar;
    
    
    SpaceStation(String n,SuppliesPackage supplies){
        name=n;
        ammoPower=supplies.getAmmoPower();
        fuelUnits=supplies.getFuelUnits();
        shieldPower=supplies.getShieldPower();
        pendingDamage=null;
        hangar=null;
    }
    
    public SpaceStation(SpaceStation station){
       name=station.name;
       ammoPower = station.ammoPower;
       fuelUnits=station.fuelUnits;
       shieldPower=station.shieldPower;
       pendingDamage=station.pendingDamage;
       hangar=station.hangar;
    }

    
    private void assignFuelValue(float f){
        if (f<=MAXFUEL)
            fuelUnits=f;
    }
    
    private void cleanPendingDamage(){
        pendingDamage=null;
    }
    
    public void cleanUpMountedItems(){
        ArrayList<Weapon> aux= new ArrayList<Weapon>();
        for(int i=0; i<weapons.size();i++){
            if(weapons.get(i).getUses()!=0)
                aux.add(weapons.get(i));
        }
        weapons = aux;
        
        ArrayList<ShieldBooster> aux2 = new ArrayList<ShieldBooster>();
        for(int i=0; i<shieldBoosters.size();i++){
            if(shieldBoosters.get(i).getUses()!=0)
                aux2.add(shieldBoosters.get(i));
        }
        
        shieldBoosters = aux2;
    }
    
    public void discardWeaponInHangar(int i){
        if(hangar !=null)
            hangar.removeWeapon(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (hangar != null)
            hangar.removeShieldBooster(i);
    }
    
    public void discardHangar(){
        if (hangar != null)
            hangar = null;
    }
    

    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public String getName() {
        return name;
    }

    public int getNMedals() {
        return nMedals;
    }

    public float getShieldPower() {
        return shieldPower;
    }

    public Damage getPendingDamage() {
        return pendingDamage;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        return shieldBoosters;
    }

    public Hangar getHangar() {
        return hangar;
    }
     
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    
    public void mountWeapon(int i){
        if (hangar!= null){
             Weapon h = hangar.removeWeapon(i);    
            if(h!=null)
                weapons.add(h);
        }
    }
    
    public void mountShieldBooster(int i){
        if (hangar!= null){
            ShieldBooster h = hangar.removeShieldBooster(i);    
             if(h!=null)
                shieldBoosters.add(h);
        }   
    }
    
    public boolean receiveWeapon(Weapon w){
        if (hangar != null){
            return hangar.addWeapon(w);
        } else 
            return false;
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if (hangar !=null){
            return hangar.addShieldBooster(s);
        }else 
            return false;
    }
    
    public void receiveHangar(Hangar h){
        if (hangar == null)
            hangar = h;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+=s.getAmmoPower();
        shieldPower=s.getShieldPower();
        assignFuelValue(fuelUnits+s.getFuelUnits());
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage=d.adjust(weapons,shieldBoosters);
    }
    
   
    public void move(){
        fuelUnits-= getSpeed();
    }
    
    public boolean validState(){
        return (pendingDamage== null ||pendingDamage.hasNoEffect());
    }
    
    
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public void discardShieldBooster(int i){
        int size = shieldBoosters.size();
        if(i>=0 && i<size){
            ShieldBooster sh = shieldBoosters.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }
    

    
    public void discardWeapon(int i){
        int size = weapons.size();
        if(i>=0 && i<size){
            Weapon w=weapons.remove(i);
            if(pendingDamage!=null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }
    
    
    
    public float fire(){
       int size = weapons.size();
       float factor =1;
       
       for(int i=0; i<size;++i){
           Weapon w = weapons.get(i);
           factor*=w.useIt();
       }
       return ammoPower * factor;
    }
    
    public float protection(){
        int size = shieldBoosters.size();
        float factor=1;
        for (int i=0; i<size; ++i){
            ShieldBooster s = shieldBoosters.get(i);
            factor*=s.useIt();
        }
        return shieldPower*factor;
    }
    
    public ShotResult receiveShot(float shot){
        float myProtection = protection();
        
        if (myProtection>=shot){
            shieldPower-=SHIELDLOSSPERUNIT*shot;
            shieldPower=Math.max(0,shieldPower);
            return ShotResult.RESIST;
        }
        else{
            shieldPower=0;
            return ShotResult.DONOTRESIST;
        }
    }
    
    public Transformation setLoot(Loot loot){
        CardDealer dealer = CardDealer.getInstance();
        int h = loot.getNHangars();
        
        if(h>0){
            Hangar hangar= dealer.nextHangar();
            receiveHangar(hangar);
        }
        
        int elements = loot.getNSupplies();
        for(int i=0; i<elements; ++i){
            SuppliesPackage sup = dealer.nextSuppliesPackage();
            receiveSupplies(sup);
        }
        elements = loot.getNShields();
        for(int i=0; i<elements; ++i){
            Weapon weap = dealer.nextWeapon();
            receiveWeapon(weap);
        }
        
        elements = loot.getNShields();
        for(int i=0; i <elements;++i){
            ShieldBooster sh = dealer.nextShieldBooster();
            receiveShieldBooster(sh);
        }
        
        int medals=loot.getNMedals();
        nMedals+=medals;
        
        if (loot.getEfficient()==true)
            return Transformation.GETEFFICIENT;
        else if(loot.spaceCity()==true)
            return Transformation.SPACECITY;
        else 
            return Transformation.NOTRANSFORM;
        
    }
    
    
    
}
