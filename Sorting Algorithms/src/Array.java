import java.security.SecureRandom;
import java.util.Arrays;

//HEAP SORT
public class Array {
    private static SecureRandom randomNumber = new SecureRandom();
    private int size;
    private int data[];
    Array(int how_many){
        size = -1;
        data = new int[how_many];
        for(int i = 0 ; i < how_many; i++){
            int rand = randomNumber.nextInt(how_many);
            data[i] = rand;
            size++;
        }
    }
    public String toString(){
        return Arrays.toString(data);
    }
    public int Left(int i){
        return (2*i)+1;
    }
    public int Right(int i){
        return (2*i)+2;
    }
    public int heapsize(){
        return size;
    }
    public int heapsize(int i){
        return size-=i;
    }
    public int getData(int i){
        return data[i];
    }
    public void swap(int i, int largest){
        int temp = data[i];
        data[i] = data[largest];
        data[largest] = temp;
    }

    public static void main(String args[]){

        Array data = new Array(10);
        System.out.println(data);
        final long startTime = System.nanoTime();
        HeapSort(data);
        final long duration = System.nanoTime() - startTime;
        System.out.println(data);
        System.out.println(duration);

    }


    public static void Max_Heapify(Array data, int i) {
        int l = data.Left(i);
        int r = data.Right(i);
        int largest;
        if (l <= data.heapsize() && data.getData(l) > data.getData(i)) {
            largest = l;
        }else {
            largest = i;
        }
        if (r <= data.heapsize() && data.getData(r) > data.getData(largest)) {
            largest = r;
        }
        if (largest != i) {
            data.swap(i, largest);
            Max_Heapify(data, largest);
        }
    }
    public static void BuildHeap(Array data){
        int q = data.heapsize()/2;
        for(int i = q; i >= 0 ; i--){
            Max_Heapify(data,i);
        }
    }
    public static void HeapSort(Array data){
        BuildHeap(data);
        for(int i = data.heapsize(); i >= 1; i -- ){
            data.swap(0,data.heapsize());
            //Decrease heapsize by i. But this incase decrease by 1.
            data.heapsize(1);
            Max_Heapify(data,0);
        }
    }
}
