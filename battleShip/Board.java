import java.util.ArrayList;

public class Board {

    private ArrayList<Fleet> fleets;
    private int radius;
    
    public Board(int radius) {
        this.radius = radius;
        fleets = new ArrayList<>();
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void addFleet(Fleet fleet) {
        fleets.add(fleet);
    }
    
    public boolean isAValidLocation(int longitude, int latitude)
    {
        return (longitude - radius) * (longitude - radius) + latitude * latitude <= radius * radius;
    }
    
    /**
     * mueve a todas las flotas del tablero una unidad al norte
     * 
     * @return numero de flotas que completaron el movimiento a norte.
     */
    public int toNorth(){
        int fleetsMoved = 0;
        
        for (Fleet f: fleets){
            try{
                f.moveNorth();
                fleetsMoved++;
            }
            catch (BattleShipException e){
            }
        }
        
        return fleetsMoved;
    }
    
    /**
     * consulta el poder del tablero, este sera la suma de los poderes de sus
     * flotas
     * 
     * @return el poder del tablero
     * 
     * @throws BattleShipException si mas de la mitad de las flotas tienen
     * problemas de poder
     */
    public int power() throws BattleShipException{
        int powerBoard = 0;
        int fleetsWithIssius = 0;
        
        for(Fleet f: fleets){
            try{
                powerBoard += f.power();
            }
            catch(BattleShipException e){
                fleetsWithIssius++;    
            }
        }
        
        if(fleetsWithIssius > fleets.size()/2){
            throw new BattleShipException(BattleShipException.FLEETS_POWER_ISSIUS);
        }
        
        return powerBoard;
    }
    
    /**
     * determina las flotas que tienen un piloto infiltrado
     * 
     * @return un ArrayList con las flotas con infiltrados
     * 
     * @throws BattleShipException si alguna de las flotas no tiene marineros
     * asignados
     */
    public ArrayList<Fleet> infiltrated() throws BattleShipException{
        ArrayList<Fleet> isInfiltrated = new ArrayList<>();
        boolean infiltrated;
        
        for(Fleet f: fleets){
            try{
                infiltrated = f.hasPilotInfiltrated();
            }
            catch(BattleShipException e){
                throw new BattleShipException(BattleShipException.FLEET_WITHOUT_SAILORS);
            }
            
            if(infiltrated){
                isInfiltrated.add(f);  
            }
        }
        
        return isInfiltrated;
    }
}
