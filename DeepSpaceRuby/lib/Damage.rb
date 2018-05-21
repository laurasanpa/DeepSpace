# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'DamageToUI'
 
  
  class Damage
    
    attr_reader:nShields
    
    
    
    
   
    def copy()
      "No implementado"
    end
    
    def getUIversion
      "Abstracto"
    end
    
 
    def discardWeapon(w)
      "Abstracto"
    end
    
    def discardShieldBooster
      if @nShields >0
        @nShields=@nShields-1
      end
    end
    
    def hasNoEffect
      "Abstracto"
    end
    
    def to_s
      "NWeapons:#{@nWeapons} \n NShields:#{@nShields} \n Weapons:#{@weapons}"
    end
    
    def adjust(w,s)
       "Abstracto"
    end

    protected
    def initialize(s)
      @nShields=s
    end
   
  end
end
