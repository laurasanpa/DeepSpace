# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'Loot'
  require_relative 'Damage'
  
  class EnemyStarShip
    
    def initialize(n,a,s,l,d)
       @ammoPower=a
       @name=n
       @shieldPower=s
       @loot=l
       @damage=d
    end
    
    def self.newCopy(e)
      new(e.getName, e.getAmmoPower, e.getShieldPower, e.getLoot, e.getDamage)
    end
    
    def getUIversion
      EnemyStarShipToUI.new(self)
    end
    
    def getName
      @name
    end
    
    def getAmmoPower
      @ammoPower
    end
    
    def getShieldPower
      @shieldPower
    end
    
    def getLoot
      @loot
    end
    
    def getDamage
      @damage
    end
    
    def protection
      throw new UnsupportedOperationException
    end
    
    def receiveShot(shot)
      throw new UnsupportedOperationException
    end
  end
end