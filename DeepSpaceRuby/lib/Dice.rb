
module Deepspace
  require_relative 'GameCharacter'
  
  class Dice
    
    def initialize
      
       @NHANGARSPROB=0.25
       @NSHIELDSPROB=0.25
       @NWEAPONSPROB=0.33
       @EXTRAEFFICIENCYPROB=0.8
       @FIRSTSHOTPROB=0.50
       
       @generator=Random.new()

    end
    
    def extraEfficiency
      if @generator.rand(1.0)<= @EXTRAEFFICIENCYPROB 
            return true
        else
            return false
         end
    end
   
    def initWithNHangars
        if @generator.rand(1.0)<= @NHANGARSPROB 
            return 0
        else
            return 1
         end
    end
    
    def initWithNWeapons 
      
       prob=@generator.rand(1.0)
       if prob < @NWEAPONSPROB
           return 1
       elsif prob>@NWEAPONSPROB && prob<(2*@NWEAPONSPROB)
           return 2
       else
           return 3
       end
    end
    
    def initWithNShields
        if @generator.rand(1.0)<@NSHIELDSPROB
          return 0
        else
            return 1
        end
    end
    
    def whoStarts(nPlayers)
      
        @generator.rand(nPlayers)
    end
    
    def firstShot
      spacestation=GameCharacter::SPACESTATION 
      enemystarship=GameCharacter::ENEMYSTARSHIP
     
         if @generator.rand(1.0)<@FIRSTSHOTPROB
             return spacestation
         else
             return enemystarship
         end
    end
    
    def spaceStationMoves(speed)
         if @generator.rand(1.0)<speed
             return true
         else
             return false
         end
    end
  end
end
