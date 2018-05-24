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
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
     static float EXTRAEFFICIENCY=(float)1.20;
     
     public BetaPowerEfficientSpaceStation(SpaceStation station){
         super(station);
     }
     
    public float fire(){
        return super.fire()*EXTRAEFFICIENCY;
    }
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
    

}
