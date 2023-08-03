import java.util.Scanner;

// 파리퇴치
public class Swea2001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            // N * N 배열 생성
            int[][] arr = new int[N][N];

            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            // 가로,세로로 N-M+1 만큼의 이동횟수를 갖는다.
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = 0;
                    //가로,세로로 i부터 i+M-1 까지의 합을 모두 더한다.
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += arr[k][l];
                        }
                    }
                    // 그 합이 max 값보다 크다면 대입한다.
                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            System.out.printf("#%d %d\n", t, max);
        }

        scanner.close(); // scanner 닫아주기.
    }
}
