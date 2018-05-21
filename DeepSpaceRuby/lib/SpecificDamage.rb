# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'SpecificDamageToUI'
  require_relative'WeaponType'
  class SpecificDamage < Damage
    
    attr_reader:weapons
    
    def initialize(weapons,nshields)
      super(nshields)
      @weapons = Array.new
      for i in (0...weapons.size)
        @weapons.push(weapons[i])
      end
      
    end
    
    def adjust(w,s)
      auxweapons=[]
      for i  in 0...@weapons.size
        auxweapons.push(@weapons[i])
      end
      h=Array.new
      #Sacamos el vector intersección
      for j in 0...w.size
        if arrayContainsType(auxweapons,w[j].type)!=-1
          h.push(auxweapons[arrayContainsType(auxweapons,w[j].type)])
          auxweapons.delete_at(arrayContainsType(auxweapons,w[j].type))
        end
      end
      SpecificDamage.new(h,[@nShields, s.size].min)
    end
    
    def copy()
    SpecificDamage.new(@weapons,@nshields)
  end
  
    def discardWeapon(w)
          @weapons.delete(w.type) 
    end
    
    def getUIversion
      SpecificDamageToUI.new(self)
    end
    
    def hasNoEffect
      return (@nShields==0 && @weapons.size==0)
    end
  
    private
    
    def arrayContainsType(w,t)
      if w.index(t)== nil
        return -1
      else 
        return w.index(t)
      end
    end
    
  end
end
