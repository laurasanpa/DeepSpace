# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'DamageToUI'
  require_relative 'WeaponType'
  
  class Damage
    
    attr_reader:nWeapons
    attr_reader:nShields
    attr_reader:weapons
    
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
      new(d.nWeapons, d.nShields, d.weapons)
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
    
    def to_s
      "NWeapons:#{@nWeapons}"
      "NShields:#{@nShields}"
      "Weapons:#{@weapons}"
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