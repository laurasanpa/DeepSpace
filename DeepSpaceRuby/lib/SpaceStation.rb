# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'Weapon'
  require_relative 'ShieldBooster'
  require_relative 'Hangar'
  require_relative 'Damage'
  require_relative 'SuppliesPackage'
  require_relative 'ShotResult'
  require_relative 'CardDealer'
  require_relative 'SpaceStationToUI'
 
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
      @pendingDamage=nil
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
       if @hangar!=nil
        h=@hangar.removeShieldBooster(i)
        if h != nil
          @shieldBoosters.push(h)
        end
      end
    end
    
    def discardShieldBooster(i)
      size=@shieldBoosters.size
      if i>=0 && i<size
        s=@shieldBoosters.delete_at(i)
        if @pendingDamage != nil
          @pendingDamage.discardShieldBooster(s)
          cleanPendingDamage
        end
      end
    end
    
    def discardShieldBoosterInHangar(i)
      if @hangar!=nil
        @hangar.removeShieldBooster(i)
      end
    end
    
    def mountWeapon(i)
      if @hangar!=nil
        h=@hangar.removeWeapon(i)
        if h != nil
          @weapons.push(h)
        end
      end
    end
    
    def discardWeapon(i)
      size=@weapons.size
      if i>=0 && i<size
        w=@weapons.delete_at(i)
        if @pendingDamage != nil
          @pendingDamage.discardWeapon(w)
          cleanPendingDamage
        end
      end
    end
    
    def discardWeaponInHangar(i)
      if @hangar!=nil
        @hangar.removeWeapon(i)
      end
    end
    
    def getUIversion
      SpaceStationToUI.new(self)
    end
    
    def fire
      size = @weapons.size
      factor = 1.0
      
      for i in (0...size)
        w=@weapons[i]
        factor*=w.useIt
      end
      @ammoPower*factor
    end
    
    def getSpeed
      @fuelUnits/@@MAXFUEL
    end
    
    def move
      @fuelUnits-getSpeed
    end
    
    def protection
      size = @shieldBoosters.size
      factor = 1.0
      
      for i in (0...size)
        s=@shieldBoosters[i]
        factor*=s.useIt
      end
      @shieldPower*factor
    end
    
    def receiveHangar(h)
      if @hangar==nil
        @hangar=h
      end
    end
    
    def receiveShieldBooster(s)
      if @hangar!=nil
        return @hangar.addShieldBooster(s)
      else 
        return false
       end
    end
    
    def receiveShot(shot)
      myProtection=protection
      if myProtection >= shot 
        @shieldPower-=@@SHIELDLOSSPERUNITSHOT*shot
        @shieldPower=Max(0.0,@shieldPower)
        return shotResult::RESIST
      else
        @shieldPower=0.0
        return shotResult::DONOTRESIST
      end
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
      if @hangar!=nil
        return @hangar.addWeapon(w)
      else 
        return false
      end
    end
    
    def loot(loot)
      dealer = CardDealer.instance
      h=loot.nHangars
      if h>0
        hangar=dealer.nextHangar
        receiveHangar(hangar)        
      end
      
      elements=loot.nSupplies
      
      for i in (0...elements)
        sup=dealer.nextSuppliesPackage
        receiveSupplies(sup)
      end
      
      elements=loot.nWeapons
      
      for j in (0...elements)
        weap=dealer.nextWeapon
        receiveWeapon(weap)
      end      
      
      elements=loot.nShields
      
       for i in (0...elements)
        sh=dealer.nextShieldBooster
        receiveShieldBooster(sh)
      end    
      
      medals=loot.nMedals
      @nMedals+=medals
    end
    
    def validState
      @pendingDamage==nil 
    end
    
    def setPendingDamage(d)
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