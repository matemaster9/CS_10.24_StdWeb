package cs.matemaster.common;

/**
 * @author matemaster
 */
public final class BusinessUtil {

    private BusinessUtil() {
    }

    public static boolean isTrue(Boolean arg) {
        return Boolean.TRUE.equals(arg);
    }

    public static boolean isFalse(Boolean arg) {
        return Boolean.FALSE.equals(arg);
    }
}
