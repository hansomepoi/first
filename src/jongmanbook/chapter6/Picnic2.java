package jongmanbook.chapter6;

import java.io.*;

public class Picnic2 {
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

    private static int picnic() throws IOException{
        String[] firstLine = br.readLine().split("\\s");
        String[] pairLine = br.readLine().split("\\s");
        int studentCount = Integer.parseInt(firstLine[0]);
        int pairCount = Integer.parseInt(firstLine[1]);

        boolean[][] isFriend = new boolean[studentCount][studentCount];
        for(int i = 0; i< studentCount; i++){
            for(int j = 0; j < studentCount; j++){
                isFriend[i][j] = false;
            }
        }


        for(int i = 0; i < pairCount; i++){
            int student1 = Integer.parseInt(pairLine[i*2]);
            int student2 = Integer.parseInt(pairLine[i*2+1]);
            isFriend[student1][student2] = true;
            isFriend[student2][student1] = true;
        }

        boolean[] checked = new boolean[studentCount];
        for(int i = 0; i < studentCount; i++){
            checked[i] = false;
        }
        return nCm(isFriend, checked, studentCount, 0);
    }

    private static int nCm(boolean[][] isFriend, boolean[] checked, int studentCount, int index) {
        if(index == studentCount){
            return 1;
        }

        if(checked[index]){
            return nCm(isFriend, checked, studentCount, index+1);
        }

        int result = 0;
        for(int i = index+1; i < studentCount; i++){
            if(isFriend[index][i] && !checked[i]){
                checked[index] = true;
                checked[i] = true;
                result += nCm(isFriend, checked, studentCount, index+1);
                checked[index] = false;
                checked[i] = false;
            }
        }
        return result;
    }

}
