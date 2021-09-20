package pgoc.f4e.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {

    public static String getUniqueId() {
        String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String NUM = "1234567890";
        String SPECIAL = "#%&";
        return RandomStringUtils.random(9, ALPHA + NUM + SPECIAL);
    }
}
