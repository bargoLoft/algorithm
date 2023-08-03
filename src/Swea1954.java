import java.util.Scanner;

public class Swea1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[12][12];

            final int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int dir = 0;

            int x = 1, y = 1;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = -1;
                }
            }

            for (int i = 1; i <= N * N; i++) {
                arr[x][y] = i;

                if (arr[x + move[dir][0]][y + move[dir][1]] != -1) {
                    dir++;
                    if (dir == 4)
                        dir = 0;
                }
                x += move[dir][0];
                y += move[dir][1];
            }

            System.out.println("#" + t);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}