# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'Loot'
  require_relative 'Damage'
  require_relative 'EnemyToUI'
  
  class EnemyStarShip
    attr_reader:ammoPower
    attr_reader:name
    attr_reader:shieldPower
    attr_reader:loot
    attr_reader:damage
    
    def initialize(n,a,s,l,d)
       @ammoPower=a
       @name=n
       @shieldPower=s
       @loot=l
       @damage=d
    end
    
    def self.newCopy(e)
      new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
    end
    
    def getUIversion
      EnemyToUI.new(self)
    end
    
    def protection
      @shieldPower
    end
    
    def fire
      @ammoPower
    end
    
    def receiveShot(shot)
      if shot >= @shieldPower
        return ShotResult::DONOTRESIST
      else
        return ShotResult::RESIST
      end
    end
    
    def to_s
      "Name:#{@name} \n AmmoPower:#{@ammoPower} \n ShieldPower:#{@shieldPower} \n Loot:#{@loot} \n Damage:#{@damage}"
    end
   
  end
end