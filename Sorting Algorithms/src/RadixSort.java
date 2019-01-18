import java.security.SecureRandom;
import java.util.Arrays;

public class RadixSort {
    public static void main(String args[]){
        SecureRandom random = new SecureRandom();
        int size = 10;
        int data[] = new int[size];
        for(int i = 0 ; i < size; i++){
            int rand = random.nextInt(size);
            data[i] = rand;
        }
        System.out.println(Arrays.toString(data));
        int max = getMax(data);
        final long startTime = System.nanoTime();
        RadixSort(data,max);
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
    public static void counting(int[] data, int place){
        int count[] = new int[10];
        int newdata[] = new int[data.length];
        for(int i = 0; i < data.length; i ++){
            count[(data[i]/place)%10]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        for(int i = data.length-1; i >= 0; i--){
            newdata[count[(data[i]/place)%10]-1] = data[i];
            count[(data[i]/place)%10]--;
        }
        for(int i = 0; i < newdata.length; i++){
            data[i] = newdata[i];
        }
    }

    public static void RadixSort(int[] data, int max){
        for(int i = 1; max/i > 0; i*=10 ){
            counting(data,i);
        }
    }

}
