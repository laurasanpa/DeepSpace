/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package deepspace;
import java.util.ArrayList;
/**
 *
 * @author laura
 */
public class Hangar implements Copyable<Hangar>{
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters= new ArrayList();
    private ArrayList<Weapon> weapons = new ArrayList();
    
    Hangar(int capacity){
        maxElements=capacity;
    }
    
    Hangar(Hangar h){
        maxElements=h.maxElements;
        shieldBoosters=h.shieldBoosters;
        weapons=h.weapons;
    }
    
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    private boolean spaceAvailable(){
            return (shieldBoosters.size()+weapons.size()<maxElements);
    }
    
    public boolean addWeapon(Weapon w){
        if (spaceAvailable()){
            weapons.add(w);
            return true;
        }
        else
            return false;
    }
    
    public boolean addShieldBooster(ShieldBooster s){
        if (spaceAvailable()){
            shieldBoosters.add(s);
            return true;
        }
        else
            return false;
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    } 
    public Weapon removeWeapon(int w){
        if(w>=0 && w<weapons.size())
        return weapons.remove(w);
        return null;
    }   
    
    public ShieldBooster removeShieldBooster(int s){
        if(s>=0 && s<shieldBoosters.size())
        return shieldBoosters.remove(s);
        return null;
    }

    @Override
    public String toString() {
        return "Hangar{" + "maxElements=" + maxElements + ", shieldBoosters=" + shieldBoosters + ", weapons=" + weapons + '}';
    }

    @Override
    public Hangar copy() {
       return new Hangar(this);
    }
    

    
    
    
}
