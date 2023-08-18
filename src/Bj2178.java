import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 미로탐색.
public class Bj2178 {
    static class Node{
        int i;
        int j;
        int move;

        public Node(int i, int j,int move) {
            this.i = i;
            this.j = j;
            this.move = move;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        int[][] isVisited = new int[N][M];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0 ;j<M;j++){
                 maze[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(0,0,1));
        isVisited[0][0] = 1;

        while(!q.isEmpty()){
            Node c = q.poll();
            if(c.i == N-1 && c.j == M-1){
                System.out.println(c.move);
                break;
            }
            for(int i=0;i<4;i++){
                int ni = c.i+dx[i];
                int nj = c.j+dy[i];
                if(ni<0||ni>=N||nj<0||nj>=M)
                    continue;
                if(maze[ni][nj] == 1 && isVisited[ni][nj] == 0) {
                    isVisited[ni][nj] = 1;
                    q.offer(new Node(ni, nj,c.move+1));
                }
            }
        }
    }
}
