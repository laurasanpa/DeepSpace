# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class SuppliesPackage
  def initialize(power, fuel, shield)
    @ammoPower = power
    @fuelUnits = fuel
    @shieldPower = shield
    
  end
  
  def newCopy(s)
    copy=new SuppliesPackage(s.ammoPower, s.fuelUnits, s.shieldPower)
    return copy
  end
  
  attr_reader:ammoPower
  
  attr_reader:fuelUnits
  
  attr_reader:shieldPower
end