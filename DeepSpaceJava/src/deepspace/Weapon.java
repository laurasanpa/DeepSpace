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

class Weapon implements CombatElement{
    
    private String name;
    private WeaponType type;
    private int uses;
    
    public Weapon( String n, WeaponType t, int u){
        name = n;
        type = t;
        uses = u;
    }
     /**
     * Constructor de copias: genera una nueva instancia de Weapon a partir 
     * de una instancia ya creada dada como parámetro.
     * @param s 
     * @return copy 
     */
    public Weapon(Weapon s){
        name=s.name;
        type=s.type;
        uses=s.uses;
    }
     /**
     * getType: devuelve el valor de atributo de la instancia type
     * @return type
     */
    public WeaponType getType(){
        return type;
    }
    
     /**
     * getUses: devuelve el valor de atributo de la instancia uses
     * @return uses
     */
    public int getUses(){
        return uses;
    }
     /**
     * power(): 
     * @return type
     */
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
    
    @Override
    public String toString(){
        return "Name:" + name + ",," + "Type:" + type + ",," + "Uses:" + uses;       
    }
    
    public WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }



    
    
    
       
    
    
}
