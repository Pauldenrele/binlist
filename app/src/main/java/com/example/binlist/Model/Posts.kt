package com.example.binlist.Model
class Posts{
    data class Numbre(val length:Int , val luhn:Boolean )
    data class brand(val brand:String)
    data class Scheme(val scheme:String)
    data class Type(val type:String)
    data class Prepaid(val prepaid:Boolean)
    data class Country(val name:String , val emoji:String , val latitude:String , val longitude:String)
    data class Bank(val name:String , val url:String , val phone :String , val city:String)
}
