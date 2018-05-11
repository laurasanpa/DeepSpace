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
 * @author samuel
 */
public class NumericDamage extends Damage {
    
        NumericDamage(int w, int s){
        super(w,s);
    }
        
    @Override
    public Damage copy(){
        return new NumericDamage(this.getNWeapons(),this.getNShields()); 
    }
    
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        Damage d = new NumericDamage( java.lang.Math.min(nWeapons,w.size()),java.lang.Math.min(nShields,s.size()));
            return d;
    }
    
    @Override
    void discardWeapon(Weapon w){
        if(nWeapons>0)
          nWeapons -=1;
    }
    
        public int getNWeapons() {
        return nWeapons;
    }
        
    @Override
    public boolean hasNoEffect(){
        return (nShields==0 && nWeapons == 0);
    }    
    
    @Override
    NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }    
}
