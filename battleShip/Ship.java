import java.util.*;

public class Ship extends Machine implements MaquinaNodriza{

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
    
    @Override
    public String giveInstruction(){
        return "Instructuion";
    }
        
}
