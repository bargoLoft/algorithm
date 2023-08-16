import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] train = new int[N][20];

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 1){
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                train[i-1][x-1] = 1;
            } else if(command == 2){
                int i = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                train[i-1][x-1] = 0;
            } else if(command == 3){
                int i = Integer.parseInt(st.nextToken());
                for(int s=19;s>=0;s--){
                    train[i-1][s] = 0;
                    if(s!=19) train[i-1][s+1] = 1;
                }
            } else if(command == 4){
                int i = Integer.parseInt(st.nextToken());
                for(int s=0;s<20;s++){
                    train[i-1][s] = 0;
                    if(s!=0) train[i-1][s-1] = 1;
                }
            }
        }
    }
}
