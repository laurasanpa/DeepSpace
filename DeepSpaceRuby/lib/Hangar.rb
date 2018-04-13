# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'HangarToUI'
  require_relative 'ShieldBooster'
  require_relative 'Weapon'
  
  class Hangar
    
    attr_reader :maxElements
    attr_reader :shieldBoosters
    attr_reader :weapons
   
    
   def initialize(n)
    @maxElements=n
    @shieldBoosters = Array.new #array
    @weapons = Array.new #array
   end
     
   
      
   def self.newCopy(h)
    nuevo =  new(h.maxElements)
     for i in (0...h.shieldBoosters.size)
     nuevo.addShieldBooster(h.shieldBoosters[i])
     end
     for j in (0...h.weapons.size)
     nuevo.addWeapon(h.weapons[i])
     end
     return nuevo
   end
   
   def getUIversion
     HangarToUI.new(self)
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
     if @shieldBoosters != nil && n<@shieldBoosters.size
     @shieldBoosters.delete_at(n)
     end
   end
   
   def removeWeapon(n)
     if @weapons !=nil && n<@weapons.size
     @weapons.delete_at(n)
     end
   end
   
   def to_s
      "\n Elementos max: #{@maxElements}\t"
   end
   
   private
   
   def spaceAvailable
      @weapons.size+@shieldBoosters.size < @maxElements
   end
   
   
   end  
end