create table if not exists roles_permissions(
    permission_id   int NOT NULL,
    role_id         int NOT NULL,
    CONSTRAINT fk_roles_permissions_user  FOREIGN KEY (permission_id) REFERENCES permissions(permission_id),
    CONSTRAINT fk_roles_permissions_roles FOREIGN KEY (role_id) REFERENCES roles(role_id)
);