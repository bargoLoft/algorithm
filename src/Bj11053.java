import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열.
// 이분탐색 + DP
public class Bj11053 {
    static int[] dp;
    static int binarySearch(int str,int end, int target){
        if(end<str) return str;

        int mid = (str+end) / 2;

        if(target <= dp[mid]){
            return binarySearch(str,mid-1,target);
        } else{
            return binarySearch(mid+1,end,target);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int[] arr = new int[A];
        dp = new int[A+1];

        st =new StringTokenizer(br.readLine());
        for(int i=0;i<A;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        for(int i=0;i<A;i++){
            int insert = binarySearch(0,len,arr[i]);
            if(insert>len) len++;
            dp[insert] = arr[i];
        }

        int cnt =0;
        for(int i=0;i<A;i++){
            //System.out.println(dp[i]);
            if(dp[i]!=0) cnt++;
        }

        System.out.println(len);
    }
}