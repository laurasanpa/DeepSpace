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
public class SpaceStation {
    
    private static int MAXFUEL = 100;
    private static double SHIELDLOSSPERUNIT = 0.1;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    Hangar hangar;
    
    private void assignFuelValue(float f){
        if (f<=MAXFUEL)
            fuelUnits=f;
    }
    
    private void cleanPendingDamage(){
        pendingDamage=null;
    }
    
    SpaceStation(String n,SuppliesPackage supplies){
        name=n;
        ammoPower=supplies.getAmmoPower();
        fuelUnits=supplies.getFuelUnits();
        shieldPower=supplies.getShieldPower();
        pendingDamage=null;
        weapons=null;
        shieldBoosters=null;
        hangar=null;
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
    
    public void discardHangar(){
        if (hangar != null)
            hangar = null;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower+=s.getAmmoPower();
        shieldPower=s.getShieldPower();
        assignFuelValue(fuelUnits+s.getFuelUnits());
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage=d;
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
    
    public void discardWeaponInHangar(int i){
        if(hangar !=null)
            hangar.removeWeapon(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if (hangar != null)
            hangar.removeShieldBooster(i);
    }
    
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    public void move(){
        fuelUnits-= getSpeed();
    }
    
    public boolean validState(){
        return pendingDamage== null;
    }
    
    public void cleanUpMountedItems(){
        for(int i = 0;i<=weapons.size();++i){
            if(weapons.get(i).getUses()==0)
                weapons.remove(i);
        }
        for(int i = 0;i<=shieldBoosters.size();++i){
            if(shieldBoosters.get(i).getUses()==0)
                shieldBoosters.remove(i);
        }        
    }
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    

    
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public float fire(){
       throw new UnsupportedOperationException();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult receiveShot(float i){
        throw new UnsupportedOperationException();
    }
    
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    
    
}
