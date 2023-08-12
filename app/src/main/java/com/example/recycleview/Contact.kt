package com.example.recycleview

data class Contact(val name:String)


fun createContactsList(start:Int , numContacts: Int): ArrayList<Contact> {
    val contacts = ArrayList<Contact>()
    for (i in start until start+numContacts) {
        contacts.add( Contact("  Person $i")    )
    }
    return contacts
}
