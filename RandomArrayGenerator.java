import java.util.Scanner;

public class RandomArrayGenerator {

    public static String[] generateRandomArray(int size) {
        String[] strings = new String[size];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = generateRandomString();
        }
        return strings;
    }

    public static String generateRandomString() {
        String randomString = "";
        for (int j = 0; j < 4; j++) {
            long num = System.currentTimeMillis() % 10;
            randomString += num;
        }
        for (int k = 0; k < 3; k++) {
            long num = (System.currentTimeMillis() % 26) + 97;
            char ch = (char) num;
            randomString += ch;
        }
        for (int m = 0; m < 3; m++) {
            long num = System.currentTimeMillis() % 10;
            randomString += num;
        }
        return randomString;
    }

    public static int method1(String[] array) {
    int newCount = 0;
        for (String str : array) {
            int h = Character.getNumericValue(str.charAt(7));
            int t = Character.getNumericValue(str.charAt(8));
            int u = Character.getNumericValue(str.charAt(9));
            int num = (100 * h) + (10 * t) + u;
            if (num <= 50) {
                newCount++;
            }
        }
        return newCount;
    }
        

    public static int method2(String[] array) {
    int count = 0;
        for (String str : array) {
            int num = Integer.parseInt(str.substring(7, 10));
            if (num <= 50) {
                count++;
            }
        }
        return count;
    }
        

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array100 = generateRandomArray(100);
        String[] array500 = generateRandomArray(500);
        String[] array1000 = generateRandomArray(1000);

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        method1(array100);
        endTime = System.currentTimeMillis();
        long timeMethod1Array100 = endTime - startTime;

        startTime = System.currentTimeMillis();
        method2(array100);
        endTime = System.currentTimeMillis();
        long timeMethod2Array100 = endTime - startTime;

        startTime = System.currentTimeMillis();
        method1(array500);
        endTime = System.currentTimeMillis();
        long timeMethod1Array500 = endTime - startTime;

        startTime = System.currentTimeMillis();
        method2(array500);
        endTime = System.currentTimeMillis();
        long timeMethod2Array500 = endTime - startTime;

        startTime = System.currentTimeMillis();
        method1(array1000);
        endTime = System.currentTimeMillis();
        long timeMethod1Array1000 = endTime - startTime;

        startTime = System.currentTimeMillis();
        method2(array1000);
        endTime = System.currentTimeMillis();
        long timeMethod2Array1000 = endTime - startTime;

        System.out.println("Approach\\Size\t100\t500\t1000");
        System.out.println();
        System.out.println("Method 1\t" + timeMethod1Array100 + "\t" + timeMethod1Array500 + "\t" + timeMethod1Array1000);
        System.out.println();
        System.out.println("Method 2\t" + timeMethod2Array100 + "\t" + timeMethod2Array500 + "\t" + timeMethod2Array1000);
    }
}

