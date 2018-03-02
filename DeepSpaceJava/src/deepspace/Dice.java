
/**
 *
 * @author Samuel Medina
 * @author Laura Sánchez
 */
package deepspace;

import java.util.Random;

class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    
    private Random generator;
    
   
    Dice(){
        NHANGARSPROB=(float) 0.25;
        NSHIELDSPROB=(float) 0.25;
        NWEAPONSPROB=(float) 0.33;
        FIRSTSHOTPROB=(float) 0.5;
        generator=new Random();
       
    }
    
    /**
     * initWithNHangars: Determina el número de hangares que recibirá una estación al ser
     * creada.
     * @return Devuelve 0 con la probabilidad de NHANGARSPROB y 1 en caso contrario. 
    */
    public int initWithNHangars(){
        if(generator.nextDouble()<=NHANGARSPROB){
            return 0;
        }else
            return 1;
    }
    
    /**
     * int initWithNWeapons: Este método determina el número de armas que 
     * recibirá una estación espacial al ser creada.
     * @return devuelve 1 con una probabilidad de NWEAPONSPROB, 2 con la misma
     * probabilidad y 3 con una probabilidad de (1-2* NWEAPONSPROB)
     */
    public int initWithWeapons(){
       double prob= generator.nextDouble();
       if(prob<NWEAPONSPROB)
           return 1;
       else if(prob>NWEAPONSPROB && prob<(2*NWEAPONSPROB))
           return 2;
       else
           return 3; 
    }
    
    /**
     * int initWithNShields: Este método determina el número de potenciadores de escudo que recibirá una estación espacial al
     * ser creada.
     * @return devuelve 0 con una probabilidad de NSHIELDSPROB y 1 en caso contrario.
     */
    public int initWithShields(){
        if( generator.nextDouble()< NSHIELDSPROB)
            return 0;
        else
            return 1;
    }
    
    /**
     * int whoStarts(int nPlayers): El método whoStarts determina el jugador (su índice) que
     * iniciará la partida.
     * @return genera un número aleatorio del intervalo [0,nPlayers-1].
     * @param nPlayer, número de jugadores.
     */
    
     public int whoStarts(int nPlayers){
         return generator.nextInt(nPlayers);
     }
     
     
}
