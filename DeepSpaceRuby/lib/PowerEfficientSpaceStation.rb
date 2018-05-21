# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
require_relative 'Transformation'

  class PowerEfficientSpaceStation < SpaceStation
    @@EFFICIENCYFACTOR=1.10  
    
    def initialize(station)
      super(station)
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
