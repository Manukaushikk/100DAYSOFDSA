// Ring Rotate

// You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
// You will be given a ring number 's' representing the ring of the matrix. For details, refer to image.

import java.util.*;

public class Ques6 {
    public static void main(String[] args) {
        // // spiral
        // Scanner scn = new Scanner(System.in);

        // int nr = scn.nextInt() , nc = scn.nextInt();
        // int mat[][] = new int[nr][nc];
        // for(int i = 0 ; i < nr ; i++){
        // for(int j = 0 ; j < nc ; j++){
        // mat[i][j] = scn.nextInt();
        // }
        // }

        // spiralDisplay(mat);

        // // ring Rotate
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt(), nc = scn.nextInt();
        int mat[][] = new int[nr][nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        int shell = scn.nextInt();
        int k = scn.nextInt();

        ringRotate(mat, shell, k);
        display(mat);
    }

    public static void ringRotate(int mat[][], int shell, int k) {
        int vals[] = getRing(mat, shell);
        rotate(vals, k);
        updateRing(mat, shell, vals);
    }

    public static int[] getRing(int mat[][], int shell) {
        int rmin = shell - 1, cmin = shell - 1, rmax = mat.length - shell, cmax = mat[0].length - shell;

        ArrayList<Integer> list = new ArrayList<>();

        // left wall
        for (int r = rmin, c = cmin; r <= rmax; r++) {
            list.add(mat[r][c]);
        }
        // bottom wall
        for (int r = rmax, c = cmin + 1; c <= cmax; c++) {
            list.add(mat[r][c]);
        }
        // right wall
        for (int r = rmax - 1, c = cmax; r >= rmin; r--) {
            list.add(mat[r][c]);
        }
        // top wall
        for (int r = rmin, c = cmax - 1; c >= cmin + 1; c--) {
            list.add(mat[r][c]);
        }

        int arr[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void updateRing(int mat[][], int shell, int vals[]) {
        int rmin = shell - 1, cmin = shell - 1, rmax = mat.length - shell, cmax = mat[0].length - shell;
        int idx = 0;
        // left wall
        for (int r = rmin, c = cmin; r <= rmax; r++) {
            mat[r][c] = vals[idx];
            idx++;
        }
        // bottom wall
        for (int r = rmax, c = cmin + 1; c <= cmax; c++) {
            mat[r][c] = vals[idx];
            idx++;
        }
        // right wall
        for (int r = rmax - 1, c = cmax; r >= rmin; r--) {
            mat[r][c] = vals[idx];
            idx++;
        }
        // top wall
        for (int r = rmin, c = cmax - 1; c >= cmin + 1; c--) {
            mat[r][c] = vals[idx];
            idx++;
        }
    }

    public static void rotate(int arr[], int k) {
        k = k % arr.length;

        if (k < 0)
            k = k + arr.length;

        // reverse part 2
        reverse(arr, arr.length - k, arr.length - 1);
        // reverse part 1
        reverse(arr, 0, arr.length - k - 1);
        // reverse arr
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int arr[], int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}