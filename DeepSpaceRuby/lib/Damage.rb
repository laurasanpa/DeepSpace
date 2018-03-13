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
        if @nWeapons == -1
          @weapons.delete_all(w)
        else if @nWeapons>0
          @nWeapons = @nWeapons-1  
        end
       end
    end
    
    def discardShieldBooster
      if @nShields >0
        @nShields=@nShields-1
      end
    end
    
    def hasNoEffect
      if @nWeapons=-1
        return @nShields=0 && @Weapons==nill
      else
        return @nWeapons=0 && @nShields=0
      end
    end
    
    def to_s
      "NWeapons:#{@nWeapons}"
      "NShields:#{@nShields}"
      "Weapons:#{@weapons}"
    end
    
    private
    
    def adjust(w,s)
      w=w+s
      w=w&@weapons
      s=s&@weapons
      
      adjusteddamage = Damage.newSpecificWeapons(w,s.length)
    end
    
    def arrayContainsType(w,t)
      if w.find_index(t)== nill
        return -1
      else 
        return w.find_index(t)
      end
    end
        
   
  end
end