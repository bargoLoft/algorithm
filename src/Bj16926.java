import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] b = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int rot=0;rot<r;rot++){
            // n,m 중에 작은 수 / 2 만큼 돌려야 할 둘레 개수가 나옴.
            for(int cnt=0;cnt<Math.min(n,m) / 2;cnt++){
                int cx = cnt;
                int cy = cnt;
                int cxy = b[cx][cy];
                // 오른쪽꺼 땡겨오기
                for(int i=0;i<m-1-cnt*2;i++){
                    b[cx][cy] = b[cx][cy+1];
                    cy++;
                }
                // 아래
                for(int i=0;i<n-1-cnt*2;i++){
                    b[cx][cy] = b[cx+1][cy];
                    cx++;
                }
                // 왼쪽
                for(int i=0;i<m-1-cnt*2;i++){
                    b[cx][cy] = b[cx][cy-1];
                    cy--;
                }
                // 위
                for(int i=0;i<n-1-cnt*2;i++){
                    b[cx][cy] = b[cx-1][cy];
                    cx--;
                }
                b[cx+1][cy] = cxy;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}
