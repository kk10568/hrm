package com.hrm.model.system.entity;

public class PermissionApi {
    private String id;

    private String apiLevel;

    private String apiMethod;

    private String apiUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel == null ? null : apiLevel.trim();
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod == null ? null : apiMethod.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    @Override
    public String toString() {
        return "PermissionApi{" +
                "id='" + id + '\'' +
                ", apiLevel='" + apiLevel + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                '}';
    }
}