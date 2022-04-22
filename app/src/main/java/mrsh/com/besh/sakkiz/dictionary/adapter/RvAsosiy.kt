package mrsh.com.besh.sakkiz.dictionary.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import mrsh.com.besh.sakkiz.dictionary.databinding.ItemAsosiyBinding
import mrsh.com.besh.sakkiz.dictionary.db.MyDBLugat
import mrsh.com.besh.sakkiz.dictionary.entity.Lugat


class RvAsosiy(val context: Context, val list: List<Lugat>, var rvClick: RvClick) :
    RecyclerView.Adapter<RvAsosiy.VH>() {
    inner class VH(var itemAsosiyBinding: ItemAsosiyBinding) :
        RecyclerView.ViewHolder(itemAsosiyBinding.root) {
        fun onBind(lugat: Lugat) {

            itemAsosiyBinding.sozItemAsosiy.text = lugat.soz
            itemAsosiyBinding.tarjimasiItemAsosiy.text = lugat.kichikMalumot

            itemAsosiyBinding.shungaBoskandayamIshlabQoy.setOnClickListener {
                rvClick.onClick(lugat)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemAsosiyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(lugat: Lugat)
    }

}