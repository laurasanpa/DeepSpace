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
    }
    
    
}
