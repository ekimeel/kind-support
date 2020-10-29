package kind.support.reflections;

import kind.support.collections.Lists;
import kind.support.text.Strings;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static kind.support.Preconditions.assertNotNull;

public class Reflector {

    public final static String GET = "get";
    public final static String SET = "set";

    private Reflector() {
    }

    /**
     * Invokes a getter method of the given instance of the
     * <code>Object</code>.
     * <br/><br/>
     * Note: the name is a name of a getter method.  E.g. A object has
     * a instance variable named 'value' the name can be passed as
     * 'value' or as 'getValue'.  If the name is based without the 'get'
     * then one will automatically be added.
     *
     * @param <T>
     * @param obj
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(Object obj, String name) {
        if (hasGetter(obj, name)) {
            try {
                Method method = obj.getClass().getMethod(toGetter(name));
                return (T) method.invoke(obj, new Object[0]); //Trusting the developer ;)
            } catch (Exception ex) {
                Logger.getLogger(Reflector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    /**
     * Checks if the given <code>Object</code> contains a getter method
     * in Sun standard naming convensions.
     * <br/><br/>
     * Example:<br/><br/>
     * 1.) If a class contains a instance varable named 'age' of type int
     * the standard getter method would be named 'getAge()'
     *
     * @param obj
     * @param name
     * @return
     */
    public static boolean hasGetter(Object obj, String name) {
        final String getter = toGetter(name);
        final Method[] methods = obj.getClass().getMethods();

        for (Method aMethod : methods) {
            if (aMethod.getName().equals(getter)) {
                return true;
            }
        }
        return false;
    }

    public static String toGetter(String name) {
        final String getter = ((name.substring(0, 2).equals(GET)) ? name : GET + name);
        return Strings.toUpperCase(getter, 3);
    }

    public static synchronized <T> Class getComponentType(T generic) {
        assertNotNull(generic, "Cannot perform reflection operations on a null.  Check you arguments.");
        return generic.getClass().getComponentType();
    }

    /**
     * Returns an instance of a no argument <code>Method</code> in the given <code>Object</code> that has the given name.
     * any arguments.
     *
     * @param ref        not nullable
     * @param methodName the exact method name
     * @return an instance of a no argument <code>Method</code> in the given <code>Object</code> that has the given name.
     * @throws NoSuchMethodException if method does not exist.
     */
    public static synchronized Method getMethod(Object ref, String methodName) throws NoSuchMethodException {
        assertNotNull(ref, "Cannot perform reflection operations on a null.  Check you arguments.");
        return ref.getClass().getMethod(methodName, new Class<?>[0]);
    }

    /**
     * Returns an instance of a  <code>Method</code> in the given <code>Object</code> that has the given name and type arguments.
     *
     * @param ref        not nullable
     * @param methodName the exact method name
     * @param typeArgs   nullable
     * @return an instance of  <code>Method</code> in the given <code>Object</code> that has the given name and type arguments.
     * @throws NoSuchMethodException if method does not exist.
     */
    public static synchronized Method getMethod(Object ref, String methodName, Class... typeArgs) throws NoSuchMethodException {
        assertNotNull(ref, "Cannot perform reflection operations on a null.  Check you arguments.");

        if (typeArgs == null) {
            typeArgs = new Class<?>[0];
        }

        return ref.getClass().getMethod(methodName, typeArgs);
    }

    public static synchronized Field[] getFieldsWithAnnotation(Class aClass, Object ref) {
        //TODO: Missing Tests
        assertNotNull(aClass, "Class cannot be null and is.");
        assertNotNull(ref, "Reference cannot be null and is.");


        final Field[] fields = ref.getClass().getDeclaredFields();
        final List<Field> results = Lists.newArrayList();
        for (Field aField : fields) {
            if (aField.getAnnotation(aClass) != null) {
                results.add(aField);
            }
        }
        return results.toArray(new Field[results.size()]);
    }

    public static synchronized Object getAnnotationOfType(Class aClass, Field field, Object ref) {
        //TODO: Missing Tests
        assertNotNull(field, "Field cannot be null and is.");
        assertNotNull(ref, "Reference cannot be null and is.");

        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation aAnnotation : annotations) {
            if (aAnnotation.annotationType().getAnnotation(aClass) != null) {
                return aAnnotation;
            }
        }

        return null;
    }

    public static synchronized Field[] getFieldsWithAnnotationOfType(Class aClass, Object ref) {
        //TODO: Missing Tests
        assertNotNull(aClass, "Class cannot be null and is.");
        assertNotNull(ref, "Reference cannot be null and is.");

        Field[] fields = ref.getClass().getDeclaredFields();
        List<Field> results = Lists.newArrayList();
        for (Field aField : fields) {
            Annotation[] annotations = aField.getDeclaredAnnotations();
            for (Annotation aAnnotation : annotations) {
                if (aAnnotation.annotationType().getAnnotation(aClass) != null) {
                    results.add(aField);
                }
            }

        }
        return results.toArray(new Field[results.size()]);
    }
}
