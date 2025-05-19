package com.svstudio.eccomerceapp.domain.until

fun <T> isListEqual(firts: List<T>,second: List<T>): Boolean{
    if(firts.size != second.size){
        return false
    }
    return firts.zip(second).all { (x,y) ->x==y }
}