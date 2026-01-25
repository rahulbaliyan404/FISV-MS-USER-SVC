package com.home.dto;

public class PermissionsDto {
    private Long id;
    private String permissionName;
    private String description;

    public PermissionsDto() {
    }
    public PermissionsDto(Long id, String permissionName, String description) {
        this.id = id;
        this.permissionName = permissionName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
