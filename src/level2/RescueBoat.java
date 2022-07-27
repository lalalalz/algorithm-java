package level2;

import java.util.Arrays;

public class RescueBoat {

    public int solution(int[] people, int limit) {
        sort(people);
        return getMinimumBoatNumber(people, limit);
    }

    public void sort(int[] people) {
        Arrays.sort(people);
    }

    private int getMinimumBoatNumber(int[] people, int limit) {
        int count = 0;
        int left  = 0;
        int right = people.length - 1;

        while (left <= right) {
            if(left == right) {
                count++;
                break;
            }

            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            }

            else {
                right--;
            }

            count++;
        }

        return count;
    }
}
