public class Position {

    private int longitude;

    private int latitude;
    
    public boolean samePosition(int lon, int lat){
        return longitude == lon && latitude == lat; 
    }
}
