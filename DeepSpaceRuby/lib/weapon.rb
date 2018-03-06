# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  require_relative 'weapon_type'
  class Weapon
    def initialize(n,t,u)
      @name = n;
      @type = t;
      @uses = u;    
    end

    def self.newCopy(s)
      copy=Weapon.new(s.name, s.type, s.uses)
      return copy
    end

    attr_reader:name

    attr_reader:type

    def power
      @type.power
    end

    def useIt
      if @uses > 0
        @uses=@uses-1
        return power
      else
        return 1.0
      end
    end
  
  end
end