import java.util.ArrayList;

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

}
