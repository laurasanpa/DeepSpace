# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  class Loot
    def initialize(supplies, weapons, shields, hangars, medals)
      @nSupplies =  supplies
      @nWeapons = weapons
      @nShields = shields
      @nHangars = hangars
      @nMedals = medals
    end

    attr_reader:nSupplies

    attr_reader:nWeapons

    attr_reader:nShields

    attr_reader:nHangars

    attr_reader:nMedals

  end
end