import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 숫자 카드
public class Bj10815 {
    private static int binarySearch(int arr[],int target, int N){
        int start = 0;
        int end = N-1;
        int mid;

        while(start<=end){
            mid = (start + end) / 2;

            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] > target){
                end = mid -1;
            } else{
                start = mid +1;
            }
        }
        return -1;
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] Card = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            Card[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] searchCard = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            searchCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Card);

        for(int i=0;i<M;i++){
            if(binarySearch(Card,searchCard[i],N) == -1){
                System.out.println('0');
            } else{
                System.out.println('1');
            }
        }


    }
}
