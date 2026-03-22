import java.util.Objects;

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
    
    public String getReasonDestruction() {
        return reasonDestruction;
    }
    
    @Override
    public boolean equals(Object obj) {
        // 1. Verificar si es el mismo objeto (misma referencia en memoria)
        if (this == obj) {
            return true;
        }
        
        // 2. Verificar si el objeto es null
        if (obj == null) {
            return false;
        }
        
        // 3. Verificar si son de la misma clase
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        // 4. Hacer casting seguro
        Sailor marinero = (Sailor) obj;
        
        // 5. Comparar los campos relevantes
        return rank == marinero.rank &&
               Objects.equals(name, marinero.name) &&
               destroyed == marinero.destroyed &&
               Objects.equals(reasonDestruction, marinero.reasonDestruction);
    }
}
