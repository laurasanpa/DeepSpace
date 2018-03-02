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

class ShieldBooster {
    
    // Definición de atributos
    private String name;
    private float boost;
    private int uses;
    
    // Constructor 
    public ShieldBooster(String n,float b,int u){
        name = n;
        boost = b;
        uses = u;
    }
    
    // Constructor de copias
    public ShieldBooster(ShieldBooster s){
        ShieldBooster shield = new ShieldBooster(s.name, s.boost, s.uses);
    }
    
    // Consultores
    public String getName(){
        return name;
    }
    
    public float getBoost(){
        return boost;
    }
    
    public int getUses(){
        return uses;
    }
    
    /* Useit: Decrementa uses si uses>0 y
    Devuelve el valor de boost, duelve 1.0 en otro caso*/
    public float useIt(){
        if(uses>0){
            uses--;
            return boost;
        }else
            return (float) 1.0;
    }
    
    
    }
   
   
    
    
