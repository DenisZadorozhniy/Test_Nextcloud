package utils;

import net.moznion.random.string.RandomStringGenerator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String generateRandomWord(int length) {
        RandomStringGenerator generator = new RandomStringGenerator();
        return generator.generateByRegex("[a-zA-Z]{" + length + "}");
    }

    public static String extractTextBeforeDotOrColon(String text) {
        String[] parts = text.split("[.:]", 2);
        return parts[0];
    }

    public static Integer getLastNumber(String inputString) {
        Matcher matcher = Pattern.compile("\\d+").matcher(inputString);
        Integer lastNumber = null;

        while (matcher.find()) {
            lastNumber = Integer.parseInt(matcher.group());
        }

        return lastNumber;
    }

    public static String removeTrailingSpaces(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int endIndex = str.length() - 1;
        while (endIndex >= 0 && Character.isWhitespace(str.charAt(endIndex))) {
            endIndex--;
        }
        return str.substring(0, endIndex + 1);
    }
}
