package lesson03.online;

import java.util.Arrays;

public class HomeWorkApp03 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0, 1};
        invertArray(arr);

        int[] arr2 = new int[100];
        fillArray(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        changeArray(arr3);
        System.out.println(Arrays.toString(arr3));

        int[][] arr4 = new int[4][4];
        fillDiagonal(arr4);

        int[] returnArrayMethod = returnArray(5, 9);
        System.out.println(Arrays.toString(returnArrayMethod));

        int[] arr5 = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        System.out.println("Minimum " + minMax(arr5));
        System.out.println("Maximum " + maxMin(arr5));
    }

    public static void invertArray (int[] arr) {
        int mass = arr.length;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 1) {
                    arr[i] = 0;
            } else {
                    arr[i] = 1;
                }
        for (int i = 0; i < mass; i++) {
                System.out.println(i + "-" + arr[i] + " ");
            }
        }
    public static void fillArray(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
    }
    public static void changeArray(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
    }
    public static void fillDiagonal(int[][]arr4) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < j) {
                    arr4[i][j] = 0;
                } else if (i > j) {
                    arr4[i][j] = 0;
                } else {
                    arr4[i][j] = 1;
                }
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] returnArray(int len, int initValue) {
        int[] tempArray = new int[len];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = initValue;
        }

        return tempArray;
    }
    public static int minMax(int [] arr5){
        int min = arr5[0];
        for (int index : arr5)
            if (index < min) {
                min = index;
            }
        return min;

    }
    public static int maxMin(int [] arr5){
        int max = arr5[0];
        for (int index : arr5)
            if (index > max) {
                max = index;
            }
        return max;

    }

}



