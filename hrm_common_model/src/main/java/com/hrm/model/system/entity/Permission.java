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

    private String apiLevel;

    private String apiMethod;

    private String apiUrl;

    private String menuIcon;

    private String menuOrder;

    private String pointClass;

    private String pointIcon;

    private Integer pointStatus;

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


    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getPointClass() {
        return pointClass;
    }

    public void setPointClass(String pointClass) {
        this.pointClass = pointClass;
    }

    public String getPointIcon() {
        return pointIcon;
    }

    public void setPointIcon(String pointIcon) {
        this.pointIcon = pointIcon;
    }

    public Integer getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(Integer pointStatus) {
        this.pointStatus = pointStatus;
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
                ", apiLevel='" + apiLevel + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuOrder='" + menuOrder + '\'' +
                ", pointClass='" + pointClass + '\'' +
                ", pointIcon='" + pointIcon + '\'' +
                ", pointStatus=" + pointStatus +
                '}';
    }
}