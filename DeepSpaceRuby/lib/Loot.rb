# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  require_relative 'LootToUI'
  
  class Loot
    attr_reader:nSupplies

    attr_reader:nWeapons

    attr_reader:nShields

    attr_reader:nHangars

    attr_reader:nMedals
    
    attr_reader:efficient
    
    attr_reader:spaceCity
    
    def initialize(supplies, weapons, shields, hangars, medals, f=false,f2=false)
      @nSupplies =  supplies
      @nWeapons = weapons
      @nShields = shields
      @nHangars = hangars
      @nMedals = medals
      @efficient=f
      @spaceCity=f2
    end

    def to_s
      "nSupplies:#{@nSupplies}"
      "nWeapons:#{@nWeapons}"
      "nShields:#{@nshields}"
      "nHangars:#{@nHangars}"
      "nMedals:#{@nMedals}"
    end
    
    def getUIversion()
      h = LootToUI.new(self)
    end
  end
end