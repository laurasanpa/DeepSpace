# encoding: utf-8

module Deepspace
 require_relative 'Loot'
 require_relative 'SuppliesPackage'
 require_relative 'ShieldBooster'
 require_relative 'ShotResult'
 require_relative 'WeaponType'
 require_relative 'Weapon'
 require_relative 'GameCharacter'
 require_relative 'Dice'
 require_relative 'CombatResult'
 require_relative "Hangar"
 require_relative "SpaceStation"
 require_relative "EnemyStarShip"
 require_relative "Damage"
 require "pp"
  class TestP1

    def main()
    
     w1 =Weapon.new("lolito",WeaponType::LASER,2)
     w2 =Weapon.new("Laurita", WeaponType::MISSILE,0)
     w3 =Weapon.new("Samuelillo", WeaponType::PLASMA,1)
     
     w4 =Weapon.newCopy(w2)
     
      puts "Mostrando armas: "
      pp(w1,w2,w3,w4)
     
      sb1 = ShieldBooster.new("EScudoLaurin", 2, 6)
      sb2 = ShieldBooster.new("EscudoSamuelin", 1, 1)
      pp(sb1)
      
      aw=Array.new
      aw.push(w1)
      aw.push(w2)
      aw.push(w3)
      aw.push(w4)
      
      arrayshield=Array.new
      arrayshield.push(sb1)
      arrayshield.push(sb2)
      
      pp(arrayshield[0])
      
      h1 = Hangar.new(1)
      h1.addWeapon(w2)
      h1.addWeapon(w4)
      h1.addWeapon(w1)
      pp(h1)
      
      puts("Hemos borrado el arma en la posición 1")
      h1.removeWeapon(0)
      h1.removeShieldBooster(0)
      pp(h1)
      
      supplies = SuppliesPackage.new(10, 50, 9)
      
      pp(supplies)
      
      station1=SpaceStation.new("Halcon Milenario",supplies)
      
      pp(station1)
      
      
      
      
      
      
      
      
    end
  

end

      c=TestP1.new
    c.main
    
end