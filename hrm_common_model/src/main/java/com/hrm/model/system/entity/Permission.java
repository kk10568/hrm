package com.hrm.model.system.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 3396420387030370105L;
    private String id;

    private String name;

    private Byte type;

    private String pid;

    private String code;

    private Integer enVisible;

    private String description;

    private PermissionApi permissionApi;

    private PermissionMenu permissionMenu;

    private PermissionPoint permissionPoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getEnVisible() {
        return enVisible;
    }

    public void setEnVisible(Integer enVisible) {
        this.enVisible = enVisible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public PermissionApi getPermissionApi() {
        return permissionApi;
    }

    public void setPermissionApi(PermissionApi permissionApi) {
        this.permissionApi = permissionApi;
    }

    public PermissionMenu getPermissionMenu() {
        return permissionMenu;
    }

    public void setPermissionMenu(PermissionMenu permissionMenu) {
        this.permissionMenu = permissionMenu;
    }

    public PermissionPoint getPermissionPoint() {
        return permissionPoint;
    }

    public void setPermissionPoint(PermissionPoint permissionPoint) {
        this.permissionPoint = permissionPoint;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", pid='" + pid + '\'' +
                ", code='" + code + '\'' +
                ", enVisible=" + enVisible +
                ", description='" + description + '\'' +
                ", permissionApi=" + permissionApi +
                ", permissionMenu=" + permissionMenu +
                ", permissionPoint=" + permissionPoint +
                '}';
    }
}