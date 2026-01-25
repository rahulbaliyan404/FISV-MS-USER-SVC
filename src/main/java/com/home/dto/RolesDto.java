package com.home.dto;

import java.util.Set;

public class RolesDto {

    private Long id;
    private String name;
    private String description;
    private boolean activated;
    private Set<PermissionsDto> permissions;

    public RolesDto() {
    }
    public RolesDto(Long id, String name, String description, boolean activated, Set<PermissionsDto> permissions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activated = activated;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<PermissionsDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionsDto> permissions) {
        this.permissions = permissions;
    }
}
