
/**
 * Write a description of class BattleShipException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleShipException extends Exception
{
    // instance variables - replace the example below with your own
    public static final String INVALID_MOVE = "no es posible mover una maquina de la flota";
    public static final String LESS_SAILORS_THAN_MACHINES = "hay menos marineros que maquinas en la flota";
    public static final String FLEETS_POWER_ISSIUS = "mas de la mita de las flotas del tablero poseen problemas de poder";
    public static final String NOT_ASSIGNED_SAILORS = "La flota no tiene marineros asignados";
    public static final String FLEET_WITHOUT_SAILORS = "Hay una flota que no tiene marineros asignados";
    
    
    /**
     * Constructor for objects of class BattleShipException
     */
    public BattleShipException(String m){
        super(m);    
    }

}