import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 탈출
// 고슴도치 먼저 움직
// 문제 잘 읽기. 꼼꼼히
public class Bj3055 {
    static class Mob {
        int x;
        int y;
        int time;
        String type;

        public Mob(int x, int y, int time, String type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        int[][] isVisited = new int[R][C];
        int[] goal = new int[2];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Mob> q = new ArrayDeque();

        // 입력
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new Mob(i, j, 0, "Dochi"));
                    isVisited[i][j] = 1;
                } else if (map[i][j] == 'D') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    q.add(new Mob(i, j, 0, "Water"));
                }
            }
        }

        int clear = 0;

        while (!q.isEmpty()) {
            Mob h = q.poll();

            if (h.type == "Dochi") {
                if (map[h.x][h.y] == '*') continue;
                if (h.x == goal[0] && h.y == goal[1]) {
                    System.out.println(h.time);
                    clear = 1;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = h.x + dx[d];
                    int ny = h.y + dy[d];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (isVisited[nx][ny] == 1) continue;

                    if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
                        isVisited[nx][ny] = 1;
                        q.add(new Mob(nx, ny, h.time + 1, "Dochi"));
                    }
                }
            } else if (h.type == "Water") {
                for (int d = 0; d < 4; d++) {
                    int nx = h.x + dx[d];
                    int ny = h.y + dy[d];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                    if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        q.add(new Mob(nx, ny, h.time + 1, "Water"));
                    }
                }
            }
        }

        if (clear == 0) System.out.println("KAKTUS");
    }
}