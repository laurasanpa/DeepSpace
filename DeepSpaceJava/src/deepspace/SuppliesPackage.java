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
    /**
     * Constructor de copias: genera una nueva instancia de SuppliesPackage a partir 
     * de una instancia ya creada dada como parámetro.
     * @param s (SuppliesPackage)
     * @return copy (Nueva instancia)
     */
    public SuppliesPackage SuppliesPackage(SuppliesPackage s){
        SuppliesPackage copy = new SuppliesPackage(s.ammoPower, s.fuelUnits, s.shieldPower);
        return copy;
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
}
