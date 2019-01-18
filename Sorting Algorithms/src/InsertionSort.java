import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]){
        SecureRandom randomNumber = new SecureRandom();
        int size = 10;
        int data[] = new int[size];
        for (int i = 0; i < size; i++) {
            int rand = randomNumber.nextInt(size);
            data[i] = rand;
        }
        System.out.println(Arrays.toString(data));
        final long startTime = System.nanoTime();
        insertionSort(data, size);
        final long duration = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(data));
        System.out.println(duration);
    }

    public static void insertionSort(int[] data, int size){
        for(int i = 1; i < size; i++){
            int key = data[i];
            int j = i-1;
            while(j >= 0 && data[j]>key){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }
    }
}
