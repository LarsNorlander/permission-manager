package com.larsnorlander.permissionmanager

class Permissions {

    fun create(entity: Entity): Unit = TODO()

    fun delete(entity: Entity): Unit = TODO()

    fun grant(subjectEntity: Entity, permission: Permission, objectEntity: Entity): Unit = TODO()

    fun can(subjectEntity: Entity, permission: Permission, objectEntity: Entity): Boolean = TODO()

    fun revoke(subjectEntity: Entity, permission: Permission, objectEntity: Entity): Unit = TODO()

    fun exists(entity: Entity): Boolean = TODO()

}