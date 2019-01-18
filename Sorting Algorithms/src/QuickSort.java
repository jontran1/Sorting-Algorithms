import java.security.SecureRandom;
import java.util.Arrays;

public class QuickSort {
    public static SecureRandom randomNumber = new SecureRandom();

    public static void main(String args[]){
        int size = 10;
        int low = 0;
        int high = size-1;
        int data[] = new int[size];
        for(int i = 0; i < size; i++){
            int rand = randomNumber.nextInt(size);
            data[i]=rand;
        }
        System.out.println(Arrays.toString(data));
        final long startTime = System.nanoTime();
        Random_QuickSort(data,low,high);
        final long duration = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(data));
        System.out.println(duration);
    }
    public static void QuickSort(int [] data, int low, int high){
        if(low < high){
            int pivot = partition(data,low,high);
            QuickSort(data,low,pivot - 1);
            QuickSort(data,pivot + 1,high);
        }
    }
    public static int partition(int [] data, int low, int high){
        int key = data[high];
        int j = low - 1;
        for(int i = low; i < high; i++){
            if(data[i] <= key){
                j++;
                int temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        data[high] = data[j+1];
        data[j+1] = key;
        return j+1;
    }

    public static void QuickSort_firstElement(int [] data, int low, int high){
        if(low < high){
            int pivot = partition_first(data,low,high);
            QuickSort_firstElement(data,low,pivot - 1);
            QuickSort_firstElement(data,pivot + 1,high);
        }
    }
    public static int partition_first(int [] data, int low, int high){
        int key = data[low];
        int j = low ;
        for(int i = low + 1; i <= high; i++){
            if(data[i] <= key){
                j++;
                int temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }
        data[low] = data[j];
        data[j] = key;
        return j;
    }
    public static void Random_QuickSort(int [] data, int low, int high){
        if(low < high){
            int rand = low + randomNumber.nextInt(high+1-low);
            int temp = data[rand];
            data[rand]=data[high];
            data[high] = temp;
            int pivot = partition(data,low,high);
            Random_QuickSort(data,low,pivot - 1);
            Random_QuickSort(data,pivot + 1,high);
        }
    }
    public static void Middle_QuickSort(int [] data, int low, int high){
        if(low < high){
            int mid = (high+low)/2;
            int temp = data[high];
            data[high] = data[mid];
            data[mid] = temp;
            int pivot = partition(data, low, high);
            Middle_QuickSort(data,low,pivot-1);
            Middle_QuickSort(data,pivot+1,high);
        }
    }
}