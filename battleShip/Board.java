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
    
}
