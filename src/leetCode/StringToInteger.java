package leetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {

    public int myAtoi(String str) {
        return stringToInteger(str);
    }

    private int stringToInteger(String str) {
       return 1;
    }


//    private int stringToInteger(String str) {
//        String trimString = str.trim();
//
//        String regex = "^[+-]?[0-9]+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(trimString);
//
//        if (matcher.find()) {
//            return getInteger(trimString, matcher);
//        }
//
//        return 0;
//    }
//
//    private int getInteger(String source, Matcher matcher) {
//        int integer = 0;
//
//        try {
//            integer = Integer.parseInt(matcher.group());
//        }
//        catch (NumberFormatException e) {
//            if (source.startsWith("-")) {
//                integer = Integer.MIN_VALUE;
//            }
//            else {
//                integer = Integer.MAX_VALUE;
//            }
//        }
//
//        return integer;
//    }
}
