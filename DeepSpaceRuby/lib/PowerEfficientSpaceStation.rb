# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
require_relative 'Transformation'
require_relative 'PowerEfficientSpaceStationToUI'
require_relative 'SpaceStation'

  class PowerEfficientSpaceStation < SpaceStation
    @@EFFICIENCYFACTOR=1.10  
    
    def initialize(ss)
    sup=SuppliesPackage.new(ss.ammoPower,ss.fuelUnits, ss.shieldPower)
    super(ss.name,sup)
    setPendingDamage(ss.pendingDamage)
    receiveHangar(ss.hangar)
    for i in (0...ss.weapons.size)
      @weapons.push(ss.weapons[i])
    end
    for j in (0...ss.shieldBoosters.size)
      @shieldBoosters.push(ss.shieldBoosters[i])
    end
    end
    
    def getUIversion
      PowerEfficientSpaceStationToUI.new(self)
    end
    
    def fire
      super*@@EFFICIENCYFACTOR
    end
    
    def protection
      super*@@EFFICIENCYFACTOR
    end
    
    def setLoot(loot)
    super(loot)
    Transformation::NOTRANSFORM
  end
  
  end
end
