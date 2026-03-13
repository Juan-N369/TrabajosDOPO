public class Sailor implements DestructibleElement{

    private String name;
    private int rank;
    private boolean destroyed;
    private String reasonDestruction;
    
    /**
     * dice si el marinero fue destruido
     * 
     * @param true si o fue, false si no
     */
    public boolean wasDestroyed(){
        return destroyed;
    }
    
    /**
     * le da la orden al marinero de eliminarse
     * 
     * @param reason es la razon por la cual se dio la orden
     */
    public void autoDestruction(String reason){
        destroyed = true;
        reasonDestruction = reason;
    }
}
