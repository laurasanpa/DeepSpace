/**
 *
 * @author Samuel Medina
 * @author Laura Sánchez
 */

package deepspace;

class ShieldBooster implements Copyable<ShieldBooster> {
    
    // Definición de atributos
    private String name;
    private float boost;
    private int uses;
    
    /**
     * Constructor
     * @param n, nombre
     * @param b, boost
     * @param u, uses
     */
    public ShieldBooster(String n,float b,int u){
        name = n;
        boost = b;
        uses = u;
    }
    
    /**
     * Constructor de copias: genera una nueva instancia de la clase ShieldBooster a
     * partir de una instancia ya existente dada como parámetro.
     * @param s 
     */
    public ShieldBooster(ShieldBooster s){
        name=s.name;
        boost=s.boost;
        uses=s.uses;
    }
    
    /**
     * getName(): consultor del atributo de instancia name
     * @return name(String)
     */
    public String getName(){
        return name;
    }
    /**
     * getBoost(): consultor del atributo de instancia boost
     * @return boost(float)
     */
    public float getBoost(){
        return boost;
    }
    /**
     * getUses(): consultor del atributo de instancia uses
     * @return uses(int)
     */
    public int getUses(){
        return uses;
    }
    
    /**
     * Useit: Decrementa uses si uses>0 y devuelve el valor de boost, 
     * devuelve 1.0 en otro caso
     * @return float
     */
    public float useIt(){
        if(uses>0){
            uses--;
            return boost;
        }else
            return (float) 1.0;
    }
    
    public ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }

    @Override
    public String toString() {
        return "ShieldBooster{" + "name=" + name + ", boost=" + boost + ", uses=" + uses + '}';
    }

    @Override
    public ShieldBooster copy() {
        return new ShieldBooster(this);
    }
    
    
    }
   
   
    
    
