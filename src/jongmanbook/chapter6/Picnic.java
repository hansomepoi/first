package jongmanbook.chapter6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Picnic {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tc = br.readLine().split("\\s");
        int testCase = Integer.parseInt(tc[0]);
        for(int i = 0; i < testCase; i++){
            bw.write(picnic()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int picnic() throws IOException {
        String[] firstLine = br.readLine().split("\\s");
        String[] pairLine = br.readLine().split("\\s");
        int studentCount = Integer.parseInt(firstLine[0]);
        int pairCount = Integer.parseInt(firstLine[1]);

        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < pairCount; i++){
            int student1 = Integer.parseInt(pairLine[i*2]);
            int student2 = Integer.parseInt(pairLine[i*2+1]);
            pairs.add(new Pair(student1, student2));
        }

        List<Integer> list = new ArrayList<>();
        return nCm(pairs, list, studentCount/2);
    }

    private static int nCm(List<Pair> pairs, List<Integer> list, int remainCount) {
        if(remainCount == 0) return validateList(pairs, list);

        int result = 0;
        int startIndex = list.isEmpty() ? 0 : list.get(list.size()-1);
        for(int i = startIndex; i < pairs.size(); i++){
            list.add(i);
            result += nCm(pairs, list, remainCount-1);
            list.remove(list.size()-1);
        }
        return result;
    }

    private static int validateList(List<Pair> pairs, List<Integer> list) {
        boolean[] students = new boolean[list.size()*2];
        for(int i = 0; i < list.size(); i++){
            Pair pair = pairs.get(list.get(i));
            if(students[pair.student1] || students[pair.student2]) return 0;
            students[pair.student1] = true;
            students[pair.student2] = true;
        }
        return 1;
    }


    public static class Pair{
        int student1;
        int student2;

        public Pair(int student1, int student2) {
            this.student1 = student1;
            this.student2 = student2;
        }
    }
}
