package projetos.danilo.myguests.service.repository

import android.content.ContentValues
import android.content.Context
import projetos.danilo.myguests.service.constants.DataBaseConstants
import projetos.danilo.myguests.service.model.GuestModel

//classe que não pode ser instanciada
class GuestRepository (context: Context) {
    //Acesso ao banco
    private val mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun get(id: Int): GuestModel? {
        return mDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresence()

    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0 //retorna o long e compara
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0 //se atualizou é sucesso

    }

    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }


}