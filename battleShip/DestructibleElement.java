
/**
 * Write a description of interface DestructibleElement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface DestructibleElement{
    /**
     * determina si el objeto fue destruido
     */
    boolean wasDestroyed();
    
    /**
     * provoca que el objeto se autodestruya
     * 
     * @param razon por la que se autodestruyo
     */
    void autoDestruction(String reason);

    String getReasonDestruction();
}