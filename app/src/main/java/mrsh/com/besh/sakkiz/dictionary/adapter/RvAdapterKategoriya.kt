package mrsh.com.besh.sakkiz.dictionary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import mrsh.com.besh.sakkiz.dictionary.databinding.ItemCategoriyaBinding
import mrsh.com.besh.sakkiz.dictionary.entity.Categoriya


class RvAdapter(val context: Context, val list: List<Categoriya>, var rvClick: RvClick) :
    RecyclerView.Adapter<RvAdapter.VH>() {
    inner class VH(var itemCategoriyaBinding: ItemCategoriyaBinding) :
        RecyclerView.ViewHolder(itemCategoriyaBinding.root) {
        fun onBind(categoriya: Categoriya) {

            itemCategoriyaBinding.kategoriyNomiRv.text = categoriya.kategoriyaNomi

            itemCategoriyaBinding.popUpMenuKategoriya.setOnClickListener {
                rvClick.onClick(
                    categoriya,
                    itemCategoriyaBinding.popUpMenuKategoriya,
                    itemCategoriyaBinding.menuKategoriya
                )
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemCategoriyaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(categoriya: Categoriya, linearLayout: LinearLayout, imageView: ImageView)
    }
}