/**
 *
 * @author Samuel Medina
 * @authot Laura Sánchez
 */
package deepspace;
        
class Loot {

// Definición de atributos.
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
/**
 * Constructor
 * @param supplies
 * @param weapons
 * @param shields
 * @param hangars
 * @param medals 
 */ 
    public Loot(int supplies , int weapons , int shields , int hangars , int medals){
        
        nSupplies=supplies;
        nWeapons=weapons;
        nShields=shields;
        nHangars=hangars;
        nMedals=medals;
        
    }
    
/**
 * getNSupplies: devuelve el número de supplies de una instancia del botín
 * @return nSupplies
 */
    public int getNSupplies(){
        return nSupplies;
    }
    
    
/**
 * getNWeapons: devuelve el número de armas de una instancia del botín
 * @return nWeapons
 */
    public int getNWeapons(){
        return nWeapons;
    }
 /**
 * getNShields: devuelve el número de escudos de una instancia del botín
 * @return nShields
 */  
    public int getNShields(){
        return nShields;
    }
/**
 * getNHangars: devuelve el número de hangares de una instancia del botín
 * @return nHangars
 */    
    public int getNHangars(){
        return nHangars;
    }
/**
 * getNMedals: devuelve el número de medallas de una instancia del botín
 * @return nMedals
 */    
    public int getNMedals(){
        return nMedals;
    }
}
