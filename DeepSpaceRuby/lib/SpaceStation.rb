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
    attr_reader:shieldBoosters
    attr_reader:hangar
    attr_reader:pendingDamage
    
    def initialize(n,supplies)
      @ammoPower=supplies.ammoPower
      @fuelUnits=supplies.fuelUnits
      @name=n
      @nMedals=0
      @shieldPower=supplies.shieldPower
      @weapons=Array.new
      @shieldBoosters=Array.new
      @hangar=nil
      @pendingDamage=-1
    end
    
    def NMedals
      @nMedals
    end
    
    def cleanUpMountedItems
      i=0
      auxweapons = Array.new
      auxshieldboosters = Array.new
      
      if @weapons !=nil
        while i< @weapons.size
          if @weapons[i].uses != 0
            auxweapons.push(@weapons[i])
          end
        end
      end
      @weapons=auxweapons
      
      j=0
      
      if @shieldBoosters != nil
        while j< @shieldBoosters.size
          if @shieldBoosters[i].uses != 0
            auxshieldboosters.size(@shieldBoosters[i])
          end
        end
      end
      @shieldBoosters=auxshieldboosters
      
    end
    
    def discardHangar
      @hangar=nil
    end
    
    def mountShieldBooster(i)
       unless @hangar==nil
        h=@hangar.removeShieldBooster(i)
        unless h == nil
          @shieldBoosters.push(h)
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
          @weapons.push(h)
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
      a=@fuelUnits
      if (a+=s.fuelUnits) > @@MAXFUEL
        @fuelUnits=@@MAXFUEL
      end
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
      @pendingDamage=d.adjust(@weapons,@shieldBoosters)
    end
    
    def to_s
      "Name: #{@name} \n AmmoPower: #{@ammoPower}\n FuelUnits: #{@fuelUnits}\n ShieldPower: #{@shieldPower}\n Weapons: #{@weapons}\n Medals: #{@nMedals}\n ShieldBoosters: #{@shieldBoosters}\n Hangar: #{@hangar} \nPendingDamage: #{@pendingDamage}"
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
    
  end
end