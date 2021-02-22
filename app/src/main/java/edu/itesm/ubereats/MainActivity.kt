package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.core.widget.doBeforeTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var orderList = mutableListOf<Order>()
    var tip : Double = 0.0
    var suma : Double = 0.0
    var subtotal : Double = 0.0
    var small : Double = 0.0
    var service : Double = 0.0
    var delivery : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){


        editTextNumberSubtotal.addTextChangedListener(object: TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                // You access the first character in afterTextChanged, if you delete all text the array is size 0.
                if(editTextNumberSubtotal.length() != 0){
                    subtotal = s.toString().toDouble()
                    Log.i("edu.itesm.daec.UberEats", subtotal.toString())

                    textViewSmall.text = (subtotal * 0.02).toString()
                    small = textViewSmall.text.toString().toDouble()


                    textViewService.text = (subtotal * 0.05).toString()
                    service = textViewService.text.toString().toDouble()


                    textViewDelivery.text = (subtotal * 0.1).toString()
                    delivery = textViewDelivery.text.toString().toDouble()


                    suma = small + service + delivery  + tip + subtotal

                    buttonPlaceOrder.text = "Place Order - Delivery " + suma
                }


            }
        })

    }


    fun finalizar(view : View){
        val order = Order(subtotal,small,service,delivery,tip)
        orderList.add(order)
        Log.i("edu.itesm.daec.UberEats", orderList.toString())

        buttonPlaceOrder.text = "Place Order - Delivery"
        textViewSmall.text = "0.0"
        textViewService.text = "0.0"
        textViewDelivery.text = "0.0"
        editTextNumberSubtotal.setText("")
        suma = 0.0
        small = 0.0
        service = 0.0
        delivery = 0.0
        tip = 0.0
        subtotal = 0.0


    }

    fun tip10(view : View) {
         tip = editTextNumberSubtotal.text.toString().toDouble() * 0.1
        suma = small + service + delivery  + tip + subtotal
        buttonPlaceOrder.text = "Place Order - Delivery " + suma

    }

    fun tip15(view : View){
        tip = editTextNumberSubtotal.text.toString().toDouble() * 0.15
        suma = small + service + delivery  + tip + subtotal
        buttonPlaceOrder.text = "Place Order - Delivery " + suma
    }

    fun tip20(view : View){
        tip = editTextNumberSubtotal.text.toString().toDouble() * 0.2
        suma = small + service + delivery  + tip + subtotal
        buttonPlaceOrder.text = "Place Order - Delivery " + suma

    }

    fun tip25(view : View){
        tip = editTextNumberSubtotal.text.toString().toDouble() * 0.25
        suma = small + service + delivery  + tip + subtotal
        buttonPlaceOrder.text = "Place Order - Delivery " + suma

    }

    fun tip0(view : View){
        tip = editTextNumberSubtotal.text.toString().toDouble() * 0.0
        suma = small + service + delivery  + tip + subtotal
        buttonPlaceOrder.text = "Place Order - Delivery " + suma

    }
}