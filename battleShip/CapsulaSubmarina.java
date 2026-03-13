import java.util.*;

/**
 * Write a description of class CapsulaSubmarina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CapsulaSubmarina extends Machine implements MaquinaNodriza{

    private MaquinaNodriza maquinaNodriza;
    private Collection<CapsulaSubmarina> capsulas = new ArrayList<>();

    /**
     * Constructor for objects of class CapsulaSubmarina
     */
    public CapsulaSubmarina(MaquinaNodriza nodriza)
    {
        maquinaNodriza = nodriza;
    }

    /**
     * devuelve una instruccion
     * 
     * return string con instruccion
     */
    @Override
    public String giveInstruction(){
        return "Instruction"; 
    }
    
    /**
     * determina si la capsula es debil
     * 
     * @return false ya que por defecto ninguna capsula es debil
     */
    @Override
    public boolean isWeak(){
        return  false;
    }
    
    /**
     * determina si una capsula en la posicion designada sera destruida
     * 
     * @return devuelve false ya que no es posible destruir ninguna capsula
     */
    @Override
    public boolean willBeDestroyed(int longitude, int latitude){
        return false;
    }
}
