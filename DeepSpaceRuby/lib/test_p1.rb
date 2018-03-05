# encoding: utf-8

require 'loot'
require_relative "supplies_package"
class TestP1

    def main()
    
      puts 'Esto es una prueba'
    
      #botín.
      lote= Loot.new(1,2,3,4,5)
      puts "El botín tiene las siguientes medallas  #{lote.nMedals}"
      
      
      #Paquetes de suministros
      paq= SuppliesPackage.new(2,1,1)
      puts "El paquete de suministros tiene la siguiente cantidad de suministro #{paq.fuelUnits}"
      puts "El paquete de suministros tiene la siguiente recarga de escudos: #{paq.shieldpower}"
      
      # shield booster
      nombre = "pepe"
      
      recarga = ShieldBooster.new(nombre,2,2)
      
      puts "Usos del potenciador de escudos: #{recarga.uses}" 
      puts "useIt: #{recarga.useIt}"
     
      #weapon
      #No estoy seguro de como asignar laser y como consultar el tipo de arma.
      nombre1 = "lolita"
      arma1 = WeaponType::LASER
      puts "Tipo de arma: #{}"
    end
  

end

      c=TestP1.new
    c.main