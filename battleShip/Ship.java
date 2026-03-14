import java.util.*;

public class Ship extends Machine implements MaquinaNodriza{
    
    private int number;
    private Collection<Sailor> sailors;
    private Collection<CapsulaSubmarina> capsulas;
    private String instruction;
    
    /**
     * Crea un barco con una posición inicial y una colección de marinos.
     *
     * @param longitude longitud inicial del barco
     * @param latitude latitud inicial del barco
     * @param sailors marinos asignados al barco
     */
    public Ship(int longitude, int latitude, Collection<Sailor> sailors) {
        super(longitude, latitude);
        this.sailors = sailors;
        capsulas = new ArrayList<>();
        instruction = "";
    }
    
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
     * Retorna la colección de marinos del barco.
     *
     * @return colección de marinos
     */
    public Collection<Sailor> getSailors() {
        return sailors;
    }

    /**
     * Cambia la instrucción actual del barco.
     *
     * @param instruction nueva instrucción del barco
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    /**
     * sirve para dar instrucciones a las capsulas que lo deseen
     * 
     * @return devuelve una cadena con instruccion
     */
    @Override
    public String giveInstruction(){
        return instruction;
    }
    
    /**
     * Registra una cápsula dependiente de este barco.
     *
     * @param capsula cápsula dependiente
     */
    @Override
    public void addCapsula(CapsulaSubmarina capsula){
        capsulas.add(capsula);
    }
    
    /**
     * Le da la orden al barco de que se destruya y por ende se
     * destruirán todas las cápsulas que tengan como nodriza al barco.
     *
     * @param reason razón por la que se dio la orden
     */
    @Override
    public void autoDestruction(String reason){
        super.destroyed = true;
        super.reasonDestruction = reason;
        
        for(CapsulaSubmarina capsula : capsulas){
            capsula.autoDestruction("Máquina nodriza destruida");
        }
    }
        
}
