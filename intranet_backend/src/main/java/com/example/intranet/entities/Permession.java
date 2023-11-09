package com.example.intranet.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permession {
    ADMIN_READ("admin_read"),
    ADMIN_CREATE("admin_create"),
    ADMIN_PUT("admin_update"),
    ADMIN_DELETE("admin_delete"),
    MANAGER_READ("manager_read"),
    MANAGER_CREATE("manager_create"),
    MANAGER_PUT("manager_update"),
    MANAGER_DELETE("manager_delete"),
    EMPLOYE_READ("employe_read"),
    EMPLOYE_CREATE("employe_create"),
    EMPLOYE_PUT("employe_update"),
    EMPLOYE_DELETE("employe_delete");
    @Getter


    private final String permession ;
}
