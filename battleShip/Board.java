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
}
