package projetos.danilo.myguests.service.repository

import androidx.room.*
import projetos.danilo.myguests.service.model.GuestModel

/** Camada de acesso aos dados */
@Dao
interface GuestDAO {

    @Insert
    fun save(guest: GuestModel) : Long //retorna o cod de registro

    @Update
    fun update(guest: GuestModel) : Int //número de registros atualizados

    @Delete
    fun delete(guest: GuestModel) : Int //número de registros removidos

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun get(id: Int): GuestModel

    @Query("SELECT * FROM Guest")
    fun getInvited(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 1")
    fun getPresence(): List<GuestModel>

    @Query("SELECT * FROM Guest WHERE presence = 0")
    fun getAbsent(): List<GuestModel>

}