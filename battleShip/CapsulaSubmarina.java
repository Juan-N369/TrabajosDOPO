import java.util.*;

public class CapsulaSubmarina extends Machine implements MaquinaNodriza{

    private MaquinaNodriza maquinaNodriza;
    private Collection<CapsulaSubmarina> capsulas;
    private int depth;
    private String instruction;
    
    /**
     * Crea una cápsula submarina con su posición, su máquina nodriza
     * y su profundidad.
     *
     * @param longitude longitud inicial
     * @param latitude latitud inicial
     * @param maquinaNodriza máquina nodriza de la cápsula
     * @param depth profundidad de la cápsula
     */
    public CapsulaSubmarina(int longitude, int latitude, MaquinaNodriza maquinaNodriza, int depth) {
        super(longitude, latitude);
        this.maquinaNodriza = null;
        this.depth = depth;
        instruction = "";
        this.capsulas = new ArrayList<>();
    }

    /**
     * Asigna la máquina nodriza de la cápsula y la registra
     * como cápsula dependiente de esa nodriza.
     *
     * @param maquinaNodriza máquina nodriza a asignar
     */
    public void setMaquinaNodriza(MaquinaNodriza maquinaNodriza) {
        this.maquinaNodriza = maquinaNodriza;
        maquinaNodriza.addCapsula(this);
    }
    
    /**
     * Cambia la instrucción propia de la cápsula cuando actúa
     * como máquina nodriza de otra cápsula.
     *
     * @param instruction nueva instrucción
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    /**
     * devuelve una instruccion
     * 
     * return string con instruccion
     */
    @Override
    public String giveInstruction(){
        return instruction; 
    }
    
    @Override
    public void addCapsula(CapsulaSubmarina capsula) {
        capsulas.add(capsula);
    }
    
    /**
     * Retorna la instrucción dada por la máquina nodriza.
     *
     * @return instrucción de la nodriza
     */
    public String askForInstruction() {
        if (maquinaNodriza == null) {
            return "";
        }
        return maquinaNodriza.giveInstruction();
    }
    
    public int getDepth() {
        return depth;
    }
    
    /**
     * Retorna la máquina nodriza de la cápsula.
     *
     * @return máquina nodriza
     */
    public MaquinaNodriza getMaquinaNodriza() {
        return maquinaNodriza;
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
        if (depth > 8000) {
            return false;
        }
        return super.willBeDestroyed(longitude, latitude);
    }
    
    /**
     * orden para que la capsula que se autodestruya
     * 
     * @param reason razon por la que se le ordeno que se autodestruyera
     */
    
    @Override
    public void autoDestruction(String reason) {
        super.destroyed = true;
        super.reasonDestruction = reason;

        for (CapsulaSubmarina capsula : capsulas) {
            capsula.autoDestruction("Máquina nodriza destruida");
        }
    }
}
