package projetos.danilo.myguests.service.repository

import android.content.ContentValues
import android.content.Context
import projetos.danilo.myguests.service.constants.DataBaseConstants
import projetos.danilo.myguests.service.model.GuestModel

//classe que não pode ser instanciada
class GuestRepository private constructor(context: Context) {



    fun get(id: Int): GuestModel? {

    }

    fun getAll(): List<GuestModel> {

    }

    fun getPresent(): List<GuestModel> {

    }

    fun getAbsent(): List<GuestModel> {

    }

    fun save(guest: GuestModel): Boolean {

    }

    fun update(guest: GuestModel): Boolean {

    }

    fun delete(id: Int): Boolean {

    }


}