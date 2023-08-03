import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] arrSum = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0){
                arrSum[i] = arr[i];
            }
            else {
                arrSum[i] = arrSum[i - 1] + arr[i];
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            if(I==1){
                System.out.println(arrSum[J-1]);
            } else{
                System.out.println(arrSum[J-1]-arrSum[I-2]);
            }
        }
    }
}
