/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
import java.util.ArrayList;
import java.util.Collections;
        

/**
 *
 * @author laura
 */
public abstract class  Damage {
    protected int nShields;
    protected int nWeapons;
    protected ArrayList<WeaponType> weapons;
    
    Damage(int w, int s){
        nWeapons=w;
        nShields=s;
        weapons=null;
    }
    
    Damage(ArrayList<WeaponType> wl, int s){
        nWeapons=-1;
        nShields=s;
        weapons=wl;
    }
    
    public abstract Damage copy();
    
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
       

    
    

    
    void discardShieldBooster(){
     if(nShields >0)
        nShields-=1;
    }
    
     abstract void discardWeapon(Weapon w);
    
  
    abstract DamageToUI getUIversion();
    
    public int getNShields() {
        return nShields;
    }




      
    public abstract boolean hasNoEffect();
    
    
    @Override
    public String toString() {
        return "Damage{" + "nShields=" + nShields + ", nWeapons=" + nWeapons + ", weapons=" + weapons + '}';
    }
    
    
}
