package com.yangyang.dto;

/**
 * Created by yangyang on 2018/7/26.
 */
public class Role {
    private Integer id;
    private String roleName;
    private String Note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
