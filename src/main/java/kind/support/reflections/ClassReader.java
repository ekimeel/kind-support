package kind.support.reflections;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class ClassReader {

    /**
     * Returns if the current class implements the <code>Serializable</code>
     * interface.
     *
     * @param aClass the class to read.
     * @return True if the class implements the <code>Serializable</code>
     * interface, otherwise false.
     */
    public static Boolean isSerializable(Class aClass) {
        Class[] interfaces = aClass.getInterfaces();

        for (Class interfaceOfClass : interfaces)
            if (interfaceOfClass instanceof Serializable)
                return true;


        return false;
    }

    /**
     * Returns if the current class is a <code>interface</code>.
     *
     * @param aClass the class to read.
     * @return True if the class is a <code>interface</code>, otherwise false.
     */
    public static Boolean isInterface(Class aClass) {
        return aClass.isInterface();
    }

    /**
     * Returns if the current class has a public constructor.
     *
     * @param aClass The class to read.
     * @return True if the class has a public constructor.
     * @see ClassReader#hasNoArgPublicConstructor(Class)
     */
    public static Boolean hasPublicConstructor(Class aClass) {
        return ((aClass.getConstructors().length == 0) ? false : true);
    }

    /**
     * Returns if the current class has a public no arg constructor.
     *
     * @param aClass The class to read.
     * @return True if the class has a public no arg constructor.
     */
    public static Boolean hasNoArgPublicConstructor(Class aClass) {
        try {
            Object object = aClass.newInstance();

            return (object != null) ? true : false;
        } catch (InstantiationException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
    }

    /**
     * Returns if the current class has a protected constructor.
     *
     * @param aClass The class to read.
     * @return True if the class has a protected constructor.
     */
    public static Boolean hasProtectedConstructor(Class aClass) {
        Constructor[] constructors = aClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            String metaData = constructor.toGenericString();

            if (metaData.contains("protected " + aClass.getName()))
                return true;

        }

        return false;
    }

    /**
     * Returns if a given <code>class</code> implements a given <code>interface</code>.
     *
     * @param aClass     The class to read.
     * @param aInterface The interface to check for.
     * @return True if the given <code>class</code> contains the given <code>interface</code>, otherwise false.
     */
    public static Boolean hasInterface(Class aClass, Class aInterface) {
        Class[] interfaces = aClass.getInterfaces();

        for (Class interfaceOfClass : interfaces)
            if (interfaceOfClass.equals(aInterface))
                return true;

        return false;
    }

    /**
     * Returns if the given <code>Class</code> contains the given
     * method.  The method name given should be the literal name E.g.
     * 'getName', 'equals', 'clone'
     *
     * @param aClass      The class to read.
     * @param aMethodName The method name to look for.
     * @return True if the given <code>Class</code> contains the given
     * method, otherwise false.
     */
    public static Boolean hasPublicMethod(Class aClass, String aMethodName) {
        try {
            Method[] methods = aClass.getMethods();

            for (Method method : methods)
                if (method.getName().equals(aMethodName))
                    return true;

            return false;

        } catch (Exception ex) {
            return false;
        }

    }

    /**
     * Returns if the given <code>Class</code> contains the given
     * annotation as a <code>Class</code>.
     *
     * @param aClass      The class to read.
     * @param aAnnotation The annotation class.
     * @return True if the given <code>Class</code> contains the given
     * annotation class, otherwise false.
     */
    @SuppressWarnings("unchecked")
    public static Boolean hasAnnotation(Class aClass, Class aAnnotation) {
        return ((aClass.getAnnotation(aAnnotation) != null) ? true : false);
    }

}
