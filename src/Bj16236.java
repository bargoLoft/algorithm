import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 아기상어
// Priority Queue
// static class Shark implements Comparable<Shark>{
//  ....
// @Override
// public int compareTo(Shark s){
//     if(this.time < s.time) return -1; 왼쪽보다 오른쪽이 크니 오름차순.
//     else if(this.time == s.time){  1차 판별이 같다면
//          if(this.x < s.x) return -1; 2차 판별까지. 여전히 오름차순 우선//
//     }
//     return 1;
// }
//}
public class Bj16236 {
    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int size;
        int exp;
        int time;

        public Shark(int x, int y, int size, int exp, int time) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.exp = exp;
            this.time = time;
        }

        @Override
        public int compareTo(Shark shark) {
            if (this.time < shark.time) return -1; // 시간이 빠른 순으로
            else if (this.time == shark.time) {
                if (this.x < shark.x) return -1; // x가 작은 순으로
                else if (this.x == shark.x) {
                    if (this.y < shark.y) return -1; // y가 작은 순으로
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] isVisited = new int[N][N];

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        PriorityQueue<Shark> pq = new PriorityQueue<>();

        int lastEatTime = 0;

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    pq.add(new Shark(i, j, 2, 0, 0));
                    map[i][j] = 0;
                    isVisited[i][j] = 1;
                }
            }
        }

        while (!pq.isEmpty()) {
            Shark s = pq.poll();
            int fish = map[s.x][s.y];

            if (fish != 0 && fish < s.size) {
                s.exp += 1;
                map[s.x][s.y] = 0;
                lastEatTime = s.time;
                pq.clear();
                isVisited = new int[N][N];
                isVisited[s.x][s.y] = 1;

                if (s.size == s.exp) {
                    s.size += 1;
                    s.exp = 0;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nx = s.x + dx[d];
                int ny = s.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (isVisited[nx][ny] == 1) continue;

                fish = map[nx][ny];
                if (fish > s.size) continue;

                isVisited[nx][ny] = 1;
                pq.add(new Shark(nx, ny, s.size, s.exp, s.time + 1));
            }
        }

        System.out.println(lastEatTime);
    }
}


// 아기 상어 크기 2(초기)
// 자기보다 큰 물고기는 못 지나감.
// 자기보다 같거나 작은 물고기는 갈 수 있지만 같은 물고기는 못 먹음.

// 더 이상 먹을 수 있는 물고기가 공간에 없으면 GG
// 먹을 수 있는 물고기가 1마리 보다 많다면 가까운 물고기 먹으러 감.
// 거리가 같은면 좌상단 부터 먹으러 감. -> Priority Queue로..
// 자기 크기만큼 물고기를 먹으면 크기가 1 증가.

// 계속 탐색. 먹을 수 있는 물고기로 감. 다시 탐색.