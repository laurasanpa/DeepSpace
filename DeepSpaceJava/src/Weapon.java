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

package DeepSpaceJava

class Weapon {
    
    private String name;
    private Weapontype type;
    private int uses;
    
    public Weapon( String n, Weapontype t, int u){
        name = n;
        type = t;
        uses = u;
    }
    
    public Weapon(Weapon s){
        Weapon copy = new Weapon(s.getName(), s.getType(), s.getUses());
        return copy;
    }
    
    public getType(){
        return type;
    }
    
    public getUses(){
        return uses;
    }
    
    
}
