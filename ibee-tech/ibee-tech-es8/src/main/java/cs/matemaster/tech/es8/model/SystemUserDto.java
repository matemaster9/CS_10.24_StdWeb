package cs.matemaster.tech.es8.model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
@Data
public class SystemUserDto {

    private Long username;

    private String password;


    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final int LENGTH = 10;

    public static SystemUserDto mock() {
        StringBuilder passBuilder = new StringBuilder(18);
        for (int i = 0; i < LENGTH; i++) {
            passBuilder.append(ALPHABET.charAt(RANDOM.nextInt(0, ALPHABET.length())));
        }
        passBuilder.append(RANDOM.nextLong(10_000_000, 99_999_999));

        SystemUserDto dto = new SystemUserDto();
        dto.setUsername(RANDOM.nextLong(10_000_000, 99_999_999));
        dto.setPassword(passBuilder.toString());
        return dto;
    }
}
