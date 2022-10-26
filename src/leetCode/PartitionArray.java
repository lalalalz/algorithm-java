package leetCode;

class PartitionArray {
    public boolean canThreePartsEqualSum(int[] arr) {
        long sum = getSumOfArray(arr);
        return doThreeParts(arr, sum);
    }

    private long getSumOfArray(int[] arr) {
        long sum = 0;

        for (int number : arr) {
            sum += number;
        }

        return sum;
    }

    private boolean doThreeParts(int[] arr, long sum) {
        int index = 0;
        long sumOfParts = 0;
        long oneThird = sum / 3;

        if(sum % 3 > 0) return false;

        for (int number : arr) {
            sumOfParts += number;

            if (index < 3 && sumOfParts == oneThird) {
                sumOfParts = 0;
                index++;
            }
        }

        return index == 3 && sumOfParts == 0;
    }
}