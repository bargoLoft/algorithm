import java.io.*;
import java.util.*;
// 키로거
// - => backspace
// <> => 화살표
// 연결리스트는 .get(i) 로 출력하면 시간초과.
// iterator 이용해서 StringBuilder 출력.
public class Bj5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());


        for(int i=0;i<T;i++){
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            String s = br.readLine();
            int stringSize = s.length();
            for(int j=0;j<stringSize;j++){
                Character c = s.charAt(j);
                if(c=='<'){
                    if(iterator.hasPrevious()) iterator.previous();
                } else if(c=='>'){
                    if(iterator.hasNext()) iterator.next();
                } else if(c=='-'){
                    if(iterator.hasPrevious()){
                        iterator.previous(); // 이전으로 하나 오고.
                        iterator.remove(); // 삭제
                    }
                } else{
                    iterator.add(c);
                }


            }
            StringBuilder sb = new StringBuilder();
            while(iterator.hasPrevious()){
                iterator.previous();
            }

            while(iterator.hasNext()){
                sb.append(iterator.next());
            }

            System.out.println(sb);
        }
    }
}
