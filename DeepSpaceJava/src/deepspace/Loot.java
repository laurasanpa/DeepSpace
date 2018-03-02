/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
// Constructor.
    public Loot(int supplies , int weapons , int shields , int hangars , int medals){
        
        nSupplies=supplies;
        nWeapons=weapons;
        nShields=shields;
        nHangars=hangars;
        nMedals=medals;
        
    }
    
// Consultores de atributo.
    public int getNSupplies(){
        return nSupplies;
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public int getNHangars(){
        return nHangars;
    }
    
    public int getNMedals(){
        return nMedals;
    }
}
