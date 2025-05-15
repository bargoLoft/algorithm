package 분할정복_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// Z
// 4진수 다루기.
// 분할 정복.
public class Bj1074 {
    static int quaternary[];
    static int N;
    static void makeSpace(int dep,int ci, int cj, int size){
        if(dep == N){
            int ans = 0;
            int quarter = 1;
            for(int i=N-1;i>=0;i--){
                ans+=quaternary[i]*quarter;
                quarter*=4;
            }
            System.out.println(ans);
            return;
        }
        int half = size / 2;
        if(ci < half){
            if(cj < half){
                quaternary[dep] = 0;
                makeSpace(dep+1,ci,cj,half);
            } else{
                quaternary[dep] = 1;
                makeSpace(dep+1,ci,cj%half,half);
            }
        } else{
            if(cj < half){
                quaternary[dep] = 2;
                makeSpace(dep+1,ci%half,cj,half);
            } else{
                quaternary[dep] = 3;
                makeSpace(dep+1,ci%half,cj%half,half);
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

        makeSpace(0,r,c,1<<N);
    }
}
