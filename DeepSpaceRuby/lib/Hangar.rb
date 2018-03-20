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
    
    #prep: Numero de elementos menor que n.
   def initialize(n)
    @maxElements=n
    @shieldBoosters = Array.new #array
    @weapons = Array.new #array
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
       @weapons.push(w)
       return true
     else 
       puts "No hay espacio."
       return false
     end
   end
   
   #param ShieldBooster
   # @return bool
   def addShieldBooster(s)
      if spaceAvailable 
       @shieldBooster.push(w)
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
      "Elementos max.: " + @maxElements.to_s +  " ShieldBoosters: " + @shieldBooster.to_s + "Weapons: " +@weapons.to_s
   end
   
   private
   
   def spaceAvailable
      @weapons.size+@shieldBoosters.size < @maxElements
   end
   
   
   
end

end