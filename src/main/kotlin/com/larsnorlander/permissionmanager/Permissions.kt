package com.larsnorlander.permissionmanager

private typealias PermissionTriple = Triple<Entity, Permission, Entity>

class Permissions {

    private val entities = mutableSetOf<Entity>()
    private val graph = mutableSetOf<PermissionTriple>()

    fun create(entity: Entity) {
        entities.add(entity)
    }

    fun exists(entity: Entity): Boolean {
        return entities.contains(entity)
    }

    fun grant(subjectEntity: Entity, permission: Permission, objectEntity: Entity) {
        graph.add(PermissionTriple(subjectEntity, permission, objectEntity))
    }

    fun can(subjectEntity: Entity, permission: Permission, objectEntity: Entity): Boolean {
        return graph.contains(PermissionTriple(subjectEntity, permission, objectEntity))
    }

    fun revoke(subjectEntity: Entity, permission: Permission, objectEntity: Entity) {
        graph.remove(PermissionTriple(subjectEntity, permission, objectEntity))
    }

    fun delete(entity: Entity) {
        entities.remove(entity)
    }

}