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
    
    def self.new
    
    def 
  end
end