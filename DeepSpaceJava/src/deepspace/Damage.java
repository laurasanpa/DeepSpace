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
public class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
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
    
    Damage (Damage d){
        nWeapons=d.nWeapons;
        nShields=d.nShields;
        weapons=d.weapons;
    }
    
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        throw new UnsupportedOperationException();
        // No merece implementarlo hasta la 4 porque hay que usar herencia. 
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
       return w.indexOf(t); 
    }
    
    void discardShieldBooster(){
     if(nShields >0)
        nShields-=1;
    }
    
    void discardWeapon(Weapon w){
        if (nWeapons == -1)
          weapons.remove(w.getType());
        else if(nWeapons>0)
          nWeapons -=1;
    }
  
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    public int getNShields() {
        return nShields;
    }

    public int getNWeapons() {
        return nWeapons;
    }

    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }
      
    public boolean hasNoEffect(){
        if(nWeapons==-1){
            return(nShields==0 && weapons.size()==0);
        } else{
            return (nShields==0 && nWeapons == 0);
        }
    }

    @Override
    public String toString() {
        return "Damage{" + "nShields=" + nShields + ", nWeapons=" + nWeapons + ", weapons=" + weapons + '}';
    }
    
    
}
