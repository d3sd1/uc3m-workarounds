package utils;

import java.security.SecureRandom;
import java.util.Random;

public class Common
{

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String SPECIAL_CHARS_STRING = "*^?!()/";

    public static String randomAlphaNumeric(int securityLevel)
    {
        int count = 10;
        boolean useSpecialChars = false;
        switch(securityLevel)
        {
            case 0:
                count = 0;
            break;
            case 1:
                count = 3;
            break;
            case 2:
                count = 5;
            break;
            case 3:
                count = 8;
            break;
            case 4:
                count = 15;
            break;
            case 5:
                count = 20;
            break;
            case 6:
                count = 25;
            break;
            case 7:
                count = 35;
            break;
            case 8:
                count = 50;
                useSpecialChars = true;
            break;
            case 9:
                count = 75;
                useSpecialChars = true;
            break;
            case 10:
                count = 100;
                useSpecialChars = true;
            break;
        }
        StringBuilder builder = new StringBuilder();
        Random r = new SecureRandom();
        String stringChars = ALPHA_NUMERIC_STRING + (useSpecialChars ? SPECIAL_CHARS_STRING:"");
        while (count-- != 0)
        {
            int character = (int) (r.nextInt(stringChars.length()));
            builder.append(stringChars.charAt(character));
        }
        return builder.toString();
    }
}
