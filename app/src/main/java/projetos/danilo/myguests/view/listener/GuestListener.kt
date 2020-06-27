package projetos.danilo.myguests.view.listener

import projetos.danilo.myguests.service.model.GuestModel

interface GuestListener {
    fun onClick(id: Int)

    fun onDelete(guest: GuestModel)
}