package level1.programmers;

import java.util.Arrays;

public class FindKim {

    public String solution(String[] seoul) {
        int location = getKimLocation(seoul);
        return "김서방은 " + location + "에 있다";
    }

    private int getKimLocation(String[] seoul) {
        return Arrays.asList(seoul).indexOf("Kim");
    }

//    private int findKimLocation(String[] seoul) {
//        int location = -1;
//
//        for (int i = 0; i < seoul.length; ++i) {
//            if (seoul[i].equals("Kim")) {
//                location = i;
//                break;
//            }
//        }
//
//        return location;
//    }

}
