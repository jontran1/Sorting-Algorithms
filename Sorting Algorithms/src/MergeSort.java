import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSort {
     public static void main(String args[]){
        SecureRandom randomNumber = new SecureRandom();
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
         MergeSort(data,low,high);
         final long duration = System.nanoTime() - startTime;
         System.out.println(Arrays.toString(data));
         System.out.println(duration);

    }
    public static void MergeSort(int [] data, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            MergeSort(data,low,mid);
            MergeSort(data,mid+1,high);
            Merge(data,low,mid,high);
        }
    }
    public static void Merge(int [] data, int low, int mid, int high){
        int left = mid-low+1;
        int right = high-mid;
        int Left[] = new int[left+1];
        int Right[] = new int[right+1];
        for(int i = 0; i <  left; i++){
            Left[i] = data[low+i];
        }
        for(int i = 0; i < right; i++){
            Right[i] = data[mid+i+1];
        }
        Left[left] = Integer.MAX_VALUE;
        Right[right] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for(int k = low; k <= high; k++){
            if(Left[i]<Right[j]){
                data[k] = Left[i];
                i++;
            }else{
                data[k] = Right[j];
                j++;
            }
        }
    }
}
