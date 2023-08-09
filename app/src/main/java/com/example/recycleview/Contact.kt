package com.example.recycleview

data class Contact(val name:String)



const private val lastContactId = 0

fun createContactsList(numContacts: Int): ArrayList<Contact> {
    var counter = lastContactId
    val contacts = ArrayList<Contact>()
    for (i in 1..numContacts) {
        contacts.add( Contact("  Person " + ++counter)    )
    }
    return contacts
}
