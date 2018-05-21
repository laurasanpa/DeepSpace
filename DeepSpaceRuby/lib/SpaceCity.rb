# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Deepspace
  require_relative'Loot'
  require_relative'Transformation'
  
class SpaceCity < SpaceStation
  attr_reader :collaborators
  
  #ss es tipo SpaceStation, rest array de spaceStation
  def initialize(ss,rest)
    super(ss)
    @collaborators=rest
    @base=ss
  end
  
  def fire
    fire=0.0
    fire+=super
    for i in(0...@collaborators.size)
      fire+=@collaborators[i].fire
    end
  end
  
  def protection
    pr=0.0
    pr+=super
    for i in(0...@collaborators.size)
      pr+=@collaborators[i].protection
    end
  end
  
  def setLoot(loot)
    super(loot)
    Transformation::NOTRANSFORM
  end
  
  
  
end
end