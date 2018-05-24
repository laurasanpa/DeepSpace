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
    super(ss.name,ss.ammoPower, ss.fuelUnits, ss.shieldPower, ss.weapons, ss.shieldBoosters,ss.hangar,ss.nMedals, ss.pendingDamage)
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
