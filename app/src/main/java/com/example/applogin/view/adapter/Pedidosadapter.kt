package com.example.applogin.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.R
import com.example.applogin.model.Producto
import com.example.applogin.view.ui.fragments.OrderDetailDialogFragment

class pedidosadapter (val productoList:List<Producto>, val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<pedidosadapter.ViewHolder>(){


    inner class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView) {

        var CardView: CardView
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCost:TextView

    init {

        CardView = itemView.findViewById<CardView>(R.id.pedidos)
        itemImage = itemView.findViewById(R.id.item_image)
        itemTitle = itemView.findViewById(R.id.item_titulo)
        itemDetail = itemView.findViewById(R.id.item_detalle)
        itemCost = itemView.findViewById(R.id.item_precio)

}
        fun render(producto: Producto) {
            itemImage.setImageResource(R.mipmap.ic_launcher)
            itemTitle.text = producto.nombre
            itemCost.text = producto.precio.toString()
            itemDetail.text=producto.descripcion

            CardView.setOnClickListener{
                view:View ->
                    var  dialogFragment = OrderDetailDialogFragment().newInstance(

                        producto.id,
                        producto.nombre,
                        producto.precio,
                        producto.descripcion,
                        producto.imageUrl )

                dialogFragment.show(fragmentManager,"prueba")

            }

        }

    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {


        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.pedidos,viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {

        holder.render(productoList[i])

    }

    override fun getItemCount(): Int {
       return productoList.size
    }


}
