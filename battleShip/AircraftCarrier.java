import java.util.ArrayList;

public class AircraftCarrier extends Ship {

    private int capacity;
    private ArrayList<Plane> airPlanes;
    
    /**
     * determina si un portaaviones es debil
     * 
     * @return devuelve false en caso de que el portaaviones no sea un barco debil
     * y si ninguno de sus aviones en aire se considera debil
     * 
     */
    @Override
    public boolean isWeak(){
        boolean weak = super.isWeak();
        
        if (!weak){
            for(Plane p : airPlanes){
                boolean planeWeak = p.isWeak();
                boolean inAir = p.isInAir();
                if(planeWeak && inAir){
                    weak = true;
                    break;
                }
            }
        }
        
        return weak;
    }
    
}
