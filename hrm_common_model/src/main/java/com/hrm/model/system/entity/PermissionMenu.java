package com.hrm.model.system.entity;

public class PermissionMenu {
    private String id;

    private String menuIcon;

    private String menuOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder == null ? null : menuOrder.trim();
    }

    @Override
    public String toString() {
        return "PermissionMenu{" +
                "id='" + id + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuOrder='" + menuOrder + '\'' +
                '}';
    }
}