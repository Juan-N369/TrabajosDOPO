import java.util.ArrayList;

public class Board {

    private ArrayList<Fleet> fleets;
    private int radius;
    
    public boolean validPosicion(int longitude ,int latitude){
        boolean valid = false;
        int x = longitude;
        int y = latitude;
        
        if (x * x + y * y <= radius * radius) {
            valid = true;    
        }
        
        return valid;
    }
    
}
