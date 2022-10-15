package cs.matemaster.tech.redis.domain;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
@Data
public class SystemUserDto {

    private String code;

    private String password;

    private static final String ALPHA_NUMBER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final ThreadLocalRandom THREAD_RANDOM = ThreadLocalRandom.current();

    public static SystemUserDto mock() {
        StringBuilder strBuilder = new StringBuilder(16);
        for (int i = 0; i < 10; i++) {
            strBuilder.append(ALPHA_NUMBER.charAt(THREAD_RANDOM.nextInt(ALPHA_NUMBER.length())));
        }
        SystemUserDto dto = new SystemUserDto();
        dto.setCode(strBuilder.toString());
        dto.setPassword(strBuilder.toString());
        return dto;
    }
}
