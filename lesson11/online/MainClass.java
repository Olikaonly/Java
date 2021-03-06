package lesson11.online;

/**
 * Created by Olga Shestakova
 * Date 12.06.2021
 */
public class MainClass {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println(Thread.currentThread().getName());
        System.out.println("One thread time: " + (System.currentTimeMillis() - a) + " ms.");
    }

    public void runTwoThreads() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        Thread thread = new Thread(() -> {
            float[] a1 = calculate(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);

                System.out.println(Thread.currentThread().getName());
                System.out.println("Thread time: " + (System.currentTimeMillis() - a) + " ms.");

        });
        thread.start();
        // не получилось сделать thread.join(); не поняла как верно обработать исключение


        Thread thread1 = new Thread(() -> {
           float[] a2 = calculate(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
                System.out.println(Thread.currentThread().getName());
            System.out.println("Thread1 time: " + (System.currentTimeMillis() - a) + " ms.");
        });
        thread1.start();
        // не получилось сделать thread.join(); не поняла как верно обработать исключение

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - a) + " ms.");
    }

    public static void main(String[] args){
        MainClass o = new MainClass();
        o.runOneThread();

        System.out.println("*******");

        o.runTwoThreads();

    }
}
