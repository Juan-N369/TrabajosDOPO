import java.util.*;

public class Ship extends Machine implements MaquinaNodriza{
    
    private int number;
    private Collection<Sailor> sailors;
    private Collection<CapsulaSubmarina> capsulas = new ArrayList<>();
    
    
    /**
     * determina si un barco es debil
     * 
     * @return devuelve false si el barco tiene 5 o mas marineros, de lo contrario retorna
     * true
     */
    @Override
    public boolean isWeak(){
        return sailors.size() < 5;
    }
    
    /**
     * sirve para dar instrucciones a las capsulas que lo deseen
     * 
     * @return devuelve una cadena con instruccion
     */
    @Override
    public String giveInstruction(){
        return "Instructuion";
    }
    
    /**
     * le da la orden al barco de que se destruya y por ende se
     * destruiran todas las capsulas que tengan como nodriza al barco
     * 
     * @param reason razon por la que se dio la orden
     */
    @Override
    public void autoDestruction(String reason){
        super.destroyed = true;
        super.reasonDestruction = reason;
        
        for(CapsulaSubmarina capsula: capsulas){
            capsula.autoDestruction("Maquina nodriza destruida");
        }
    }
        
}
