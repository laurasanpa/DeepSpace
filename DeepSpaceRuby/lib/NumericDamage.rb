# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative 'NumericDamageToUI'
class NumericDamage < Damage
  
  attr_reader:nWeapons
public
  def initialize (nweapons, nshields)
    super(nshields)
    @nWeapons = nweapons
  end
  
  def adjust(w,s)
    NumericDamage.new([@nWeapons, w.size].min,[@nShields, s.size].min)
  end
  
  def copy()
    NumericDamage.new(@nweapons,@nshields)
  end
  
  def discardWeapon(w)
    if @nWeapons>0
      @nWeapons = @nWeapons-1  
    end
  end
  
  def getUIversion
      NumericDamageToUI.new(self)
    end
    
  def hasNoEffect
      return (@nWeapons==0 && @nShields==0)
  end
  
  

  
  
end
end
