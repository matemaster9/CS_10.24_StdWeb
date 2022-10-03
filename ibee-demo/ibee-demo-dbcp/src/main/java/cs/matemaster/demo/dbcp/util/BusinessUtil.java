package cs.matemaster.demo.dbcp.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public final class BusinessUtil {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static String ALPHA_NUMBER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private BusinessUtil() {
    }

    public static String generateUniqueCode(String prefix) {

        StringBuilder uniqueCode = new StringBuilder(16);
        uniqueCode.append(prefix);
        uniqueCode.append(RANDOM.nextInt(100_000_000, 999_999_999));
        for (int i = 0; i < 4; i++) {
            uniqueCode.append(ALPHA_NUMBER.charAt(RANDOM.nextInt(ALPHA_NUMBER.length())));
        }
        return uniqueCode.toString();
    }
}
