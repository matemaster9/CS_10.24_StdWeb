package cs.matemaster.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
public final class BusinessUtil {

    private BusinessUtil() {
    }

    public static final ThreadLocalRandom StdRandom = ThreadLocalRandom.current();
    private static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String getBizCode(String prefix) {
        StringBuilder builder = new StringBuilder(24);
        builder.append(prefix);
        builder.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
        for (int i = 0; i < 4; i++) {
            builder.append(Alphabet.charAt(StdRandom.nextInt(0, Alphabet.length())));
        }
        return builder.toString();
    }
}
