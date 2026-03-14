import java.util.*;

public class Fleet {

    private String name;
    private ArrayList<Machine> machines;
    private ArrayList<Sailor> sailors;
    private Board board;
    
    /**
     * determina las maquinas de la flota que se consideran debiles
     * 
     * @return ArrayList que contiene las maquinas que se encontraron como debiles
     */
    public ArrayList<Machine> weakMachines(){
        ArrayList<Machine> weakM = new ArrayList<>();
        
        for(Machine m: machines){
            if (m.isWeak()){
                weakM.add(m);
            }
        }
        
        return weakM;
    }
    
    /**
     * determina que maquinas que se encuentran en la posicion dada seran destruidas
     * 
     * @param longitude es la longitud donde se hara el ataque
     * @param latitude es la latitud donde se hara el ataque
     * @return arraylist de las maquinas que serian destruidas
     */
    public ArrayList<Machine> willBeDestroyed(int longitude, int latitude){
        ArrayList<Machine> willBe = new ArrayList<>();
        for (Machine m : machines) {
            if (m.willBeDestroyed(longitude, latitude)) {
                willBe.add(m);
            }
        }
        return willBe;  
    }
    
    /**
     * hace que todas las maquinas de la flota que no se salgan del mapa al avanzar
     * avancen cierta longitud y latitud desde su posicion actual
     * 
     * @param dLon es el avance en longitude
     * @param dLat es el avance en latitude
     */
    public void advance(int dLong, int dLat)
    {
        for(Machine m : machines)
        {
            int currentLon = m.getLongitude();
            int currentLat = m.getLatitude();

            if(board.isAValidLocation(currentLon + dLong, currentLat + dLat))
            {
                m.advance(dLong, dLat);
            }
        }
    }
    
    /**
     * Determina todas las máquinas y marinos que se encuentran destruidos.
     * 
     * @return devuelve un arraylist con los elementos destruidos
     */
    public ArrayList<Object> destroyedMachines() {
        ArrayList<Object> destroyed = new ArrayList<>();

        for (Machine m : machines) {
            if (m.wasDestroyed()) {
                destroyed.add(m);
            }
        }

        for (Sailor s : sailors) {
            if (s.wasDestroyed()) {
                destroyed.add(s);
            }
        }

        return destroyed;
    }
    
    public void updateCapsulesState() {
        for (Machine m : machines) {
            if (m instanceof CapsulaSubmarina) {
                CapsulaSubmarina capsula = (CapsulaSubmarina) m;
                capsula.verifyMotherMachine();
            }
        }
    }
}
