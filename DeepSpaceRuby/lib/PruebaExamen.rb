# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Modulito
  require_relative "Dice.rb"
  class ExamenP
    def self.main
      dice = Deepspace::Dice.new
      p1=0.0
      p2=0.0
      p3=0.0
      for i in (0..1000)
        h= dice.initWithNWeapons 
        if h==1.0
          p1+=1
        elsif h==2
            p2+=1.0
        else
          p3+=1.0
  
      end
    end
    
      pr1=p1/1000
      pr2=p2/1000
      pr3=p3/1000
      
      puts "#{pr1} #{pr2} #{pr3}"
  end
  
  ExamenP.main
end
end
