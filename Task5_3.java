// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// И вывести Доску.
// Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000

package HW5;

import java.util.LinkedList;
import java.util.Random;

public class Task5_3 {

    public static boolean checkLines(LinkedList<Integer> lst, int num) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDiagonale(LinkedList<Integer> lst1, LinkedList<Integer> lst2, int num1, int num2) {
        for (int i = 0; i < lst1.size(); i++) {
            if (Math.abs(lst1.get(i) - num1) == Math.abs(lst2.get(i) - num2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] field = new int[8][8];
        int figures = 0;
        while (figures != 8) {
            LinkedList<Integer> horisontal = new LinkedList<Integer>();
            LinkedList<Integer> vertical = new LinkedList<Integer>();
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    field[i][j] = 1;
                }
            }
            Random rnd = new Random();
            int hor = rnd.nextInt(8);
            int vert = rnd.nextInt(8);
            field[hor][vert] = 0;
            horisontal.add(hor);
            vertical.add(vert);
            figures = 1;
            for (int a = 0; a < field.length; a++) {
                for (int b = 0; b < field.length; b++) {
                    if (checkLines(horisontal, a) && checkLines(vertical, b)
                            && checkDiagonale(horisontal, vertical, a, b)) {
                        field[a][b] = 0;
                        horisontal.add(a);
                        vertical.add(b);
                        figures++;
                    }
                }
            }
        }
        System.out.println();
        for (int m = 0; m < field.length; m++) {
            for (int n = 0; n < field.length; n++) {
                System.out.print(field[m][n] + " ");
            }
            System.out.println();
        }
    }

}
