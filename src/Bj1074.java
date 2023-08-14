import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1074 {
    static int quaternary[];
    static int N;
    static void makeSpace(int dep,int ci, int cj, int size){
        if(dep == N){
            int ans = 0;
            for(int i=quaternary.length-1;i>=0;i--){
                ans*=4;
                ans+=quaternary[i];
            }
            System.out.println(ans);
        }
        int half = size / 2;
        if(ci < half){
            if(cj < half){
                quaternary[dep] = 0;
                makeSpace(dep+1,ci,cj,half);
            } else{
                quaternary[dep] = 1;
                makeSpace(dep+1,ci,cj+half,half);
            }
        } else{
            if(cj < half){
                quaternary[dep] = 2;
                makeSpace(dep+1,ci+half,cj,half);
            } else{
                quaternary[dep] = 3;
                makeSpace(dep+1,ci+half,cj+half,half);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        quaternary = new int[N];

        makeSpace(0,0,0,1<<N);
    }
}
