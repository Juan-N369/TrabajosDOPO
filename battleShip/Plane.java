public class Plane extends Machine {

    private String plate;
    private boolean inAir;
    private Sailor pilot;
    private Sailor copilot;
    
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
    
}
