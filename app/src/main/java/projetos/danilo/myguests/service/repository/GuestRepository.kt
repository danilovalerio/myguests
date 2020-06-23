package projetos.danilo.myguests.service.repository

import android.content.Context
import projetos.danilo.myguests.service.model.GuestModel

//classe que não pode ser instanciada
class GuestRepository private constructor(context: Context){

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    //Metodo responsável por retornar a instancia
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context) : GuestRepository {
            if(!::repository.isInitialized) { //se foi inicializada
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun getAll(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent(): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel){

    }

    fun update(guest: GuestModel){

    }

    fun delete(guest: GuestModel){

    }


}