package kind.support;

public final class Booleans
{
    private Booleans(){
    }

    /**
     * Inverses the boolean value.  <br/>
     * Example<br/>
     * inverse(true) returns false<br/>
     * inverse(false) returns true<br/>
     * @param bool
     * @return the inverse of the given boolean
     */
    public static boolean inverse(boolean bool){        
        return ((bool)? false:true);
    }
    
    /**
     * Converts the given integer to a boolean.  Any number greater
     * than zero will return true. Any number less then or equal to
     * zerio will return false.
     * 
     * <pre>
     * Booleans.toBoolean(-2)    = false
     * Booleans.toBoolean(-1)    = false
     * Booleans.toBoolean(0)    = false
     * Booleans.toBoolean(1)    = true
     * Booleans.toBoolean(2)    = true
     * </pre>
     * @param i int to convert
     * @return <code>true</code> if the given int is greater than zero,
     * otherwise false
     */
    public static boolean toBoolean(int i){
        return ((i>0)?true:false);
    }

}
