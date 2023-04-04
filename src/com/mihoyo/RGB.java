package com.mihoyo;
import java.util.Arrays;

/**
 * 第一题，DFS
 */
public class RGB {
    public static void main(String[] args) {
        String s1 = "RRGGRB";
        String s2 = "RGBGRB";
        String[] ss = {"RRGGRB","RGBGRB"};
        int n = 2;
        int m = 6;
        char[][] rgb = new char[n][m];
        for (int i = 0 ; i < rgb.length ;i++){
            for (int j = 0 ; j < rgb[0].length ;j++){
                rgb[i][j] = ss[i].charAt(j);
            }
        }
        show(rgb);
        int trueCount = 0, falseCount = 0;
        for (int i = 0 ; i < rgb.length ;i++){
            for (int j = 0 ; j < rgb[0].length ;j++){
                if (rgb[i][j] != '0'){
                    dfs(rgb,i,j);
                    trueCount++;
                }
            }
        }
        System.out.println(trueCount);
        show(rgb);
    }

    public static void dfs(char[][] rgb,int i ,int j){
        if (!inArea(rgb,i,j))    return;
        char c = rgb[i][j];
        rgb[i][j] = '0';
        if (inArea(rgb,i-1,j) && rgb[i-1][j]==c)    dfs(rgb,i-1,j);
        if (inArea(rgb,i+1,j) && rgb[i+1][j]==c)    dfs(rgb,i+1,j);
        if (inArea(rgb,i,j+1) && rgb[i][j+1]==c)    dfs(rgb,i,j+1);
        if (inArea(rgb,i,j-1) && rgb[i][j-1]==c)    dfs(rgb,i,j-1);
    }

    public static boolean inArea(char[][] rgb,int i,int j){
        if(i>=0&&i<rgb.length&&j>=0&&j<rgb[0].length)   return true;
        return false;
    }

    public static void show(char[][] rgb){
        for (int i = 0 ; i < rgb.length ;i++){
            System.out.println();
            for (int j = 0 ; j < rgb[0].length ;j++){
                System.out.print(rgb[i][j]);
            }
        }
        System.out.println();
    }
}
