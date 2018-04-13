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
    
    #Comprobar si weapons se puede asignar así
    def self.newCopy(d)
      new(d.nWeapons, d.nShields, d.weapons)
    end
    
    def getUIversion
      DamageToUI.new(self)
    end
    
 
    def discardWeapon(w)
        if @nWeapons == -1
          @weapons.delete(w.type)
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
      if @nWeapons==-1
        return (@nShields==0 && @weapons.length==0)
      else
        return (@nWeapons==0 && @nShields==0)
      end
    end
    
    def to_s
      "NWeapons:#{@nWeapons} \n NShields:#{@nShields} \n Weapons:#{@weapons}"
    end
    
    def adjust(w,s)
          #Si damage es específico
      if @weapons != nil
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
        #Creamos nuevo damage
        Damage.newSpecificWeapons(h,[@nShields, s.size].min)
      else 
        Damage.newNumericWeapons([@nWeapons, w.size].min,[@nShields, s.size].min)
      end
    end
    private
    
    def arrayContainsType(w,t)
      if w.index(t)== nil
        return -1
      else 
        return w.index(t)
      end
    end
    
    private_class_method :new
    
   
  end
end