
// The State Of Wakanda - 1
// 2d Arrays

import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        fillMatrix(mat, scn);
        StateofWakanda1(mat);
    }

    public static void fillMatrix(int mat[][], Scanner scn) {
        int nr = mat.length;
        int nc = mat[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                mat[r][c] = scn.nextInt();
            }
        }
    }

    public static void StateofWakanda1(int mat[][]) {
        int nc = mat[0].length;
        int nr = mat.length;
        for (int c = 0; c < nc; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < nr; r++) {
                    System.out.println(mat[r][c]);
                }
            } else {
                // odd ➡️ bottom to Top printing
                for (int r = nr - 1; r >= 0; r--) {
                    System.out.println(mat[r][c]);

                }

            }
        }

    }

}
