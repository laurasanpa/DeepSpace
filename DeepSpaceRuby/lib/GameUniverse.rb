# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  
  require_relative 'EnemyStarShip'
  require_relative 'GameStateController'
  requite_relative 'Dice'
  require_relative 'SpaceStation'
  
  class GameUniverse
    
    attr_reader:gameState
    
    def initialize(e,s,g,d,st)
        @currentEnemy=e
        @currentStation=s
        @gameState=g
        @dice =d
        @spaceStations=st #array
    end
    
    def self.newNil
      new(-1,-1,-1,-1,nil)
    end
    
    def combat
      throw new UnsupportedOperationException
    end
    
    def discardHangar
      throw new UnsupportedOperationException
    end
    
    def mountShieldBooster(i)
      throw new UnsupportedOperationException
    end
    
    def discardShieldBooster(i)
      throw new UnsupportedOperationException
    end
    
    def discardShieldBoosterInHangar(i)
      throw new UnsupportedOperationException
    end
    
    def mountWeapon(i)
      throw new UnsupportedOperationException
    end
    
    def discardWeapon(i)
      throw new UnsupportedOperationException
    end
    
    def discardWeaponInHangar(i)
      throw new UnsupportedOperationException
    end
    
    def getUIversion
      GameUniverseToUI.new(self)
    end
    
    def haveAWinner
      throw new UnsupportedOperationException
    end
    
    def init(names)
      throw new UnsupportedOperationException
    end
    
    def nextTurn
      throw new UnsupportedOperationException
    end
  end
end