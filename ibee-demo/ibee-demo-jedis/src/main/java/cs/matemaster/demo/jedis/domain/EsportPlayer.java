package cs.matemaster.demo.jedis.domain;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
@Data
public class EsportPlayer {

    private Long name;

    private Integer age;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static EsportPlayer mock() {
        EsportPlayer player = new EsportPlayer();
        player.setName(Math.abs(RANDOM.nextLong(1_000_000,9_999_999)));
        player.setAge(RANDOM.nextInt(16, 24));
        return player;
    }
}
