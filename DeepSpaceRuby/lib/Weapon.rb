# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  require_relative 'weapon_type'
  require_relative 'WeaponToUI'
  class Weapon implements Copyable<Weapon>
    attr_reader:name

    attr_reader:type
    
    attr_reader:uses
    
    def initialize(n,t,u)
      @name = n;
      @type = t;
      @uses = u;    
    end

    def self.newCopy(s)
      new(s.name, s.type, s.uses)
    end
    
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
    
    def to_s
      "Name:#{@name}"
      "Type:#{@type}"
      "Uses:#{@uses}"
    end
    
    def getUIversion
      h = WeaponToUI.new(self)
    end
  
  end
end