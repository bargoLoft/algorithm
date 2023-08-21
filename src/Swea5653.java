import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄기세포 배양.
public class Swea5653 {
    static class Cell implements Comparable<Cell>{
        int x;
        int y;
        int maxHP;
        int hp;
        int condition;

        public Cell(int x, int y, int maxHP, int hp, int condition) {
            this.x = x;
            this.y = y;
            this.maxHP = maxHP;
            this.hp = hp;
            this.condition = condition;
        }

        @Override
        public int compareTo(Cell target) {
            //target 이 어떤 대우를 받느냐?
            //타켓이 클 때(==큰 순서대로 뽑기) 양수 리턴.
            return this.maxHP <= target.hp ? 1:-1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Cell[][] map = new Cell[N][M];

            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};

            PriorityQueue<Cell> q = new PriorityQueue<>(Collections.reverseOrder());

            // 초기 세팅.
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp != 0){
                        map[i][j] = new Cell(i,j,tmp,tmp,2);
                        // 초기 세팅 세포들 전부 큐에 삽입.
                        q.offer(map[i][j]);
                    } else{
                        map[i][j] = new Cell(i,j,-1,-1,-1);
                    }
                }
            }

            // for문 속 for문? 배양시간이 정해져 있다. 현재 큐 크기만큼만 한 사이클씩 돌려준다.
            for(int i=0;i<K;i++){
                int qSize = q.size();
                for(int j=0;j<qSize;j++){
                    Cell c = q.poll(); // compareTo에 의해 높은 생명력 바이러스 부터 출력.

                    c.hp--; // 수명 줄고.
                    map[c.x][c.y].hp--; // 맵에 친구도 줄여 줌.

                    if(c.hp == 0){
                        // 비활성 상태 종료
                        if(c.condition == 2){
                            // 4방위 탐색 후. 전파.
                            for(int d=0;d<4;d++){
                                int nx = c.x+dx[d];
                                int ny = c.y+dy[d];
                                if(nx<0 || nx>=N || ny<0 || ny>=M){
                                    continue;
                                }
                                // 셀이 비어 있다면
                                if(map[nx][ny].maxHP!=-1){
                                    // 새로운 세포 복제.
                                    Cell newCell = new Cell(nx,ny,c.maxHP,c.maxHP,2);
                                    map[nx][ny] = newCell;
                                    q.offer(newCell);
                                }
                            }
                            c.condition = 1;
                            map[c.x][c.y].condition = 1;
                            q.offer(c);
                        }
                        // 활성 상태 종료.
                        else if(c.condition==1){
                            map[c.x][c.y].condition = 0;
                            c.condition = 0; // 꽥.
                        }
                    } else{
                        // 도로 넣어 준다.
                        q.offer(c);
                    }

                }
            }
        }
    }
}
