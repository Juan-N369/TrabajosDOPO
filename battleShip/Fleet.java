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
     * 
     * @throws BattleShipException si la nueva posicion de una de las maquinas no se encuentra en el tablero.
     */
    public void advance(int dLong, int dLat) throws BattleShipException
    {
        for(Machine m : machines)
        {
            int currentLon = m.getLongitude();
            int currentLat = m.getLatitude();

            if(board.isAValidLocation(currentLon + dLong, currentLat + dLat))
            {
                m.advance(dLong, dLat);
            }
            else{
                throw new BattleShipException(BattleShipException.INVALID_MOVE);
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
    
    /**
     * mueve a todas las maquinas de la flota una unidad al norte
     * 
     * @throws BattleShipException si advance genera una excepcion
     */
    public void moveNorth() throws BattleShipException{
        advance(0, 1);
    }
    
    /**
     * determina el poder que tiene actualmente la maquina
     * 
     * @return el poder de la flota, el cual es la cantidad de maquinas
     * que no son debiles.
     * 
     * @throws BattleShipException si hay menos marineros que maquinas
     */
    public int power() throws BattleShipException{
        int powerFleet = 0;
        boolean weak;
        
        if(sailors.size() < machines.size()){
            throw new BattleShipException(BattleShipException.LESS_SAILORS_THAN_MACHINES);
        }
        
        for(Machine m: machines){
            weak = m.isWeak();
            if(!weak){
                powerFleet++;
            }
        }
        
        return powerFleet;
    }
    
    /**
     * determina si la flota tiene un piloto infiltrado
     * 
     * @return true si lo tiene, false si no lo tiene
     * 
     * @throws BattleShipException si la flota no tiene asignados marineros
     */
    public boolean hasPilotInfiltrated() throws BattleShipException{
        boolean itHas = false;
        
        if(sailors.isEmpty()){
            throw new BattleShipException(BattleShipException.NOT_ASSIGNED_SAILORS);
        }
        
        for(Machine m: machines){
            Sailor pilot = m.getPilot();
            if(pilot != null && !sailors.contains(pilot)){
                itHas = true;
                break;
            }
        }
        
        return itHas;
    }
}
