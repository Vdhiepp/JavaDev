import java.util.Arrays;

public class Cau2 {
    public static int[] DaoCach1(int[] arr){
        int[] mangMoi = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            mangMoi[i] = arr[arr.length -(1+i)];
        }
        return mangMoi;
    }
    public static void DaoCach2(int[] arr){
        int a = 0;
        int b = arr.length - 1;
        int tam = 0;
        while (a<b){
            tam = arr[a];
            arr[a] = arr[b];
            arr[b] = tam;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        int[] mang = {1,2,3,4,5,6,7,8,9};
        int[] daocach1 = DaoCach1(mang);
        System.out.println("Dãy đã dảo ngược theo cách 1: " + Arrays.toString(daocach1));
        DaoCach2(mang);
        System.out.println("Dãy đã dảo ngược theo cách 2: " + Arrays.toString(mang));
    }
}
