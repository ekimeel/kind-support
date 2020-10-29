package kind.support.reflections;

import kind.support.collections.Lists;
import kind.support.tuples.Tuple2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FieldWalker {

    public static Object walk(Object ref, String path) {
        final List<Tuple2<Field, String>> paths = createFields(ref.getClass(), path);

        Object point = ref;
        for (Tuple2<Field, String> fieldPair : paths) {
            try {

                point = fieldPair.getValue1().get(point);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(FieldWalker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FieldWalker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return point;

    }

    private static List<Tuple2<Field, String>> createFields(Class aClass, String path) {
        final String[] paths = path.split("\\.");
        final List<Tuple2<Field, String>> fieldMap = Lists.newArrayList();

        for (int i = 0; i < paths.length; i++) {
            try {
                final String formattedPath = parseFieldName(paths[i]);
                Field field = aClass.getDeclaredField(formattedPath);
                field.setAccessible(true);
                fieldMap.add(new Tuple2<Field, String>(field, paths[i]));

//                System.out.println("found field '" + field.getName() + "' of type '" +field.getType().getSimpleName() + "'");
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(FieldWalker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(FieldWalker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fieldMap;
    }

    private static String parseFieldName(String expression) {
        if (!expression.contains("["))
            return expression;

        return expression.substring(0, expression.indexOf("["));

    }
}
