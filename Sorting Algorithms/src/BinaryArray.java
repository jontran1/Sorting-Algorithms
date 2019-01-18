import java.security.SecureRandom;
import java.util.Arrays;

public class BinaryArray {
    public static void main (String[] args){
        SecureRandom rand = new SecureRandom();
        int data[] = new int[10];
        for (int i = 0 ; i < data.length; i ++){
            int random = rand.nextInt(10);
            data[i] = random;
        }
        System.out.println(Arrays.toString(data));
        MergeSort(data,0,9);
        System.out.println(Arrays.toString(data));
        System.out.println(BinarySearch(data,18,0,9));
    }

    public static int BinarySearch(int[] data, int key, int low, int high){
        if (low > high)
            return -1;
        int mid = (low + high)/2;
        if ( key == data[mid]){
            return mid;
        }else if(key < data[mid]){
            return BinarySearch(data,key,low,mid-1);
        }else {
            return BinarySearch(data,key,mid+1,high);
        }
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
