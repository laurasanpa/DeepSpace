# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'HangarToUI'
  require_relative 'ShieldBooster'
  require_relative 'Weapon'
  
  class Hangar
    
    attr_reader:maxElements
    attr_reader:shieldBoosters
    attr_reader:weapons
    
   def initialize(n,b,w)
    @maxElements=n
    @shieldBoosters = b #array
    @weapons = w #array
   end
      
   def self.newCopy(h)
     new(h.maxElements, h.shieldBoosters, h.weapons)
   end
   
   def getUIversion
     h = HangarToUI.new(self)
   end
   
   # @param weapon
   # @return bool
   def addWeapon(w)
     throw new UnsupportedOperationException
   end
   
   #param ShieldBooster
   # @return bool
   def addShieldBooster(s)
     throw new UnsupportedOperationException
   end
   
   def removeShieldBooster(n)
     throw new UnsupportedOperationException
   end
   
   def removeWeapon(n)
     throw new UnsupportedOperationException
   end
   
   def to_s
      "Elementos max.:#{@maxElements}"
      "ShieldBoosters:#{@shieldBoosters}"
      "Weapons:#{@weapons}"
   end
   
   private
   
   def spaceAvailable
     throw new UnsupportedOperationException
   end
   
end

end