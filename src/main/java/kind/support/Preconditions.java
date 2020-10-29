package kind.support;

import kind.support.text.Strings;

import java.util.Collection;

public final class Preconditions {

    private Preconditions() {
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the
     * calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void assertArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the
     * calling method.
     *
     * @param expression   a boolean expression
     * @param errorMessage the exception message to use if the check fails; will
     *                     be converted to a string using {@link String#valueOf(Object)}
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void assertArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the
     * calling method.
     *
     * @param <T>
     * @param expression   a boolean expression
     * @param errorMessage the exception message to use if the check fails; will
     *                     be converted to a string using {@link String#valueOf(Object)}
     * @throws T if {@code expression} is false
     */
    public static <T extends Throwable> void assertArgument(boolean expression, T errorMessage) throws T {
        if (!expression) {
            throw errorMessage;
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling
     * instance, but not involving any parameters to the calling method.
     *
     * @param expression a boolean expression
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void assertState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling
     * instance, but not involving any parameters to the calling method.
     *
     * @param expression   a boolean expression
     * @param errorMessage the exception message to use if the check fails; will
     *                     be converted to a string using {@link String#valueOf(Object)}
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void assertState(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null.
     *
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T assertNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling
     * method is not null.
     *
     * @param reference    an object reference
     * @param errorMessage the exception message to use if the check fails; will
     *                     be converted to a string using {@link String#valueOf(Object)}
     * @return the non-null reference that was validated
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T assertNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    /**
     * Ensures that an {@code Iterable} object passed as a parameter to the
     * calling method is not null and contains no null elements.
     *
     * @param iterable the iterable to check the contents of
     * @return the non-null {@code iterable} reference just validated
     * @throws NullPointerException if {@code iterable} is null or contains at
     *                              least one null element
     */
    public static <T extends Iterable<?>> T checkContentsNotNull(T iterable) {
        if (containsOrIsNull(iterable)) {
            throw new NullPointerException();
        }
        return iterable;
    }

    /**
     * Ensures that an {@code Iterable} object passed as a parameter to the
     * calling method is not null and contains no null elements.
     *
     * @param iterable     the iterable to check the contents of
     * @param errorMessage the exception message to use if the check fails; will
     *                     be converted to a string using {@link String#valueOf(Object)}
     * @return the non-null {@code iterable} reference just validated
     * @throws NullPointerException if {@code iterable} is null or contains at
     *                              least one null element
     */
    public static <T extends Iterable<?>> T checkContentsNotNull(
            T iterable, Object errorMessage) {
        if (containsOrIsNull(iterable)) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return iterable;
    }

    private static boolean containsOrIsNull(Iterable<?> iterable) {
        if (iterable == null) {
            return true;
        }

        if (iterable instanceof Collection) {
            Collection<?> collection = (Collection<?>) iterable;
            try {
                return collection.contains(null);
            } catch (NullPointerException e) {
                // A NPE implies that the collection doesn't contain null.
                return false;
            }
        } else {
            for (Object element : iterable) {
                if (element == null) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Asserts that the {@code ref} is not {@code null} or empty
     *
     * @param nameOfRef The human readable name of the {@code ref}
     * @param ref       value to check
     * @throws IllegalArgumentException if {@code ref} is {@code null} or empty
     * @see Strings#isEmptyOrNull(String)
     */
    public static void assertNotEmpty(String nameOfRef, String ref) {
        if (Strings.isEmptyOrNull(ref)) {
            throw new IllegalArgumentException(nameOfRef + " cannot be empty.");
        }
    }

    /**
     * Asserts that the {@code collection} is equal to the {@code size}.
     *
     * @param collection The collection to assert
     * @param size       The expected size
     */
    public static void assertSize(Collection collection, int size) {
        if (collection == null) {
            throw new IllegalArgumentException("collection is null");
        }

        assertArgument(size == collection.size(), String.format("Expected collection size of [%s] but was [%s]", size, collection.size()));
    }

    /**
     * Asserts that the {@code ref} is not {@code null} or empty
     *
     * @param ref value to check
     * @throws IllegalArgumentException if {@code ref} is {@code null} or empty
     * @see Strings#isEmptyOrNull(String)
     */
    public static void assertNotEmpty(String ref) {
        if (Strings.isEmptyOrNull(ref)) {
            throw new IllegalArgumentException("String cannot be null or empty.");
        }
    }


    /**
     * Substitutes each {@code %s} in {@code template} with an argument. These
     * are matched by position - the first {@code %s} gets {@code args[0]}, etc.
     * If there are more arguments than placeholders, the unmatched arguments will
     * be appended to the end of the formatted message in square braces.
     *
     * @param template a non-null string containing 0 or more {@code %s}
     *                 placeholders.
     * @param args     the arguments to be substituted into the message
     *                 template. Arguments are converted to strings using
     *                 {@link String#valueOf(Object)}. Arguments can be null.
     */
    // VisibleForTesting
    static String format(String template, Object... args) {
        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(
                template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append("]");
        }

        return builder.toString();
    }
}
