package com.yangyang.conditional;

/**
 * Created by yangyang on 2018/8/7.
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
