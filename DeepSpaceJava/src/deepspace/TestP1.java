/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import static deepspace.WeaponType.LASER;

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
        
        //Botín
        Loot Lote = new Loot(1,2,3,4,5);
        
        System.out.print("El botín tiene las siguientes medallas:" + Lote.getNMedals());
        System.out.print("El botín tiene las siguientes armas:" + Lote.getNWeapons());
        System.out.print("El botín tiene los siguientes escudos:" + Lote.getNShields());
        
        //Paquete de suministros
        
        SuppliesPackage paq = new SuppliesPackage(2,8,5);
        SuppliesPackage paq2=new SuppliesPackage(paq);
        
        System.out.print("El paquete de suministros tiene la siguiente cantidad de combustible:" + paq2.getFuelUnits());
        System.out.print("El paquete de suministros tiene la siguiente recarga de escudos:" + paq2.getShieldPower());
    
        
        //ShieldBooster
        String nombre = "Pepe";
        ShieldBooster recarga = new ShieldBooster(nombre,2,2);
        ShieldBooster recarga2 = new ShieldBooster(recarga);
        
        System.out.print("Usos del potenciador de escudos:" + recarga2.getUses());
        System.out.print("useIt:" + recarga2.useIt());
        
        //Weapon
        String nombre1="lolita";
        WeaponType lolita=WeaponType.LASER;
        Weapon arma1 = new Weapon(nombre1,lolita,3);
        Weapon hermana = new Weapon(arma1);
        
        System.out.print("Tipo de arma:" + hermana.getType());
        System.out.print("Potencia de arma" + hermana.power());
        
        //Dice
        Dice dado= new Dice();
        
        System.out.print("Número de hangares al inicio de la partida:" + dado.initWithNHangars());
        System.out.print("Número de escudos al inicio de la partida:" + dado.initWithShields());
        System.out.print("Número de armas al inicio de la partida:" + dado.init());
    }
    
}
