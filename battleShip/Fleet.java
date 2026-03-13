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
        return willBe;  
    }
    
    /**
     * hace que todas las maquinas de la flota que no se salgan del mapa al avanzar
     * avancen cierta longitud y latitud desde su posicion actual
     * 
     * @param dLon es el avance en longitude
     * @param dLat es el avance en latitude
     */
    public void advance(int dLon, int dLat){
        
    }
    
    /**
     * determina todas las maquinas y marineros que se encuentran destruidos
     * 
     * @return devuelve un arraylist de las maquinas que estan destruidas
     * 
     */
    public ArrayList<Object> destroyedMachines(){
        ArrayList<Object> destroyed = new ArrayList<>();
        return destroyed;
    }
    
}
