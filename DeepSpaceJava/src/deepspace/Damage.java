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
       /* if(weapons!=null){
            ArrayList<WeaponType> auxweapons= new ArrayList<WeaponType>();
            auxweapons.addAll(weapons);
            ArrayList<WeaponType> h= new ArrayList<WeaponType>();
            for(int i=0; i<w.size(); ++i){
                if(arrayContainsType(auxweapons, w.get(i).getType())!=-1){
                    h.add(auxweapons.get(arrayContainsType(auxweapons, w.get(i).getType())));
                    auxweapons.remove(arrayContainsType(auxweapons, w.get(i).getType()));
                }
            }
            Damage d = new Damage(h, java.lang.Math.min(nShields,s.size()));
            return d;
        }else{
            Damage d = new Damage( java.lang.Math.min(nWeapons,w.size()),java.lang.Math.min(nShields,s.size()));
            return d;
        } */
       
       if (nWeapons == -1) {//Entonces es específico
          ArrayList<WeaponType> aux = new ArrayList<WeaponType>();
          ArrayList<WeaponType> res = new ArrayList<WeaponType>();
          
        for (Weapon elemento:w)
            aux.add(elemento.getType());
               
        WeaponType wtypes [] = WeaponType.values();
        for(int i = 0; i < wtypes.length; i+=1) {
            int min = Math.min(Collections.frequency(aux, wtypes[i]),Collections.frequency(weapons, wtypes[i]));
            for(int j = 0; j < min; j+=1)
                res.add(wtypes[i]);
        } 
        
        return new Damage(res,Math.min(nShields,s.size()));
        } else //Entonces es numérico
           return new Damage(Math.min(nWeapons,w.size()), Math.min(nShields,s.size()));
       
    }
    
    private int arrayContainsType(ArrayList<WeaponType> w, WeaponType t){
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
