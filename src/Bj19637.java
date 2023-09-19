import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj19637 {
    static int binarySearch(int str, int end, int target){
        int mid = (str+end) / 2;

        //if(mid == target)
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] title = new String[N];
        int[] titleValue = new int[N];
        int[] power = new int[M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            titleValue[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            power[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<M;i++){
            binarySearch(0,N-1,power[i]);
        }
    }
}
