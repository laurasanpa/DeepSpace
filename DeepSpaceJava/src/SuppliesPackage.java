/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    
    public SuppliesPackage(float power, float fuel, float shield){
        ammoPower = power;
        fuelUnits = fuel;
        shieldPower = shield;
    }
    
    public SuppliesPackage(SuppliesPackage s){
        copy=new SuppliesPackage(s.getAmmoPower(), s.getFuelUnits(), s.getShieldPower());
        return copy;  
    }
    
// Consultores
    
    public getAmmoPower(){
        return ammoPower;
    }
    
    public getFuelUnits(){
        return FuelUnits;
    }
    
    public getShieldPower(){
        return shieldPower;
    }
}
