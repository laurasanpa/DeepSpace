/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;


/**
 *
 * @author samuel
 */
public class SpaceCity extends SpaceStation {
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        collaborators = rest;
        this.base = base;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    public float fire(){
        float fire=0;
        fire += super.fire();
        for(int i=0; i<collaborators.size();++i){
            fire += collaborators.get(i).fire();
        }
        return fire;
    }
    
    public float protection(){
        float pro=0;
        pro += super.protection();
        for(int i=0; i<collaborators.size();++i){
            pro += collaborators.get(i).protection();
        }
        return pro;  
    }
    
    public Transformation setLoot(Loot loot){
           super.setLoot(loot);
           return Transformation.NOTRANSFORM;
    }
    
    public SpaceCityToUI getUIversion(){
        return new SpaceCityToUI(this);
    }
}
