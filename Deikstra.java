import java.util.*;
import java.lang.Math;
public class Deikstra {
    public static int n;
    public static int s;
    public static int f;
    public static int[][] matrix;
    public static HashMap<Integer, Integer> Map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        f = Integer.parseInt(str[2]);
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] mtr = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(mtr[j]);
            }
        }
        HashMap<Integer, Integer> Map = new HashMap<>();
        HashMap<Integer, Integer> array = new HashMap();
        array.put(s - 1, 0);
        Map.put(s, 0);//кратчайший путь из s  в  s - 0
        for (int i = 0; i < n; i++) {
            if (i == (s - 1)) continue;
            else {
                array.put(i, 1000);
            }
        }
        // заполнили бесконечностями
        int k = s - 1;
        while (Map.size() != n) {
            // int i = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[k][i] != -1 && i != k) {
                    int zn = Map.get(k+1) + matrix[k][i];
                    int przn = array.get(i);
                    int put = Math.min(zn, przn);
                    array.put(i, put);
                }
            }
            //for(int i : matrix[k][]){

            //}
            array.remove(k);
            for(int i = 0; i < n; i++){
                matrix[i][k] = -1;
            }
            if (array.size() != 0) {
                int min = 10000;
                for (int el : array.keySet()) {
                    if (array.get(el) < min) {
                        min = array.get(el);
                    }
                }
                int key = k;
                for (int el : array.keySet()) {
                    if (array.get(el) == min) {
                        key = el;
                        break;
                    }
                }
                array.remove(key);
                Map.put(key + 1, min);
                k = key;
            }
            else break;

        }
        if (Map.get(f) > 500)
            System.out.println(-1);
        else
            System.out.println(Map.get(f));
    }
}