package cs.matemaster.common;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.digests.SM3Digest;

import java.nio.charset.StandardCharsets;

/**
 * 国秘算法
 *
 * @author matemaster
 */
public final class GMUtil {

    private GMUtil() {
    }

    public static String sm3(String plaintext) {
        return StringUtils.isBlank(plaintext) ? null : sm3(plaintext.getBytes(StandardCharsets.UTF_8));
    }

    public static String sm3(byte[] plaintext) {
        if (ArrayUtil.isNotEmpty(plaintext)) {
            byte[] ciphertext = new byte[32];
            SM3Digest sm3Digest = new SM3Digest();
            sm3Digest.update(plaintext, 0, plaintext.length);
            sm3Digest.doFinal(ciphertext, 0);
            sm3Digest.reset();
            return Hex.encodeHexString(ciphertext);
        }
        return null;
    }
}
