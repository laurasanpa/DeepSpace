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
public class TestP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Esto es una prueba");
        System.out.print("\n");
        
        //Botín
        Loot Lote = new Loot(1,2,3,4,5);
        
//        System.out.print("El botín tiene las siguientes medallas:" + Lote.getNMedals());
//        System.out.print("\n");
//        System.out.print("El botín tiene las siguientes armas:" + Lote.getNWeapons());
//        System.out.print("\n");
//        System.out.print("El botín tiene los siguientes escudos:" + Lote.getNShields());
//        System.out.print("\n");
//        
        //Paquete de suministros
        
        SuppliesPackage paq = new SuppliesPackage(2,1,1);
        SuppliesPackage paq2 = new SuppliesPackage(paq);
        
//        System.out.print("El paquete de suministros tiene la siguiente cantidad de combustible:" + paq.getFuelUnits());
//        System.out.print("\n");
//        System.out.print("El paquete de suministros tiene la siguiente recarga de escudos:" + paq.getShieldPower());
//        System.out.print("\n");
//        
        //ShieldBooster
        String nombre = "Pepe";
        ShieldBooster recarga = new ShieldBooster(nombre,2,2);
        ShieldBooster recarga2 = new ShieldBooster(recarga);
        
//        System.out.print("Usos del potenciador de escudos:" + recarga.getUses());
//        System.out.print("\n");
//        System.out.print("useIt:" + recarga.useIt());
//        System.out.print("\n");
//        
        //Weapon
        String nombre1="lolita";
        WeaponType lolita=WeaponType.LASER;
        Weapon arma1 = new Weapon(nombre1,lolita,3);
        Weapon hermana = new Weapon(arma1);
        
//        System.out.print("Tipo de arma:" + arma1.getType());
//        System.out.print("\n");
//        System.out.print("Potencia de arma" + arma1.power());
//        System.out.print("\n");
//        
        //Dice
        Dice dado= new Dice();
        float num=(float) 0.5;
        
//        System.out.print("Número de hangares al inicio de la partida:" + dado.initWithNHangars());
//        System.out.print("\n");
//        System.out.print("Número de escudos al inicio de la partida:" + dado.initWithNShields());
//        System.out.print("\n");
//        System.out.print("Número de armas al inicio de la partida:" + dado.initWithNWeapons());
//        System.out.print("\n");
//        System.out.print("La primera jugada es para:" + dado.whoStarts(2));
//        System.out.print("\n");
//        System.out.print("Huimos?:" + dado.spaceStationMoves(num));
//        System.out.print("\n");
//        
        SpaceStation sp = new SpaceStation("Laurita", paq);
        Transformation t = sp.setLoot(Lote);
        if(t==Transformation.GETEFFICIENT){
            System.out.print("Eficiente \n");
        } else if(t==Transformation.SPACECITY){
            System.out.print("City \n"); 
        } else
             System.out.print("Normal \n");
        
         Loot Lote1 = new Loot(1,2,3,4,5, true, false);
         Transformation y = sp.setLoot(Lote1);
        if(y==Transformation.GETEFFICIENT){
            System.out.print("Eficiente \n");
        } else if(y==Transformation.SPACECITY){
            System.out.print("City \n"); 
        } else
             System.out.print("Normal \n");
        
          BetaPowerEfficientSpaceStation beta = new BetaPowerEfficientSpaceStation(sp);
    }
    
  
    
}
