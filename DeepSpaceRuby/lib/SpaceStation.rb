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
    attr_reader:weapons #array
    attr_reader:nMedals
    attr_reader:shieldBoosters
    attr_reader:hangar
    attr_reader:pendingDamage
    
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
      @hangar=nil
    end
    
    def mountShieldBooster(i)
       unless @hangar==nil
        h=@hangar.removeShieldBooster(i)
        unless h == nil
          weapons.add(h)
        end
      end
    end
    
    def discardShieldBooster(i)
      throw new UnsupportedOperationException
    end
    
    def discardShieldBoosterInHangar(i)
      unless @hangar==nil
        @hangar.removeShieldBooster(i)
      end
    end
    
    def mountWeapon(i)
      unless @hangar==nil
        h=@hangar.removeWeapon(i)
        unless h == nil
          weapons.add(h)
        end
      end
    end
    
    def discardWeapon(i)
      throw new UnsupportedOperationException
    end
    
    def discardWeaponInHangar(i)
      unless @hangar==nil
        @hangar.removeWeapon(i)
      end
    end
    
    def getUIversion
      SpaceStationToUI.new(self)
    end
    
    def fire
      throw new UnsupportedOperationException
    end
    
    def getSpeed
      @fuelUnits/@@MAXFUEL
    end
    
    def move
      @fuelUnits-getSpeed
    end
    
    def protection
      throw new UnsupportedOperationException
    end
    
    def receiveHangar(h)
      if @hangar==nil
        @hangar=h
      end
    end
    
    def receiveShieldBooster(s)
       unless @hangar==nil
        return @hangar.addShieldBooster(s)
       else 
        return false
       end
    end
    
    def receiveShot(shot)
      throw new UnsupportedOperationException
    end
    
    def receiveSupplies(s)
      @ammoPower+=s.ammoPower
      @fuelUnits+=s.fuelUnits
      @shieldPower+=s.shieldPower
    end
    
    def receiveWeapon(w)
      unless @hangar==nil
        return @hangar.addWeapon(w)
      else 
        return false
      end
    end
    
    def loot(loot)
      throw new UnsupportedOperationException
    end
    
    def validState
      @pendingDamage==nil 
    end
    
    def setpendingDamage(d)
      @pendingDamage=d
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
      if f<=@@MAXFUEL
        @fuelUnits = f
      end
    end

    def cleanPendingDamage
      #Comprobar que no tenga efecto
      @pendingDamage=nil
    end
    
    private_class_method :new
    
  end
end