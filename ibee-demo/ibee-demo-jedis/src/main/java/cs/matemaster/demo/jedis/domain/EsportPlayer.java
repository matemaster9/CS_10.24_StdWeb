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
        player.setName(Math.abs(RANDOM.nextLong()));
        player.setAge(RANDOM.nextInt(16, 24));
        return player;
    }
}
