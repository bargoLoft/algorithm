import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 봄버맨
//0 초기.
//1 아무것도 안 함.
//2 설치함.
//3 터짐.
//4 설치
//5 터짐..
//
public class Bj16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                int tmp = s.charAt(j);
                if(tmp == 'O') tmp = 0;
                map[i][j] = tmp;
            }
        }
// 3 5 7 9 11 13
        if(N%2 == 0){
            N = 2;
        } else if(N>6) {
            if((N/2)%2 == 1) N = 3;
            else N = 5;
        }

        for(int t=2;t<=N;t++){
            if(t%2 == 0){
                for(int i=0;i<R;i++){
                    for(int j=0;j<C;j++){
                        if(map[i][j] == '.') map[i][j] = t;
                    }
                }
            }

            if(t%2 == 1){
                for(int i=0;i<R;i++){
                    for(int j=0;j<C;j++){
                        if(map[i][j] + 3 == t){
                            map[i][j] = '.';
                            for(int d=0;d<4;d++){
                                int nx = i+dx[d];
                                int ny = j+dy[d];
                                if(nx<0||nx>=R||ny<0||ny>=C) continue;
                                if(map[nx][ny] == t - 3) continue;
                                map[i+dx[d]][j+dy[d]] = '.';
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
               if(map[i][j]!='.') map[i][j] = 'O';
                System.out.printf("%c",map[i][j]);
            }
            System.out.println();
        }



    }
}
