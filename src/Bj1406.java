import java.io.*;
import java.util.*;
// 에디터
// iterator 활용.
// ListIterator<Character> iterator = list.listIterator();
// next(), hasNext, previous, hasPrevious, remove, add ...
public class Bj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        // 입력
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator();

        while(iterator.hasNext()){
            iterator.next();
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String command = br.readLine();

            switch(command.charAt(0)){
                case 'L' :
                    if(iterator.hasPrevious()){
                        iterator.previous();
                    }
                    break;
                case 'D' :
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                    break;
                case 'B' :
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P' :
                    iterator.add(command.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();


        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
