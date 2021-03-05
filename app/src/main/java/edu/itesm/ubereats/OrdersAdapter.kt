package edu.itesm.ubereats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class OrdersAdapter(private val orders: List<Order>) : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    // Renglon es el elemento grafico
    inner class OrdersViewHolder(renglon: View) : RecyclerView.ViewHolder(renglon){

        // Se asocia el renglon grafico con
        var subtotal = renglon.findViewById<TextView>(R.id.subtotalRenglon)
        var small = renglon.findViewById<TextView>(R.id.smallRenglon)
        var service = renglon.findViewById<TextView>(R.id.serviceRenglon)
        var delivery = renglon.findViewById<TextView>(R.id.deliveryRenglon)
        var tip = renglon.findViewById<TextView>(R.id.tipRenglon)
    }

    // Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {

        // Construimos el renglon (inflarlo)
        var inflater = LayoutInflater.from(parent.context)
        val orders_renglon = inflater.inflate(R.layout.orders_renglon,parent, false)
        return OrdersViewHolder(orders_renglon)
    }

    // Asocia los datos con los elementos del renglón
    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {

        // Sacar los datos de la lista de datos para asociarla
        val dato = orders[position]
        val subtotal = dato.subtotal
        val small = dato.small
        val service = dato.service
        val delivery = dato.delivery
        val tip = dato.tip

        holder.subtotal.text = "Subtotal: " + dato.subtotal.toString()
        holder.small.text =  "Small: " + dato.small.toString()
        holder.service.text = "Service: " + dato.service.toString()
        holder.delivery.text = "Delivery: " + dato.delivery.toString()
        holder.tip.text = "Tip: " + dato.tip.toString()

    }

    // Cuantos los elementos  que tiene la lista, en este caso son las ordenes que inicializamos en
    // la clase OrdersAdapter
    override fun getItemCount(): Int {
        return orders.size

    }

}