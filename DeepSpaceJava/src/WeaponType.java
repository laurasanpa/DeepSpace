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

public enum WeaponType {
    /* Podría necesitar arreglos, a la espera del correo de prácticas*/
    
    LASER((float) 2.0), MISSILE((float) 3.0), PLASMA((float) 4.0);
    
    private float power;
    
    WeaponType(float p){
        this.power = p;
    }
    
    float getPower(){
        return power;
    }
    
}
