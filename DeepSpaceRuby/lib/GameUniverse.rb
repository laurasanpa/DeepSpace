# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  
  require_relative 'EnemyStarShip'
  require_relative 'GameStateController'
  requite_relative 'Dice'
  require_relative 'SpaceStation'
  
  class GameUniverse
    
    @@WIN=10
    
    attr_reader:gameState
    
    def initialize()
        @currentEnemy=nil
        @currentStation=nil
        @gameState=GameStateController.new
        @dice=Dice.new
        @spaceStations=Array.new
        @currentStationIndex=0
        @turns=0
        
    end
    
    def combat
      throw new UnsupportedOperationException
    end
    
    def combatGO(station,enemy)
      throw new UnsupportedOperationException
    end
    
    def discardHangar
        if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.discardHangar
      end
    end
    
    def mountShieldBooster(i)
        if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.mountShieldBooster(i)
      end
    end
    
    def discardShieldBooster(i)
       if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.discardShieldBooster(i)
      end
    end
    
    def discardShieldBoosterInHangar(i)
        if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.discardShieldBoosterInHangar(i)
      end
    end
    
    def mountWeapon(i)
        if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.mountWeapon(i)
      end
    end
    
    def discardWeapon(i)
        if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.discardWeapon(i)
      end
    end
    
    def discardWeaponInHangar(i)
      if @gameState.state==GameState::INIT || @gameState.state==GameState::AFTERCOMBAT
        @currentStation.discardWeaponInHangar(i)
      end
    end
    
    def getUIversion
      GameUniverseToUI.new(@currentStation, @currentEnemy)
    end
    
    def haveAWinner
       @currentStation.NMedals==10
    end
    
    def init(names)
      throw new UnsupportedOperationException
    end
    
    def nextTurn
      throw new UnsupportedOperationException
    end
    
    def to_s
      "CurrentEnemy:#{@currentEnemy} \n CurrentStations:#{@currentStation} \n GameState:#{@gameState} \n Dice:#{@dice} \n SpaceStations:#{@spaceStations}"
    end
  end
end