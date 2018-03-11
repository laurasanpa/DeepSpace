# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'Weapon'
  require_relative 'ShieldBooster'
  require_relative 'Hangar'
  require_relative 'Damage'
  require_relative 'SuppliesPackage'
 
  class SpaceStation
    @@MAXFUEL=100
    @@SHIELDLOSSPERUNITSHOT=0.1
    
    attr_reader:ammoPower
    attr_reader:fuelUnits
    attr_reader:name
    attr_reader:shieldPower
    attr_reader:weapons
    attr_reader:nMedals
    attr_reader:shieldBoosters
    attr_reader:hangar
    attr_accesor:pendingDamage
    
    def initialize(a,f,n,m,sp,w,sb,h,pd)
      @ammoPower=a
      @fuelUnits=f
      @name=n
      @nMedals=m
      @shieldPower=sp
      @weapons=w #array
      @shieldBoosters=sb #array
      @hangar=h
      @pendingDamage=pd
    end
    #Nombre inventado. Posiblemente haya que cambiarlo en algún momento.
    def self.newSuppliesPackage(n, supplies)
      new(supplies.ammoPower,supplies.fuelUnits ,n,supplies.shieldPower,nil, nil, -1,-1)
    end
    
    def cleanUpMountedItems
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
      SpaceStationToUI.new(self)
    end
    
    def fire
      throw new UnsupportedOperationException
    end
    
    def speed
      throw new UnsupportedOperationException
    end
    
    def move
      throw new UnsupportedOperationException
    end
    
    def protection
      throw new UnsupportedOperationException
    end
    
    def receiveHangar(h)
      throw new UnsupportedOperationException
    end
    
    def receiveShieldBooster(s)
      throw new UnsupportedOperationException
    end
    
    def receiveShot(shot)
      throw new UnsupportedOperationException
    end
    
    def receiveSupplies(s)
      throw new UnsupportedOperationException
    end
    
    def receiveWeapon(w)
      throw new UnsupportedOperationException
    end
    
    def loot(loot)
      throw new UnsupportedOperationException
    end
    
    def validState
      throw new UnsupportedOperationException
    end
    
    def to_s
      "Name:#{@name}"
      "AmmoPower:#{@ammoPower}"
      "FuelUnits:#{@fuelUnits}"
      "ShieldPower:#{@shieldPower}"
      "Weapons:#{@weapons}"
      "Medals:#{@nMedals}"
      "ShieldBoosters:#{@shieldBoosters}"
      "Hangar:#{@hangar}"
      "PendingDamage:#{@pendingDamage}"
    end
    
    private
    
    def assignFuelValue(f)
      throw new UnsupportedOperationException
    end

    def cleanPendingDamage
      throw new UnsupportedOperationException
    end
    
  end
end