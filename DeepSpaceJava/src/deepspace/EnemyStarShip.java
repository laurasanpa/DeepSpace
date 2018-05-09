/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author samuel y Laura
 */
public class EnemyStarShip implements SpaceFighter {
    
    private float ammoPower;
    String name;
    float shieldPower;
    Loot loot;
    Damage damage;
    
    
   EnemyStarShip(String n, float a, float s, Loot l, Damage d){
       ammoPower=a;
       name=n;
       shieldPower=s;
       loot = l;
       damage=d;
   }
   
   EnemyStarShip(EnemyStarShip e){
       
       ammoPower=e.ammoPower;
       name=e.name;
       shieldPower=e.shieldPower;
       loot =e.loot;
       damage=e.damage;
   }
   
   public float fire(){
       return ammoPower;
   }
   
    public float getAmmoPower() {
        return ammoPower;
    }
    
     public String getName() {
        return name;
    }

    public float getShieldPower() {
        return shieldPower;
    }

    public Loot getLoot() {
        return loot;
    }

    public Damage getDamage() {
        return damage;
    }
   
    EnemyToUI getUIversion(){
       return new EnemyToUI(this);
    }
   
    public float protection(){
       return shieldPower;
    }
 
    public ShotResult receiveShot(float shot){
        if(shot>shieldPower){
            return ShotResult.DONOTRESIST;
        } else
            return ShotResult.RESIST;
    }

    @Override
    public String toString() {
        return "EnemyStarShip{" + "name=" + name + ", shieldPower=" + shieldPower + ", loot=" + loot + ", damage=" + damage + '}';
    }


    
    
}
