import java.io.*;
import java.util.*;

// 컵라면
// 거꾸로 가면서 해당 데드라인에 푸는 문제 더하기.
// 한 번에 넣으면 안 되고, 날짜에 해당하는 문제만 넣으면서 하나씩 빼준다.

public class Bj1781 {
    static class Problem implements Comparable<Problem>{
        int deadline;
        int cup;

        Problem(int deadline, int cup){
            this.deadline =deadline;
            this.cup = cup;
        }

        @Override
        public int compareTo(Problem problem){
           if(this.deadline < problem.deadline) return -1; // 데드라인 높은 순서
           else return 1;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        List<Problem> problems = new ArrayList<>();

        //입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());
            problems.add(new Problem(deadline, cup));
        }

        Collections.sort(problems);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Problem problem : problems){
            pq.add(problem.cup);
            if(pq.size()> problem.deadline){
                pq.poll();
            }
        }

        int totalCup = 0;
        while(!pq.isEmpty()){
            totalCup+=pq.poll();
        }

        System.out.println(totalCup);
    }
}
