package projetos.danilo.myguests.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import projetos.danilo.myguests.R
import projetos.danilo.myguests.service.model.GuestModel
import projetos.danilo.myguests.view.listener.GuestListener


class GuestViewHolder(itemView: View, private val listener: GuestListener): RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val name = itemView.findViewById<TextView>(R.id.textview_name)
        name.text = guest.name

        name.setOnClickListener {
            guest.id?.let { listener.onClick(it) }
        }

        //todo: Adicionar um ícone para exclusão de convidado
        name.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção do Convidado")
                .setMessage("Deseja remover mesmo?")
                .setPositiveButton("Remover") { dialog, which ->
                    guest.id?.let { listener.onDelete(it) }
                }
                .setNeutralButton("Cancelar", null)
                .show()
            true
        }

    }
}