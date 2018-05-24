/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author samuel
 */
public class PowerEfficientSpaceStation extends SpaceStation {
    static float EFFICIENCYFACTOR=(float) 1.10;
    
    public PowerEfficientSpaceStation(SpaceStation station){
        super (station);
    }
    
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    public Transformation setLoot(Loot loot){
           super.setLoot(loot);
           return Transformation.NOTRANSFORM;
    }
    
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
}
