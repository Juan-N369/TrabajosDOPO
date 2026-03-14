public class Position {

    private int longitude;
    private int latitude;
    
    /**
     * Crea una posición con una longitud y una latitud dadas.
     *
     * @param longitude longitud inicial
     * @param latitude latitud inicial
     */
    public Position(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    /**
     * retorna la longitud
     */
    public int getLongitude(){
        return longitude;
    }
    
    /**
     * retorna la latitud
     */
    public int getLatitude(){
        return latitude;
    }
    
    /**
     * mueve la posicion desde el punto en que se encuentra actualmente
     * 
     * @param dLon dezplazamiento de la longitud
     * @param dLat dezplazamiento de la latitud
     */
    public void move(int dLon, int dLat){
        longitude = longitude + dLon;
        latitude = latitude + dLat;
    }
    
    /**
     * determina si la posicion dada es igual al de la posicion
     */
    public boolean samePosition(int lon, int lat){
        return longitude == lon && latitude == lat; 
    }
}
