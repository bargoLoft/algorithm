import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[9];
        int sum = 0;
        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }

        for(int i=8;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        sum-=100;

        loop: for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                if(arr[i]+arr[j]==sum){
                    for(int k=0;k<9;k++){
                        if(k!=i&&k!=j){
                            System.out.println(arr[k]);
                        }

                    }
                    break loop;
                }
            }
        }

    }
}
