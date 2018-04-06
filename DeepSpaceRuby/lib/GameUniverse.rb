# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  
  require_relative 'EnemyStarShip'
  require_relative 'GameStateController'
  requite_relative 'Dice'
  require_relative 'SpaceStation'
  require_relative 'GameState'
  require_relative 'GameResult'
  
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
      state = @gameState.state
      
      if (state == GameState.BEFORECOMBAT)||(state==GameState.INIT)
        combatGO(@currentStation,@currentEnemy)
      else 
        CombatResult::NOCOMBAT
      end
    end
    
    def combatGO(station,enemy)
      ch=@dice.firstShot
      
      if ch==GameCharacter::ENEMYSTARSHIP
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
      state=@gameState.state
      if state == GameState.CANNOTPLAY
        spaceStations = Array.new
        dealer = CardDealer.instance
        
        for i in (0...names.size)
          supplies=dealer.nextSuppliesPackage
          station=SpaceStation.new(names[i],supplies)
          nh=@dice.initWithNHangars
          nw=@dice.initWithNWeapons
          ns=@dice.initWithNShields
          l=Loot.new(0,nh,nw,ns,0)
          station.loot(l)
        end
        
        currentStationIndex = @dice.whoStarts(names.size)
        currentStation=spaceStations[currentStationIndex]
        currentEnemy=dealer.nextEnemy
        @gameState.next(@turns, spaceStations.size)
      end
    end
    
    def nextTurn
      state=@gameState.state
      
      if state==GameState.AFTERCOMBAT
        stationState =@currentStation.validState
        
        if stationState
          @currentStationIndex=(@currentStationIndex+1) % @spaceStations.size
          @turns+=1
          
          @currentStation = @spaceStations[@currentStationIndex]
          @currentStation.cleanUpMountedItems
          dealer=CardDealer.instance
          @currentEnemy=dealer.nextEnemy
          @gameState.next(@turns,@spaceStations.size)
          return true
        end
        return false
      end
        return false
    end
    
    def to_s
      "CurrentEnemy:#{@currentEnemy} \n CurrentStations:#{@currentStation} \n GameState:#{@gameState} \n Dice:#{@dice} \n SpaceStations:#{@spaceStations}"
    end
  end
end