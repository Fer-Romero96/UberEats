package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_orders.*

class OrdersActivity : AppCompatActivity() {
    private lateinit var ordersAdapter: OrdersAdapter
    private lateinit var orders : ArrayList<Order>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        // Recibimos los datos enviados por la MainActivy esto mediante el intent
        val subtotal = intent.getDoubleExtra("subtotal",1.1)
        val small = intent.getDoubleExtra("small", 2.1)
        val service = intent.getDoubleExtra("service", 3.1)
        val delivery = intent.getDoubleExtra("delivery", 4.1)
        val tip = intent.getDoubleExtra("tip", 5.1)

        initRecycler(subtotal,small,service,delivery,tip)
    }

    fun initRecycler(subtotal: Double, small: Double, service: Double, delivery: Double, tip: Double) {
        orders = ArrayList<Order>()
        ordersAdapter = OrdersAdapter(orders)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ordersAdapter

        for(i in 0..10){
            orders.add(Order(subtotal,small,service,delivery,tip))
        }

    }
}