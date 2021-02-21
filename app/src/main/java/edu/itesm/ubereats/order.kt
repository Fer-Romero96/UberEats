package edu.itesm.ubereats

data class Order(var subtotal: Double = 0.0, var small: Double = 0.0, var service: Double = 0.0, var delivery: Double = 0.0, var tip: Double = 0.0){

    override fun toString(): String = "Subtotal: $subtotal Small: $small Service: $service delivery: $delivery Tip: $tip"

}