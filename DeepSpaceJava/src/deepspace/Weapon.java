/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel Medina
 * @author Laura Sánchez
 */
package deepspace;

class Weapon {
    
    private String name;
    private WeaponType type;
    private int uses;
    
    public Weapon( String n, WeaponType t, int u){
        name = n;
        type = t;
        uses = u;
    }
    
    public Weapon(Weapon s){
        Weapon copy = new Weapon(s.name, s.type, s.uses);
    }
    
    public WeaponType getType(){
        return type;
    }
    
    public int getUses(){
        return uses;
    }

    public float power(){
        return this.type.getPower();
    }
    
    public float useIt(){
             if(uses>0){
            uses--;
            return this.power();
        }else
            return (float) 1.0;
    }
    
       
    
    
}
