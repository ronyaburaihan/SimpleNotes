package com.techdoctorbd.notes

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
            .name("Notes.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .build()

        Realm.setDefaultConfiguration(configuration)
    }
}