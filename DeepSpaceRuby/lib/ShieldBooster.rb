# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module Deepspace
  
  require_relative 'ShieldToUI'
  class ShieldBooster 
    attr_reader:name

    attr_reader:boost

    attr_reader:uses
    def initialize(n,b,u)
      @name = n
      @boost = b
      @uses = u

    end

    def self.newCopy(s)
      new(s.name, s.boost, s.uses)
    end
    
    def getUIversion
     ShieldToUI.new(self)
    end
    def useIt
      if @uses > 0
        @uses=@uses-1
        return @boost
      else
        return 1.0
      end
    end
    
    def to_s
      return "Name:#{@name} Boost: #{@boost} Uses:#{@uses}"
    end
  end
end