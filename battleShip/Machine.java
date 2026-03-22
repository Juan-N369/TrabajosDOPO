public abstract class Machine implements DestructibleElement{

    private Position location;
    protected boolean destroyed = false;
    protected String reasonDestruction = null;
    
    /**
     * Crea una máquina en una posición inicial.
     *
     * @param longitude longitud inicial
     * @param latitude latitud inicial
     */
    public Machine(int longitude, int latitude) {
        location = new Position(longitude, latitude);
    }
    
    /**
     * metodo que dice si la maquina es debil o no
     * 
     * @return devuelve false ya que por defecto una maquina no se considera debil
     */
    abstract boolean isWeak();
    
    /**
     * retorna la longitud en la que se encuentra la maquina
     * 
     * @ return longitud de la maquina
     */
    public int getLongitude(){
        return location.getLongitude();
    }
    
    /**
     * retorna la latitud en la que se encuentra la maquina
     * 
     * @return latitude de la maquina
     */
    public int getLatitude(){
        return location.getLatitude();
    }
    
    /**
     * dezplaza la maquina desde la maquina desde la locacion actual
     * 
     * @param dLon dezplazamiento en longitud
     * @param dLat dezplazamiento en latitud
     */
    public void advance(int dLon, int dLat){
        location.move(dLon, dLat);
    }
    
    /**
     * determina si la maquina sera destruida en la posicion dada
     * 
     * @return true si lo sera, false si no
     */
    public boolean willBeDestroyed(int longitude, int latitude){
        return location.samePosition(longitude, latitude);
    }
    
    /**
     * dice si la maquina fue destruida
     * 
     * return true si ya lo fue, false si no
     */
    public boolean wasDestroyed(){
        return destroyed;
    }
    
    /**
     * orden para que la maquina se autodestruya
     * 
     * @param reason razon por la que se le ordeno que se autodestruyera
     */
    public void autoDestruction(String reason){
        /*en esta super clase no se hace nada, 
        ya que no todas las maquinas
        pueden autodestruirse*/
    }
    
    /**
     * Retorna la razón por la que la máquina fue destruida.
     *
     * @return razón de destrucción
     */
    @Override
    public String getReasonDestruction() {
        return reasonDestruction;
    }
    
    /**
     * devuelve el piloto que a maquina tiene asignado
     * 
     * por defecto una maquina no tiene piloto
     * 
     * @return piloto de la maquina
     */
    public Sailor getPilot(){
        return null;
    }
}
