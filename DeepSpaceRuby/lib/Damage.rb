# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'DamageToUI'
  require_relative 'WeaponType'
  
  class Damage
    
    def initialize(w,s,wl)
      @nWeapons=w
      @nShields=s
      @weapons=wl #array
    end
    
    def self.newNumericWeapons(w,s)
      new(w,s,nil)
    end
    
    def self.newSpecificWeapons(wl,s)
     new(-1,s,wl)
    end
    
    def self.newCopy(d)
      new(d.getNWeapons, d.getNShields, d.getWeapons)
    end
    
    def getUIversion
      HangarToUI.new(self)
    end
    
    def discardWeapon(w)
     throw new UnsupportedOperationException
    end
    
    def discardShieldBooster
      throw new UnsupportedOperationException
    end
    
    def hasNoEffect
      throw new UnsupportedOperationException
    end
    
    def getNShields
      @nShields
    end
    
    def getNWeapons
      @nWeapons
    end
    
    def getWeapons
      @weapons
    end
    
    private
    
    def adjust(w,s)
      throw new UnsupportedOperationException
    end
    
    def arrayContainsType(w,t)
      throw new UnsupportedOperationException
    end
    
  end
end