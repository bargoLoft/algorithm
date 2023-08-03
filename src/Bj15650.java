import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bj15650 {
    static int[] arr;
    static int[] isUsed;
    static int[] numbers;
    static int[] isUsedNumbers;
    static StringBuilder sb = new StringBuilder();


    static void nPm(int N,int M,int dep){
        if(dep==M){
            for(int n: arr){
                sb.append(n+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(i>0 &&numbers[i-1]==numbers[i])
                continue;
//            if(isUsed[i]<isUsedNumbers[numbers[i]-1]){
                arr[dep] = numbers[i];
                if(dep!=0&&(arr[dep-1]>arr[dep]))
                    continue;
//                isUsed[i]++;
                nPm(N,M,dep+1);
//                isUsed[i]--;
//            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        isUsed = new int[N];
        arr = new int[M];
        numbers = new int[N];
        isUsedNumbers = new int[10001];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt( st.nextToken());
            isUsedNumbers[numbers[i]-1]++;
        }

        for(int i=0;i<N-1;i++){
            for(int j=i;j<N;j++){
                if(numbers[i]>numbers[j]){
                    int tmp=numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }


        nPm(N,M,0);
        System.out.println(sb);
    }
}
