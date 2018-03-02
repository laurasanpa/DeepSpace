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

class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    
    public SuppliesPackage(float power, float fuel, float shield){
        ammoPower = power;
        fuelUnits = fuel;
        shieldPower = shield;
    }
    
    public SuppliesPackage SuppliesPackage(SuppliesPackage s){
        SuppliesPackage copy = new SuppliesPackage(s.ammoPower, s.fuelUnits, s.shieldPower);
        return copy;
    }
    
// Consultores
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
}
