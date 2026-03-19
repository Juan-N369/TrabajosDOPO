
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

    /**
     * Constructor for objects of class BattleShipException
     */
    public BattleShipException(String m){
        super(m);    
    }

}