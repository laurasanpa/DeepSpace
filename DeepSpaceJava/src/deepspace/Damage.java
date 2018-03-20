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
    
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        throw new UnsupportedOperationException();
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
       return w.indexOf(t); 
    }
    
    public boolean hasNoEffect(){
        if(nWeapons==-1){
            return(nShields==0 && weapons == null);
        } else{
            return (nShields==0 && nWeapons == 0);
        }
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
    
    
}
