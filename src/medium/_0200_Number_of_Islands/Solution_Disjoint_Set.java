package medium._0200_Number_of_Islands;

import utils.pair_node.Pos;

import java.util.HashSet;
import java.util.Set;

public class Solution_Disjoint_Set {
    private DisjointSet disjointSet;

    /*  https://leetcode.com/problems/number-of-islands/
        Time complexity: O(M * N)
            Where M is the number of rows and N is the number of columns.
            Note that Union operation takes essentially constant time
            when UnionFind is implemented with both path compression and union by rank.
        Space complexity: O(M * N)
            As required by UnionFind data structure.
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        disjointSet = new DisjointSet(grid);
        combine();

        Set<Pos> result = new HashSet<>();
        for (Pos[] arr : disjointSet.roots) {
            for (Pos pair : arr) {
                if (pair != null) {
                    Pos root = disjointSet.findRoot(pair);
                    if (!result.contains(root)) {
                        result.add(root);
                    }
                }
            }
        }

        return result.size();
    }

    private void combine() {
        for (int i = 0; i < disjointSet.roots.length; i++) {
            for (int j = 0; j < disjointSet.roots[i].length; j++) {
                if (disjointSet.roots[i][j] != null) {
                    if (i != disjointSet.roots.length - 1 && disjointSet.roots[i + 1][j] != null) {
                        disjointSet.union(disjointSet.roots[i][j], disjointSet.roots[i + 1][j]);
                    }

                    if (j != disjointSet.roots[i].length - 1 && disjointSet.roots[i][j + 1] != null) {
                        disjointSet.union(disjointSet.roots[i][j], disjointSet.roots[i][j + 1]);
                    }
                }
            }
        }
    }
}

class DisjointSet {
    public Pos[][] roots;

    public DisjointSet(char[][] grid) {
        int width = grid.length;
        int height = grid[0].length;

        roots = new Pos[width][height];

        for (int i  = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == '1') {
                    roots[i][j] = new Pos(i, j);
                }
            }
        }
    }

    public void union(Pos p, Pos q) {
        Pos pRoot = findRoot(p);
        Pos qRoot = findRoot(q);
        roots[qRoot.x][qRoot.y] = pRoot;
    }

    public Pos findRoot(Pos p) {
        Pos root = p;

        while (!root.equals(roots[root.x][root.y])) {
            root = roots[root.x][root.y];
        }

        while (!p.equals(roots[p.x][p.y])) {
            Pos temp = roots[p.x][p.y];
            roots[p.x][p.y] = root;
            p = temp;
        }

        return root;
    }
}