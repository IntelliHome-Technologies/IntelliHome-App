package com.intellihome.intellihome.data.db

import app.cash.sqldelight.db.SqlDriver
import com.intellihome.intellihome.data.db.Database

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): Database {
    val driver = driverFactory.createDriver()
    val database = Database(driver)

    // Work with db
    return database
}
