/**
 *
 * @author Samuel Medina
 * @author Laura Sánchez
 */
package deepspace;

class SuppliesPackage implements Copyable<SuppliesPackage>{
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    
    public SuppliesPackage(float power, float fuel, float shield){
        ammoPower = power;
        fuelUnits = fuel;
        shieldPower = shield;
    }
    /**
     * Constructor de copias: genera una nueva instancia de SuppliesPackage a partir 
     * de una instancia ya creada dada como parámetro.
     * @param s (SuppliesPackage)
     */
    public SuppliesPackage(SuppliesPackage s){
        ammoPower=s.ammoPower;
        fuelUnits=s.fuelUnits;
        shieldPower=s.shieldPower;
    }
    
    
    /**
     * getAmmoPower: devuelve el valor de atributo de la instancia ammoPower
     * @return ammoPower
     */
    
    public float getAmmoPower(){
        return ammoPower;
    }
    /**
     * getFuelUnits(): devuelve el valor del atributo de la instancia fuelUnits
     * @return fuelUnits
     */
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    /**
     * getShieldPower(): devuelve el valor del atributo de la instancia shieldPower
     * @return shieldPower
     */
    
    public float getShieldPower(){
        return shieldPower;
    }

    @Override
    public String toString() {
        return "SuppliesPackage{" + "ammoPower=" + ammoPower + ", fuelUnits=" + fuelUnits + ", shieldPower=" + shieldPower + '}';
    }

    @Override
    public SuppliesPackage copy() {
        return new SuppliesPackage(this);
    }
    

}
