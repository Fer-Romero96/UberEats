package edu.itesm.ubereats

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

    private fun init(){

        editTextNumberSubtotal.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                // You access the first character in afterTextChanged, if you delete all text the array is size 0.
                if (editTextNumberSubtotal.length() != 0) {

                    subtotal = s.toString().toDouble()

                    textViewSmall.text = String.format("%.2f", (subtotal * 0.02).toString().toDouble())
                    small = textViewSmall.text.toString().toDouble()

                    textViewService.text = String.format("%.2f", (subtotal * 0.05).toString().toDouble())
                    service = textViewService.text.toString().toDouble()

                    textViewDelivery.text = String.format("%.2f", (subtotal * 0.1).toString().toDouble())
                    delivery = textViewDelivery.text.toString().toDouble()

                    tip = String.format("%.2f", editTextNumberSubtotal.text.toString().toDouble() * 0.1).toDouble()
                    button10.text = "10% $tip"

                    tip = String.format("%.2f", editTextNumberSubtotal.text.toString().toDouble() * 0.15).toDouble()
                    button15.text = "15% $tip"

                    tip = String.format("%.2f", editTextNumberSubtotal.text.toString().toDouble() * 0.2).toDouble()
                    button20.text = "20% $tip"

                    tip = String.format("%.2f", editTextNumberSubtotal.text.toString().toDouble() * 0.25).toDouble()
                    button25.text = "25% $tip"

                    suma = small + service + delivery + tip + subtotal
                    suma = String.format("%.2f", suma).toDouble()

                    buttonPlaceOrder.text = "Place Order - Delivery $suma"

                }
            }
        })

    }


    fun finalizar(view: View){
        val order = Order(subtotal, small, service, delivery, tip)
        orderList.add(order)
        Log.i("edu.itesm.daec.UberEats", orderList.toString())

        // Vamos a la actividad de Ordenes
        val intento = Intent(this, OrdersActivity::class.java)
        // Mando esos datos
        intento.putExtra("subtotal",suma)
        intento.putExtra("small",small)
        intento.putExtra("service",service)
        intento.putExtra("delivery",delivery)
        intento.putExtra("tip",tip)
        // Creo la actividad
        startActivity(intento)

        resetAll()
    }

    fun tip10(view: View) {

        if(editTextNumberSubtotal.length() != 0){

            tip = editTextNumberSubtotal.text.toString().toDouble() * 0.1
            tip = String.format("%.2f",tip).toDouble()
            button10.text = "10% $tip"
            suma = small + service + delivery  + tip + subtotal
            suma = String.format("%.2f", suma).toDouble()
            buttonPlaceOrder.text = "Place Order - Delivery $suma"

        }

        clickButtonColor(button10)
        unClickButtonColor(button15)
        unClickButtonColor(button20)
        unClickButtonColor(button25)
        unClickButtonColor(button0)
    }

    fun tip15(view: View){

        if(editTextNumberSubtotal.length() != 0){

            tip = editTextNumberSubtotal.text.toString().toDouble() * 0.15
            tip = String.format("%.2f", tip).toDouble()
            button15.text = "15% $tip"
            suma = small + service + delivery  + tip + subtotal
            suma = String.format("%.2f", suma).toDouble()
            buttonPlaceOrder.text = "Place Order - Delivery $suma"
        }

        clickButtonColor(button15)
        unClickButtonColor(button10)
        unClickButtonColor(button20)
        unClickButtonColor(button25)
        unClickButtonColor(button0)
    }

    fun tip20(view: View){

        if(editTextNumberSubtotal.length() != 0){

            tip = editTextNumberSubtotal.text.toString().toDouble() * 0.2
            tip = String.format("%.2f", tip).toDouble()
            button20.text = "20% $tip"
            suma = small + service + delivery  + tip + subtotal
            suma = String.format("%.2f", suma).toDouble()
            buttonPlaceOrder.text = "Place Order - Delivery $suma"
        }

        clickButtonColor(button20)
        unClickButtonColor(button0)
        unClickButtonColor(button10)
        unClickButtonColor(button15)
        unClickButtonColor(button25)
    }

    fun tip25(view: View){

        if(editTextNumberSubtotal.length() != 0){

            tip = editTextNumberSubtotal.text.toString().toDouble() * 0.25
            tip = String.format("%.2f", tip).toDouble()
            button20.text = "25% $tip"
            suma = small + service + delivery  + tip + subtotal
            suma = String.format("%.2f", suma).toDouble()
            buttonPlaceOrder.text = "Place Order - Delivery $suma"
        }

        clickButtonColor(button25)
        unClickButtonColor(button0)
        unClickButtonColor(button10)
        unClickButtonColor(button15)
        unClickButtonColor(button20)
    }

    fun tip0(view: View){

        if(editTextNumberSubtotal.length() != 0){

            tip = editTextNumberSubtotal.text.toString().toDouble() * 0.0
            tip = String.format("%.2f", tip).toDouble()
            button0.text = "$tip"
            suma = small + service + delivery  + tip + subtotal
            suma = String.format("%.2f", suma).toDouble()
            buttonPlaceOrder.text = "Place Order - Delivery $suma"
        }

        clickButtonColor(button0)
        unClickButtonColor(button10)
        unClickButtonColor(button15)
        unClickButtonColor(button20)
        unClickButtonColor(button25)

    }

    fun clickButtonColor(button: Button) {

        val mList: ColorStateList = button.textColors
        val color = mList.defaultColor

        if(color == Color.BLACK){
            button.setBackgroundColor(Color.parseColor("#51AC05"))
            button.setTextColor(Color.WHITE)
        }
    }

    fun unClickButtonColor(button: Button) {

        val mList: ColorStateList = button.textColors
        val color = mList.defaultColor

        if(color == Color.WHITE){
            button.setBackgroundColor(Color.parseColor("#DCDCDC"))
            button.setTextColor(Color.BLACK)
        }
    }

    fun resetAll(){

        buttonPlaceOrder.text = "Place Order - Delivery"
        textViewSmall.text = "0.0"
        textViewService.text = "0.0"
        textViewDelivery.text = "0.0"
        button10.text = "10% "
        button15.text = "15% "
        button20.text = "20% "
        button25.text = "25% "
        editTextNumberSubtotal.setText("")
        suma = 0.0
        small = 0.0
        service = 0.0
        delivery = 0.0
        tip = 0.0
        subtotal = 0.0
        button10.setBackgroundColor(Color.parseColor("#DCDCDC"))
        button10.setTextColor(Color.BLACK)
        button15.setBackgroundColor(Color.parseColor("#DCDCDC"))
        button15.setTextColor(Color.BLACK)
        button20.setBackgroundColor(Color.parseColor("#DCDCDC"))
        button20.setTextColor(Color.BLACK)
        button25.setBackgroundColor(Color.parseColor("#DCDCDC"))
        button25.setTextColor(Color.BLACK)
        button0.setBackgroundColor(Color.parseColor("#DCDCDC"))
        button0.setTextColor(Color.BLACK)
    }


}