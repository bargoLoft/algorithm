import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회전 초밥.
// 투 포인터로 오른쪽으로 넓혀가다 중복되는 초밥을 만나면 왼쪽 포인터를 중복 이상으로 땡김
// 현재 목록 중 쿠폰 초밥이 없을 시 +1
// 연속되어 먹는 k개가 존재하므로 항상 k개씩 탐색.
// 아.. 연속해서 먹는 k개 초밥 중 중복이 있어도 OK, 종류가 덜 할 뿐..................
public class Bj2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수 N
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 콤보 접시
        int c = Integer.parseInt(st.nextToken()); // 쿠폰

        int[] sushi = new int[N + k];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());

        }

        //Linked List, Hash Set 사용.
        HashSet s = new HashSet();
        Deque<Integer> ld = new LinkedList();
        int max = 0;

        for (int i = 0; i < k; i++) {
            s.add(sushi[i]);
            ld.addLast(sushi[i]);
            sushi[N + i] = sushi[i];
        }

        for (int i = k; i < N + k; i++) {
            int size = s.size();
            if(!s.contains(c)) size++;
            if (size>max) max = size;
            if (max == k+1) break;

            int first = ld.removeFirst();
            if (!ld.contains(first)) {
                s.remove(first);
            }
            ;
            // 빼버리면. 중복 (2 2 2 3) 일때

            ld.addLast(sushi[i]);
            s.add(sushi[i]);
        }

        System.out.println(max);

    }
}
