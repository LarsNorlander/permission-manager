# Permission Manager

This project is a toy to try implementing a permission manager using Neo4j.

## Stages

### Phase 1: Can X do A to Y?

#### Domain Model
* An `Entity` is the basic unit.
    * An `Entity` has an `id`.
* An `Entity` is related to another `Entity` through a `CAN` relationship.
    * A `CAN` relationship has a `permission` value that describes the permission grant.

#### Use Cases
1. I want to create entities
2. I want to assign permissions between entities
3. I want to know if an entity is permitted to do some action to another entity
4. I want to revoke permissions granted to an entity
5. I want to remove entities
6. I want to know if an entity exists

#### Sample Code
```kotlin
val user = "lars.nrlndr"
val gpsSettings = "settings.gps"

// Create an entity
permissions.create(user)
permissions.create(gpsSettings)
// Allow a user to edit GPS Settings
permissions.grant(user, "edit", gpsSettings)
// Can the user edit GPS Settings?
permissions.can(user, "edit", gpsSettings)
// Remove permission for user to edit GPS Settings
permissions.revoke(user, "edit", gpsSettings)
// Delete an entity; Also prunes all relationships
permissions.delete(user)
permissions.delete(gpsSettings)
// Check if an Entity exists
permissions.exists(user)
permissions.exists(gpsSettings)
```