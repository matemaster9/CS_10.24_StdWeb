package cs.matemaster.demo.jackson;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * @author matemaster
 */
public class SuffixLineNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    @Override
    public String translate(String s) {
        return s + "_";
    }
}
