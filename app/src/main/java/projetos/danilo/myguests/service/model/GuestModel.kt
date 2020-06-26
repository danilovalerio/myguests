package projetos.danilo.myguests.service.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//mapeia os atributos do Convidado

@Entity(tableName = "Guest")
class GuestModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") //se for o mesmo do atributo não precisa do name
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "presence")
    var presence: Boolean = true
}