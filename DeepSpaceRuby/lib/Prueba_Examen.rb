# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
 

# Ejercicio 1: Crear una nueva clase, meterla en el modulo, y hacer un main.

require_relative 'Dice'
require_relative 'SpaceStation'
require_relative 'EnemyStarShip'
require_relative 'SuppliesPackage'
require_relative 'Loot'
require_relative 'GameUniverse'
module Modulito
  class Prueba_Examen
    #Quitamos el initialize porque no vamos a crear nuevas instancias.
    def self.main
      #Creamos un objeto de la clase Dice
      dice=Deepspace::Dice.new
      var1=0.0
      var2=0.0
      var3=0.0
      valor=0.0
      for i in 0...1000
        valor=dice.initWithNWeapons
        if valor==1
          var1+=1
        elsif valor==2
          var2+=1
        else 
          var3+=1
        end
      end
      
      #(0..1000).each{|contador|
      #  lo que hace 
      #}
      
      puts "N de asignaciones de 1 arma: #{var1/1000}"
      puts "N de asignaciones de 2 armas: #{var2/1000}"
      puts "N de asignaciones de 3 armas: #{var3/1000}"
      
     
      #crear un botin
      loot=Deepspace::Loot.new(2,2,2,1,1)
      sup=Deepspace::SuppliesPackage.new(2,2,2)
      #crear una estacion espacial y un enemigo
      station=Deepspace::SpaceStation.new("Laura", sup)
      damage=Deepspace::Damage.newNumericWeapons(1,0)
      enemy=Deepspace::EnemyStarShip.new("Sara",0,0,loot,damage)
      puts "#{station}"
      
      #pasar el botin a la estación
       station.setLoot(loot)
       
      puts "#{station}"
      #combatir
      
      universe=Deepspace::GameUniverse.new
      
      universe.combatGO(station, enemy)
      
      
     
     
      end
      
    end
     Prueba_Examen.main
  end
  


#Modulito::Prueba_Examen.main