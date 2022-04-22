package mrsh.com.besh.sakkiz.dictionary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import mrsh.com.besh.sakkiz.dictionary.databinding.LugatItemBinding
import mrsh.com.besh.sakkiz.dictionary.entity.Lugat

class RvAdapterLugat(val context: Context, val list: List<Lugat>, var rvClick: RvClick) :
    RecyclerView.Adapter<RvAdapterLugat.VH>() {
    inner class VH(var lugatItemBinding: LugatItemBinding) :
        RecyclerView.ViewHolder(lugatItemBinding.root) {
        fun onBind(lugat: Lugat) {
            lugatItemBinding.sozItem.text = lugat.soz
            lugatItemBinding.tarjimasiItem.text = lugat.kichikMalumot

            lugatItemBinding.popUpMenuSozlar.setOnClickListener {
                rvClick.onClick(lugat, lugatItemBinding.popUpMenuSozlar, lugatItemBinding.menuLugat)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LugatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(lugat: Lugat, linearLayout: LinearLayout, imageView: ImageView)
    }
}