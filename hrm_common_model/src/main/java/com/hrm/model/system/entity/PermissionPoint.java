package com.hrm.model.system.entity;

public class PermissionPoint {
    private String id;

    private String pointClass;

    private String pointIcon;

    private Integer pointStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPointClass() {
        return pointClass;
    }

    public void setPointClass(String pointClass) {
        this.pointClass = pointClass == null ? null : pointClass.trim();
    }

    public String getPointIcon() {
        return pointIcon;
    }

    public void setPointIcon(String pointIcon) {
        this.pointIcon = pointIcon == null ? null : pointIcon.trim();
    }

    public Integer getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(Integer pointStatus) {
        this.pointStatus = pointStatus;
    }
}