package kind.support;

import kind.support.maps.Maps;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Types {

    private static final HashMap<String, Class> nameToClassMap = Maps.newHashMap();
    private static final HashMap<Class, String> classToNameMap = Maps.newHashMap();


    static {

        nameToClassMap.put("String", String.class);
        nameToClassMap.put("Boolean", Boolean.class);
        nameToClassMap.put("Byte", Byte.class);
        nameToClassMap.put("Character", Character.class);
        nameToClassMap.put("Double", Double.class);
        nameToClassMap.put("Float", Float.class);
        nameToClassMap.put("Integer", Integer.class);
        nameToClassMap.put("Long", Long.class);
        nameToClassMap.put("Short", Short.class);

        nameToClassMap.put("string", String.class);
        nameToClassMap.put("boolean", Boolean.TYPE);
        nameToClassMap.put("byte", Byte.TYPE);
        nameToClassMap.put("char", Character.TYPE);
        nameToClassMap.put("double", Double.TYPE);
        nameToClassMap.put("float", Float.TYPE);
        nameToClassMap.put("int", Integer.TYPE);
        nameToClassMap.put("long", Long.TYPE);
        nameToClassMap.put("short", Short.TYPE);

        nameToClassMap.put("java.lang.String", String.class);
        nameToClassMap.put("java.lang.Boolean", Boolean.class);
        nameToClassMap.put("java.lang.Byte", Byte.class);
        nameToClassMap.put("java.lang.Character", Character.class);
        nameToClassMap.put("java.lang.Double", Double.class);
        nameToClassMap.put("java.lang.Float", Float.class);
        nameToClassMap.put("java.lang.Integer", Integer.class);
        nameToClassMap.put("java.lang.Long", Long.class);
        nameToClassMap.put("java.lang.Short", Short.class);

        nameToClassMap.put("java.lang.String.TYPE", String.class);
        nameToClassMap.put("java.lang.Boolean.TYPE", Boolean.class);
        nameToClassMap.put("java.lang.Byte.TYPE", Byte.class);
        nameToClassMap.put("java.lang.Character.TYPE", Character.class);
        nameToClassMap.put("java.lang.Double.TYPE", Double.class);
        nameToClassMap.put("java.lang.Float.TYPE", Float.class);
        nameToClassMap.put("java.lang.Integer.TYPE", Integer.class);
        nameToClassMap.put("java.lang.Long.TYPE", Long.class);
        nameToClassMap.put("java.lang.Short.TYPE", Short.class);
        nameToClassMap.put("java.lang.Void.TYPE", Void.class);

    }


    static {
        classToNameMap.put(Boolean.TYPE, "boolean");
        classToNameMap.put(Byte.TYPE, "byte");
        classToNameMap.put(Character.TYPE, "char");
        classToNameMap.put(Double.TYPE, "double");
        classToNameMap.put(Float.TYPE, "float");
        classToNameMap.put(Integer.TYPE, "int");
        classToNameMap.put(Long.TYPE, "long");
        classToNameMap.put(Short.TYPE, "short");
        classToNameMap.put(Void.TYPE, "void");

        classToNameMap.put(Boolean.class, "java.lang.Boolean");
        classToNameMap.put(Byte.class, "java.lang.Byte");
        classToNameMap.put(Character.class, "java.lang.Character");
        classToNameMap.put(Double.class, "java.lang.Double");
        classToNameMap.put(Float.class, "java.lang.Float");
        classToNameMap.put(Integer.class, "java.lang.Integer");
        classToNameMap.put(Long.class, "java.lang.Long");
        classToNameMap.put(Short.class, "java.lang.Short");

        classToNameMap.put(null, "void");
        classToNameMap.put(String.class, "java.lang.String");
    }

    /**
     * <br/>
     * <u>Short Names</u><br/>
     * <table border="1"><tr>
     * <td><strong>String Input</strong></td><td><strong>Class Output</strong></td></tr>
     * <tr><td>String</td><td>java.lang.String.class</td></tr>
     * <tr><td>Boolean</td><td>java.lang.Boolean.class</td></tr>
     * <tr><td>Byte</td><td>java.lang.Byte.class</td></tr>
     * <tr><td>Character</td><td>java.lang.Character.class</td></tr>
     * <tr><td>Double</td><td>java.lang.Double.class</td></tr>
     * <tr><td>Float</td><td>java.lang.Float.class</td></tr>
     * <tr><td>Integer</td><td>java.lang.Integer.class</td></tr>
     * <tr><td>Long</td><td>java.lang.Long.class</td></tr>
     * <tr><td>Short</td><td>java.lang.Short.class</td></tr>
     * </table>
     * <br/>
     * <u>Long Names</u>
     * <table border="1"><tr>
     * <td><strong>String Input</strong></td><td><strong>Class Output</strong></td></tr>
     * <tr><td>java.lang.String</td><td>java.lang.String.class</td></tr>
     * <tr><td>java.lang.Boolean</td><td>java.lang.Boolean.class</td></tr>
     * <tr><td>java.lang.Byte</td><td>java.lang.Byte.class</td></tr>
     * <tr><td>java.lang.Character</td><td>java.lang.Character.class</td></tr>
     * <tr><td>java.lang.Double</td><td>java.lang.Double.class</td></tr>
     * <tr><td>java.lang.Float</td><td>java.lang.Float.class</td></tr>
     * <tr><td>java.lang.Integer</td><td>java.lang.Integer.class</td></tr>
     * <tr><td>java.lang.Long</td><td>java.lang.Long.class</td></tr>
     * <tr><td>java.lang.Short</td><td>java.lang.Short.class</td></tr>
     * </table>
     *
     * @return a Day if value given can be found, Otherwise null.
     */
    public static Class fromName(String name) {

        return (Class) nameToClassMap.get(name);
    }

    /* ------------------------------------------------------------ */

    /**
     * Canonical name for a type.
     *
     * @param type A class , which may be a primitive TYPE field.
     * @return Canonical name.
     */
    public static String toName(Class type) {
        return (String) classToNameMap.get(type);
    }

    public static synchronized <T> T newInstance(Class<T> ref) {
        try {
            return ref.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(Types.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Types.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
