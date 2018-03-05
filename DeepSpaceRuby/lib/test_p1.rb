# encoding: utf-8

module Deepspace
class TestP1
    def main()
    
    puts 'Esto es una prueba'
    
    #botín.
    lote = Loot.new(1.0,2.0,3.0,4.0,5.0)
    puts "El botín tiene las siguientes medallas  #{lote.nMedals}"
  end
  
    c=TestP1.new
    c.main
end


end