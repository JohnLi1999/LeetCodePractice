package medium._0547_Friend_Circles;

public class Solution_Disjoint_Set {
    /*  https://leetcode.com/problems/friend-circles/
        Time complexity: O(N^2)
            We traverse over the complete matrix once.
            However, we added path compression and union-by-rank
            in our disjoint set. So the Union and Find operations take
            constant time on average.
            Thus, the time complexity is O(N^2)
        Space complexity: O(N)
            In the disjoint set, a parent array of size N is used.
     */
    public int findCircleNum(int[][] M) {
        Disjoint_Set disjoint_set = new Disjoint_Set(M);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    M[i][j] = 0;
                    disjoint_set.union(i, j);
                }
            }
        }

        return disjoint_set.getCount();
    }
}

class Disjoint_Set {
    private final int[] parent;
    private final int[] rank;
    private int count;

    public Disjoint_Set(int[][] friends) {
        parent = new int[friends.length];
        rank = new int[friends.length];
        count = 0;

        for (int i = 0; i < friends.length; i++) {
            parent[i] = i;
            count++;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }

            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
