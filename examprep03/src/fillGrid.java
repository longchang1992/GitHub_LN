import java.util.Arrays;

public class fillGrid {

    static int[] LL = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0 };
    static int[] UR = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
    static int[][] S = {
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0}
    };

    public static void fillGrid (int[] LL, int[] UR, int[][] S) {
        int N = S.length;
        int kL, kR;
        kL = kR = 0;
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j <= i; j += 1) {
                if (j == i) {
                    break;
                }
                S[i][j] = LL[kL];
                kL += 1;
            }
            for (int p = i + 1; p < N; p += 1) {
                S[i][p] = UR[kR];
                kR += 1;
            }
        }
    }
    public static void main (String[] args) {
        fillGrid(LL, UR, S);
        System.out.println(Arrays.deepToString(S));
    }
 }
