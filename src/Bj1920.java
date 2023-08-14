import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 수 찾기.
public class Bj1920 {

    private static int isContain(int[] arr,int N, int target) {
        int start = 0;
        int end = N-1;
        int mid;
        while(start<=end){
            mid = (start+end) / 2;

            if(arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid -1;
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int B[] = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for(int i=0;i<M;i++){
            if(isContain(A,N,B[i]) == -1){
                System.out.println('0');
            } else{
                System.out.println('1');
            }
        }

    }


}
