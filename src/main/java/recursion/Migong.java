package recursion;

public class Migong {

    public static void main(String[] args) {
        int[][] map = buildMap();
        showMap(map);
        findWay(map, 1, 1);
        System.out.println("====================");
        showMap(map);

    }


    public static int[][] buildMap() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[6][4] = 1;
        map[5][4] = 1;

        return map;
    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.printf("%d\t", map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @param map
     * @param i
     * @param j
     * @return 策略：下=》右=》上=》左
     */
    public static boolean findWay(int[][] map, int i, int j) {
        System.out.printf("i=%d.j=%d\n",i,j);
        if (map[6][5] == 2) {
            // 如果到达终点了，结束
            return true;
        } else {
            // 如果没有到达终点，
            if (map[i][j] == 0) {
                // 如果没走过这个格子，尝试走一下
                map[i][j] = 2;        // 先假设该点是正确的路线上的点；
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 四面都走不通说明此格不在正确的路上，置位3
                    map[i][j] = 3;
                    return false;
                }
            }
            return false;
        }
    }
}
