# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  
  require_relative 'EnemyStarShip'
  require_relative 'GameStateController'
  require_relative 'Dice'
  require_relative 'SpaceStation'
  require_relative 'GameState'
  require_relative 'CombatResult'
  require_relative 'GameUniverseToUI'
  require_relative 'Hangar'
  require_relative 'SpaceCity'
  require_relative 'BetaPowerEfficientSpaceStation'
  require_relative 'PowerEfficientSpaceStation'
  
  class GameUniverse
    
    @@WIN=10
    
    attr_reader:haveSpaceCity
    
    def initialize()
        @currentEnemy=nil
        @currentStation=nil
        @gameState=GameStateController.new
        @dice=Dice.new
        @spaceStations=Array.new
        @currentStationIndex=0
        @turns=0
        @haveSpaceCity=false
    end
    
    def state
      @gameState.state
    end
    
    def combat
      
      puts("llego a combat")
      state = @gameState.state
      puts(state)
      if ((state == GameState::BEFORECOMBAT)||(state==GameState::INIT))
        return combatGO(@currentStation,@currentEnemy)
      else 
        CombatResult::NOCOMBAT
      end
    end
    
    def combatGO(station,enemy)
      ch=@dice.firstShot
      
      if ch==GameCharacter::ENEMYSTARSHIP
        fire=enemy.fire
        result=station.receiveShot(fire)
        if result==ShotResult::RESIST
          fire=station.fire
          result=enemy.receiveShot(fire)
          enemywins=(result==ShotResult::RESIST)
        else
          enemywins=true
        end
      else
        fire=station.fire
        result=enemy.receiveShot(fire)
        enemywins=(result==ShotResult::RESIST)
      end
      
      if enemywins 
        s=station.getSpeed
        moves=@dice.spaceStationMoves(s)
        if !moves
          damage=enemy.damage
          station.setPendingDamage(damage)
          combatResult=CombatResult::ENEMYWINS
        else
          station.move
          combatResult=CombatResult::STATIONESCAPES
        end
      else
        aLoot=enemy.loot
        a = station.setLoot(aLoot)
        if a == Transformation::NOTRANSFORM
        combatResult=CombatResult::STATIONWINS
        elsif a == Transformation::GETEFFICIENT
        combatResult=CombatResult::STATIONWINSANDCONVERTS
        makeStationEfficient
        else
          combatResult=CombatResult::STATIONWINSANDCONVERTS
          createSpaceCity
      end
      end
      @gameState.next(@turns, @spaceStations.size)
      return combatResult
    
    end
    
    def createSpaceCity
      if @haveSpaceCity==false
        @currentStation = SpaceCity.new(@currentStation, @spaceStations)
        @haveSpaceCity=true
      end
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
    
    def makeStationEfficient 
      change = @dice.extraEfficiency
      if change
        @currentStation = BetaPowerEfficientSpaceStation.new(@currentStation)
      else
        @currentStation = PowerEfficientSpaceStation.new(@currentStation)
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
      if state == GameState::CANNOTPLAY
        @spaceStations = Array.new
        dealer = CardDealer.instance
        
        for i in (1..names.length)
          supplies=dealer.nextSuppliesPackage
          station=SpaceStation.new(names[i-1],supplies.ammoPower, supplies.fuelUnits, supplies.shieldPower)
          nh=@dice.initWithNHangars
          nw=@dice.initWithNWeapons
          ns=@dice.initWithNShields
          l=Loot.new(0,nw,ns,nh,0)
          station.setLoot(l)
          @spaceStations.push(station)
        end
        
        @currentStationIndex = @dice.whoStarts(names.length)
        @currentStation=@spaceStations[@currentStationIndex]
        @currentEnemy=dealer.nextEnemy
        @gameState.next(@turns, @spaceStations.size)
      end
    end
    
    def nextTurn
      state=@gameState.state
      puts ("\nNext turn " )
      puts state
      if state==GameState::AFTERCOMBAT
        stationState =@currentStation.validState
        
        if stationState
          puts "\nEstado Vlido"
          @currentStationIndex=(@currentStationIndex+1)%(@spaceStations.size)
          @turns=@turns+1
          
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