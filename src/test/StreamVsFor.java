package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StreamVsFor {

    private int max = 500000;
    private int[] arr1 = new int[max];
    private List<Integer> arr2 = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        Random random = new Random();

        System.out.println("arr1.length = " + arr1.length);
        System.out.println("arr2.size() = " + arr2.size());
        
        for (int i = 0; i < max; i++) {
            arr1[i] = random.nextInt();
            arr2.add(random.nextInt());
        }
    }

    @Test
    void test1() {

        simpleForWithPrimitive();
        streamWithPrimitive();

    }

    @Test
    void test2() {

        simpleForWithWrapped2();
        streamWithWrapped2();

    }

    private int simpleForWithPrimitive() {
        int sum = Integer.MIN_VALUE;

        long start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            sum = sum > arr1[i] ? sum : arr1[i];
        }
        long end = System.currentTimeMillis();

        System.out.println("simpleForWithPrimitive : (end - start) = " + (end - start));
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);

        return sum;
    }

    private Integer streamWithPrimitive() {
        long start = System.currentTimeMillis();
        int max = Arrays.stream(arr1)
                .map(x -> x = (int)Math.random())
                .max()
                .getAsInt();

        long end = System.currentTimeMillis();


        System.out.println("streamWithPrimitive : (end - start) = " + (end - start));
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
        return max;
    }

    private int simpleForWithWrapped2() {
        int sum = Integer.MIN_VALUE;

        long start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            sum = sum > arr2.get(i) ? sum : arr2.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("simpleForWithPrimitive : (end - start) = " + (end - start));
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);

        return sum;
    }

    private Integer streamWithWrapped2() {
        long start = System.currentTimeMillis();
        int max = arr2.stream()
                .mapToInt(x -> x.intValue())
                .max()
                .getAsInt();

        long end = System.currentTimeMillis();


        System.out.println("streamWithPrimitive : (end - start) = " + (end - start));
//        System.out.println("start = " + start);
//        System.out.println("end = " + end);
        return max;
    }
}
