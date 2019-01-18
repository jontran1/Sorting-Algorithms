import java.security.SecureRandom;
import java.util.Arrays;

public class CountingSort {
    public static void main(String args[]){
        SecureRandom random = new SecureRandom();
        int size = 50;
        int [] data = new int [size];
        for(int i = 0; i < size; i++){
            int randomnumber = random.nextInt(size);
            data[i] = randomnumber;
        }
        System.out.println(Arrays.toString(data));
        int max = getMax(data);
        final long startTime = System.nanoTime();
        countingSort(data,max);
        final long duration = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(data));
        System.out.println(duration);
    }

    public static int getMax(int [] data){
        int key = data[0];
        for(int i = 1; i < data.length; i++){
            if(data[i]>key){
                key = data[i];
            }
        }
        return key;
    }

    public static void countingSort(int [] data, int max){
        int k = max+1;
        int newdata[] = new int[data.length];
        int count[] = new int[k];
        for(int i = 0; i < data.length; i++){
            count[data[i]]++;
        }
        for(int i = 1; i < k; i ++){
            count[i]+=count[i-1];
        }
        for(int i = data.length-1; i >= 0; i--){
            newdata[count[data[i]]-1] = data[i];
            count[data[i]]= count[data[i]]-1;
        }
        for(int i = 0 ; i < newdata.length;i++){
            data[i] = newdata[i];
        }
    }
}
