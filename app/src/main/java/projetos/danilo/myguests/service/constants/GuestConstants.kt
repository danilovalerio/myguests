package projetos.danilo.myguests.service.constants

class GuestConstants private constructor(){
    companion object {
        //constante para guest ID
        const val GUEST_ID = "guestID"
    }

    object FILTER {
        const val EMPTY = 0
        const val PRESENT = 1
        const val ABSENT = 2
    }
}