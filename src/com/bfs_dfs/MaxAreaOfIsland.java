package com.bfs_dfs;

/**
 * 岛屿最大面积 - 深度/广度 优先搜索
 * 链接 ：https://leetcode.cn/problems/max-area-of-island/ == https://leetcode.cn/problems/ZL6zAn/
 * 问题 ：
 */
public class MaxAreaOfIsland {
    /**
     *
     * @param grid  表示岛屿海洋地图，1表示岛，0表示海，
     * @return    求最大岛屿面积 （连续的1的面积）
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxSquare = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ;j++){
                if(grid[i][j]==1){
                    maxSquare = Math.max(maxSquare,dfs(grid,i,j));
                }
            }
        }
        return maxSquare;
    }

    /**
     * 已知grid[x][y]==1 ， 将该位置 置为0，并 从该位置进行深度优先搜索
     * @param grid
     * @param x
     * @param y
     * @return   搜索后返回 当前的面积
     */
    public static int dfs(int[][] grid,int x,int y){
        int area = 1;
        grid[x][y] = 0;
        if(x-1>=0&&grid[x-1][y]==1){
            area += dfs(grid,x-1,y);
        }
        if(x+1<=grid.length-1 && grid[x+1][y]==1){
            area += dfs(grid,x+1,y);
        }
        if(y-1>=0&&grid[x][y-1]==1){
            area += dfs(grid,x,y-1);
        }
        if(y+1<=grid[0].length-1&&grid[x][y+1]==1){
            area += dfs(grid,x,y+1);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid =   {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,1,1,0,1,0,0,0,0,0,0,0,0},
                          {0,1,0,0,1,1,0,0,1,0,1,0,0},
                          {0,1,0,0,1,1,0,0,1,1,1,0,0},
                          {0,0,0,0,0,0,0,0,0,0,1,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res = new MaxAreaOfIsland().maxAreaOfIsland(grid);
        System.out.println(res);
    }
}
