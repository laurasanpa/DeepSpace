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
public class SpecificDamage extends Damage {
    SpecificDamage(ArrayList<WeaponType> wl, int s){
        super(wl,s);
    }
    
    @Override
    public Damage copy(){
        return new SpecificDamage(this.getWeapons(),this.getNShields()); 
    }
    
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
            ArrayList<WeaponType> auxweapons= new ArrayList<WeaponType>();
        auxweapons.addAll(weapons);
        ArrayList<WeaponType> h= new ArrayList<WeaponType>();
        for(int i=0; i<w.size(); ++i){
            if(arrayContainsType(auxweapons, w.get(i).getType())!=-1){
                h.add(auxweapons.get(arrayContainsType(auxweapons, w.get(i).getType())));
                auxweapons.remove(arrayContainsType(auxweapons, w.get(i).getType()));
            }
        }
        Damage d = new SpecificDamage(h, java.lang.Math.min(nShields,s.size()));
        return d;
    }
        
    private int arrayContainsType(ArrayList<WeaponType> w, WeaponType t){
        return w.indexOf(t);
    }
    
    @Override
    void discardWeapon(Weapon w){
        weapons.remove(w.getType());
    }
    
    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }
    
    @Override
    public boolean hasNoEffect(){
        return(nShields==0 && weapons.size()==0);
    }
    
    SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
    
    
}
