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
       @shieldBoosters.push(s)
       return true
     else 
       return false
     end
   end
   
   def removeShieldBooster(n)
     if @shieldBooster != nil && n<@shieldBooster.size
     @shielBooster.delete_at(n)
     end
   end
   
   def removeWeapon(n)
     if @weapons !=nil && n<@weapons.size
     @weapons.delete_at(n)
     end
   end
   
   def to_s
      "\n Elementos max: #{@maxElements}\n ShieldBoosters: #{@shieldBooster}\n Weapons: #{@weapons}"
   end
   
   private
   
   def spaceAvailable
      @weapons.size+@shieldBoosters.size < @maxElements
   end
   
   
   end  
end