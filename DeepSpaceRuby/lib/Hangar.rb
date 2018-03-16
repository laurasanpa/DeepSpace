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
     if spaceAvailable 
       @weapons.add(w)
       return true
     else 
       return false
     end
   end
   
   #param ShieldBooster
   # @return bool
   def addShieldBooster(s)
      if spaceAvailable 
       @shieldBooster.add(w)
       return true
     else 
       return false
     end
   end
   
   def removeShieldBooster(n)
     @shielBooster.delete_at(n)
   end
   
   def removeWeapon(n)
     @weapons.delete_at(n)
   end
   
   def to_s
      "Elementos max.:#{@maxElements}"
      "ShieldBoosters:#{@shieldBoosters}"
      "Weapons:#{@weapons}"
   end
   
   private
   
   def spaceAvailable
      @weapons.length+@shieldBoosters.length <= @maxElements
   end
   
   private_class_method :new
   
end

end