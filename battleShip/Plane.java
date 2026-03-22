public class Plane extends Machine {

    private String plate;
    private boolean inAir;
    private Sailor pilot;
    private Sailor copilot;
    
    /**
     * Crea un avión con su posición inicial y su placa.
     *
     * @param longitude longitud inicial del avión
     * @param latitude latitud inicial del avión
     * @param plate placa del avión
     */
    public Plane(int longitude, int latitude, String plate) {
        super(longitude, latitude);
        this.plate = plate;
        inAir = false;
        pilot = null;
        copilot = null;
    }
    
    /**
     * determina si el avion es debil
     * 
     * @return devuelve false si el avion tiene un piloto principal, de lo contrario
     * devuelve true
     */
    @Override
    public boolean isWeak(){
        boolean weak = false;
        
        if (pilot == null){
            weak = true;
        }
        
        return weak;
    }

    /**
     * dice si el avion se encuentra en el aire
     */
    public boolean isInAir(){
        return inAir;
    }
    
    @Override
    public boolean willBeDestroyed(int longitude, int latitude) {
        if (inAir) {
            return false;
        }
        return super.willBeDestroyed(longitude, latitude);
    }
    
    @Override
    public void autoDestruction(String reason) {
        super.destroyed = true;
        super.reasonDestruction = reason;
    }
    
    /**
     * devuelve el piloto que el avion tiene asignado
     * 
     * @return piloto d el avion
     */
    @Override
    public Sailor getPilot(){
        return pilot;
    }
    
}
