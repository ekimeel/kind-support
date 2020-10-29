package kind.support;

public class Nulls {
    private Nulls() {
    }

    /**
     * Checks if the given object is null, if so this method is
     * guaranteed to throw a <code>NullPointerException</code>
     *
     * @param aObject the objec to check
     * @throws NullPointerException guaranteed if given object is null
     */
    public static void failIfNull(Object aObject, String message) {
        if (aObject == null)
            throw new NullPointerException(message);
    }

    /**
     * Checks if the given object is null, if so this method is
     * guaranteed to throw a <code>NullPointerException</code>
     *
     * @param aObject the objec to check
     * @throws NullPointerException guaranteed if given object is null
     */
    public static void failIfNull(Object aObject) {
        failIfNull(aObject, "Object cannot be null");
    }

    /**
     * Checks if the given subject is null and replaces if so,
     * Otherwise the subject and replacement will remain unchanged.
     *
     * @param subject     the object to replace if null
     * @param replacement the replacement for the subject
     */
    public static void replaceIfNull(Object subject, Object replacement) {

        if (subject == null)
            subject = replacement;
    }

}
