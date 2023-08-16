import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj6987 {
    static int[][] result;
    static int[][] team;
    static final int N = 6;
    private static void match(int dep,int a, int b){
        if(dep ==6){
            return;
        }

        for(int i=0;i<2;i++){
                team[a][2-i]++;
                team[b][2-i]++;
                if(b==N-1){
                    match(dep+1,a+1,a+2);
                } else{
                    match(dep+1,a,b+1);
                }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=0;t<4;t++){
            result = new int[6][3];
            int valid = 1;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++){
                for(int j=0;j<3;j++){
                    result[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            team = new int[6][3];
            match(0,0,0);

        }
    }
}
