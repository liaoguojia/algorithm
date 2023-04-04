package com.trie;
import java.util.*;

/**
 * 删除子文件夹
 * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 * 问题：给定一个文件夹列表，删除列表中的所有子文件夹，并返回剩余文件夹
 * 分析：
 *      方法一 - 排序：将folder按照字典序 排序，对每一个folder[i]，若folder[i-1] 是它的前缀，就是子文件夹，不加入结果
 *      方法二 - 字典树：
 *
 */
public class RemoveSubFolders {
    /**
     * 方法一 - 排序
     * @param folder
     * @return
     */
    public List<String> removeSubfolders1(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for(int i = 1; i < folder.length ;i++){
            String file = folder[i];
            if(!file.startsWith(res.get(res.size()-1)+"/")) res.add(file);
        }
        return res;
    }
}
