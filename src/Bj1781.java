import java.io.*;
import java.util.*;

// 컵라면
// 데드라인 적은 순서로 정렬하고.
// 넣었을 때 현재 데드라인 날짜보다 큐의 크기가 커지면(3일인데 4문제를 풀 수 없다)
// 가장 작은 컵라면 수를 뺀다.

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
            // 데드라인 오름차순.
           if(this.deadline < problem.deadline) return -1;
           else if(this.deadline > problem.deadline) return 1;
           else return 0;
           // return this.deadline - problem.deadline; 과 동일.
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

        Collections.sort(problems); // 데드라인 작은 순서로 정렬.

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Problem problem : problems){
            pq.add(problem.cup);
            // 현재 데드라인 날짜보다 많은 문제들이 있으면 하나 빼고 간다.
            if(pq.size()> problem.deadline){
                if(!pq.isEmpty()){
                    pq.poll();
                }

            }
        }

        int totalCup = 0;
        while(!pq.isEmpty()){
            totalCup+=pq.poll();
        }

        System.out.println(totalCup);
    }
}
