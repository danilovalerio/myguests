package projetos.danilo.myguests.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import projetos.danilo.myguests.service.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDataBase : RoomDatabase() {

    //classe abstrata para o room usar a interface
    abstract fun guestDAO(): GuestDAO

    //singleton
    companion object {
        private lateinit var INSTANCE: GuestDataBase
        fun getDatabase(context: Context): GuestDataBase {
            if(!::INSTANCE.isInitialized) {
                //synchro... garante o processamento por um único processador num multicore
                synchronized(GuestDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, GuestDataBase::class.java, "guestDB")
                        .allowMainThreadQueries()
                        .build()
                }

            }
            return INSTANCE
        }
    }
}