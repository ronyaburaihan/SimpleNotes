package com.techdoctorbd.notes

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NoteItem(
    @PrimaryKey
    var id:Int ? = null,
    var title:String ?= null,
    var description:String ?= null,
    var priority:String ?= null
): RealmObject()