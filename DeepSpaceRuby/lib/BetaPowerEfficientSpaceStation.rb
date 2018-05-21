# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  require_relative 'BetaPowerEfficientSpaceStationToUI'
  require_relative 'PowerEfficientSpaceStation'
  
  class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
    
    @@EXTRAEFFICIENCY=1.20
    
    def initialize(ss)
      super(ss)
    end
    
    def getUIversion
      BetaPowerEfficientSpaceStationToUI.new(self)
    end
    
    def fire
      super*@@EXTRAEFFICIENCY
    end
  end
end
