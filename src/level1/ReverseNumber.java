package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseNumber {

    public int[] solution(long n) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

//    public int[] solution(long n) {
//
//        int[] intArray = Arrays.stream(String.valueOf(n).split(""))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        return reverseArray(intArray);
//    }
//
//    private int[] reverseArray(int[] intArray) {
//        int temp;
//        int left = 0;
//        int right = intArray.length - 1;
//
//        while (left < right) {
//            temp = intArray[left];
//            intArray[left] = intArray[right];
//            intArray[right] = temp;
//
//            left++;
//            right--;
//        }
//
//        return intArray;
//    }
}
