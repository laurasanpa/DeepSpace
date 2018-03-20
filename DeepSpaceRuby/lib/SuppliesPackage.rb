# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  class SuppliesPackage
    
    attr_reader:ammoPower

    attr_reader:fuelUnits

    attr_reader:shieldPower
    
    
    def initialize(power, fuel, shield)
      @ammoPower = power
      @fuelUnits = fuel
      @shieldPower = shield

    end

    def self.newCopy(s)
      new(s.ammoPower, s.fuelUnits, s.shieldPower)
    end
    
    def to_s
   
       "AmmoPower:  #{@ammoPower}\nFuelUnits:#{@fuelUnits} \nShieldPower: #{@shieldPower}"
    end
    
  end
  
end
