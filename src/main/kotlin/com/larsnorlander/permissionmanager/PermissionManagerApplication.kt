package com.larsnorlander.permissionmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PermissionManagerApplication

fun main(args: Array<String>) {
	runApplication<PermissionManagerApplication>(*args)
}
