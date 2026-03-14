import java.util.ArrayList;
import java.util.Collection;

/**
 * Representa un portaaviones de la flota.
 * Un portaaviones es un barco que además puede transportar aviones.
 */
public class AircraftCarrier extends Ship {

    private int number;
    private int capacity;
    private ArrayList<Plane> airPlanes;

    /**
     * Crea un portaaviones con una posición inicial, sus marinos,
     * su número y su capacidad.
     *
     * @param longitude longitud inicial del portaaviones
     * @param latitude latitud inicial del portaaviones
     * @param sailors marinos asignados al portaaviones
     * @param number número identificador del portaaviones
     * @param capacity capacidad de aviones
     */
    public AircraftCarrier(int longitude, int latitude, Collection<Sailor> sailors,int number, int capacity) {
        super(longitude, latitude, sailors);
        this.number = number;
        this.capacity = capacity;
        airPlanes = new ArrayList<>();
    }

    /**
     * Retorna la colección de aviones del portaaviones.
     *
     * @return colección de aviones
     */
    public ArrayList<Plane> getAirPlanes() {
        return airPlanes;
    }

    /**
     * Agrega un avión al portaaviones.
     *
     * @param plane avión a agregar
     */
    public void addPlane(Plane plane) {
        airPlanes.add(plane);
    }

    /**
     * Determina si el portaaviones es débil.
     * Es débil si el barco lo es o si alguno de sus aviones en el aire es débil.
     *
     * @return true si el portaaviones es débil, false en caso contrario
     */
    @Override
    public boolean isWeak() {
        if (super.isWeak()) {
            return true;
        }

        for (Plane p : airPlanes) {
            if (p.isInAir() && p.isWeak()) {
                return true;
            }
        }

        return false;
    }
}
