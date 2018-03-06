# encoding: utf-8

module Deepspace
 require_relative 'loot'
 require_relative 'supplies_package'
 require_relative 'shield_booster'
 require_relative 'shot_result'
 require_relative 'weapon_type'
 require_relative 'weapon'
 require_relative 'game_character'
 require_relative 'dice'
 require_relative 'combat_result'
  class TestP1

    def main()
    
      puts 'Esto es una prueba'
    
      #botín.
      lote = Loot.new(1,2,3,4,5)
      
      puts "El botín tiene las siguientes medallas  #{lote.nMedals}"
      
      
      #Paquetes de suministros
      paq= SuppliesPackage.new(2,1,1)
      puts "El paquete de suministros tiene la siguiente cantidad de suministro #{paq.fuelUnits}"
      puts "El paquete de suministros tiene la siguiente recarga de escudos: #{paq.shieldPower}"
      
      # shield booster
      nombre = "pepe"
      
      recarga = ShieldBooster.new(nombre,2,2)
      
      puts "Usos del potenciador de escudos: #{recarga.uses}" 
      puts "useIt: #{recarga.useIt}"
     
      #weapon
      #No estoy seguro de como asignar laser y como consultar el tipo de arma.
      nombre1 = "lolita"
      arma1 =Weapon.new(nombre1,WeaponType::LASER,2)
      
      puts "Tipo de arma: #{arma1.type}"
      #Mandar correo.
    end
  

end

      c=TestP1.new
    c.main
    
end