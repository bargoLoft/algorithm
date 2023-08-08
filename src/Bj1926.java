import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 그림
public class Bj1926 {

    static class ij{
        int i;
        int j;

        ij(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] b = new int[n][m];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int picture = 0;
        int max = 0;
        for(int i= 0;i<n;i++){
            for(int j=0;j<m;j++){
                Queue<ij> q = new ArrayDeque<>();
                int cnt = 0;
                if(b[i][j]==1){
                    b[i][j] = 0;
                    cnt = 1;
                    picture++;
                    q.add(new ij(i,j));
                }
                while(!q.isEmpty()){
                    int ci = q.peek().i;
                    int cj = q.peek().j;
                    for(int k=0;k<4;k++){
                        if(ci+dx[k]<0||ci+dx[k]>=n||cj+dy[k]<0||cj+dy[k]>=m)
                            continue;
                        if(b[ci+dx[k]][cj+dy[k]]==1){
                            b[ci+dx[k]][cj+dy[k]] = 0;
                            cnt++;
                            q.add(new ij(ci+dx[k],cj+dy[k]));
                        }
                    }
                    q.poll();
                }
                if(cnt > max) max = cnt;
            }
        }
        System.out.println(picture);
        System.out.println(max);


    }
}
