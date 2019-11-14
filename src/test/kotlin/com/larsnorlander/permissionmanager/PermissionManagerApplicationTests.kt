package com.larsnorlander.permissionmanager

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

val USER = Entity("lars.nrlndr")
val GPS_SETTINGS = Entity("settings.gps")

val EDIT = Permission("edit")

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class PermissionsTests {

    private val permissions = Permissions()

    @Test
    @Order(1)
    fun `create entities`() {
        permissions.create(USER)
        permissions.create(GPS_SETTINGS)

        assertTrue(permissions.exists(USER))
        assertTrue(permissions.exists(GPS_SETTINGS))
    }

    @Test
    @Order(2)
    fun `grant permission`() {
        permissions.grant(USER, EDIT, GPS_SETTINGS)

        assertTrue(permissions.can(
                Entity("lars.nrlndr"),
                Permission("edit"),
                Entity("settings.gps")))
    }

    @Test
    @Order(3)
    fun `revoke permission`() {
        permissions.revoke(USER, EDIT, GPS_SETTINGS)

        assertFalse(permissions.can(USER, EDIT, GPS_SETTINGS))
    }

    @Test
    @Order(4)
    fun `delete entities`() {
        permissions.delete(USER)
        permissions.delete(GPS_SETTINGS)

        assertFalse(permissions.exists(USER))
        assertFalse(permissions.exists(GPS_SETTINGS))
    }

}