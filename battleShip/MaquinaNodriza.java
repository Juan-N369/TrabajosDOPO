
/**
 * Write a description of interface MaquinaNodriza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface MaquinaNodriza extends DestructibleElement
{
    /**
     * Las maquinas Nodrizas tienen como responsabilidad dar instrucciones
     * 
     * @return devuelve un String con instrucciones especificas
     */
    String giveInstruction();

    /**
     * Registra una cápsula submarina que depende de esta nodriza.
     *
     * @param capsula cápsula dependiente
     */
    void addCapsula(CapsulaSubmarina capsula);


}
