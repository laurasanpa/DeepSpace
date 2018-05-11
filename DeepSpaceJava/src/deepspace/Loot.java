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
    private boolean getEfficient;
    private boolean spaceCity;
/**
 * Constructor
 * @param nSupplies
 * @param nWeapons
 * @param nShields
 * @param nHangars
 * @param nMedals 
 */ 
    public Loot(int supplies , int weapons , int shields , int hangars , int medals){
        
        nSupplies=supplies;
        nWeapons=weapons;
        nShields=shields;
        nHangars=hangars;
        nMedals=medals;
        getEfficient=false;
        spaceCity=false;

    }
    
    public Loot(int supplies , int weapons , int shields , int hangars , int medals, boolean ef, boolean city){
        nSupplies=supplies;
        nWeapons=weapons;
        nShields=shields;
        nHangars=hangars;
        nMedals=medals;       
        getEfficient = ef;
        spaceCity = city;
    }
    
    public boolean getEfficient(){
        return getEfficient;
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

    @Override
    public String toString() {
        return "Loot{" + "nSupplies=" + nSupplies + ", nWeapons=" + nWeapons + ", nShields=" + nShields + ", nHangars=" + nHangars + ", nMedals=" + nMedals + '}';
    }
    

    
    LootToUI getUIversion(){
        return new LootToUI(this);
    } 
    
    public boolean spaceCity(){
        return spaceCity;
    }
    
}
