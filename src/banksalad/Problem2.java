package banksalad;

import java.util.HashMap;

public class Problem2 {

    public static void main(String[] args) {
        int arr1[] = {2, 7, 11, 15};
        int target1 = 9;

        getElementsIndex(arr1, target1);

        int arr2[] = {0, -1, 2, -3};
        int target2 = 9;

        getElementsIndex(arr2, target2);

        int arr3[] = {0, 0, 0, 0};
        int target3 = 9;

        getElementsIndex(arr3, target3);
    }

    public static void getElementsIndex(int arr[], int target) {
        int[] result = getResultVersion2(arr, target);

        if(result == null) {
            System.out.println("주어진 배열의 값으로는 target을 만들 수 없습니다.");
        }
        else {
            System.out.println("[" + result[0] + "," + result[1] + "]");
        }
    }

    public static int[] getResult(int[] arr, int target) {
        int[] result = new int[]{-1, -1};

        if(arr.length < 2) return null;

        for(int i = 0; i < arr.length; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if(arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        if(result[0] == -1 && result[1] == -1) return null;
        return result;
    }

    public static int[] getResultVersion2(int[] arr, int target) {
        int[] result = new int[]{-1, -1};
        HashMap<Integer, Integer> values = new HashMap<>();

        if(arr.length < 2) return null;

        generateHashMap(arr, values);

        for(int i = 0; i < arr.length; ++i) {
            if(values.containsKey(target - arr[i])) {
                result[0] = i;
                result[1] = values.get(target - arr[i]);
                break;
            }
        }

        if(result[0] == -1 && result[1] == -1) return null;
        return result;
    }

    public static void generateHashMap(int[] arr, HashMap<Integer, Integer> values) {
        for(int i = 0; i < arr.length; ++i) {
            values.put(arr[i], i);
        }
    }


}
