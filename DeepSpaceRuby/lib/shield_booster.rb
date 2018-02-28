# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class ShieldBooster
  def initialize(n,b,u)
    @name = n
    @boost = b
    @uses = u
    
  end
  
  def newCopy(s)
    copy = new ShieldBooster(s.name, s.boost, s.uses)
    return copy
  end
  
  def name
    return @name
  end
  
  def boost
    return @boost
  end
  
  def uses
    return @uses
  end
  
  def useIt
    if @uses > 0
      @uses=@uses-1
      return @boost
    else
      return 1.0
    end
  end
end
