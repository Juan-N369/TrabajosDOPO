public abstract class Machine {

    private Position location;
    
    /**
     * metodo que dice si la maquina es debil o no
     * 
     * @return devuelve false ya que por defecto una maquina no se considera debil
     */
    abstract boolean isWeak();
    
    public boolean willBeDestroyed(int longitude, int latitude){
        return location.samePosition(longitude, latitude);
    }
}
