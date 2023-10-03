package com.example.msproduct.kafka.producer

import com.example.msproduct.kafka.AppConstants
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer (val kafkaTemplate: KafkaTemplate<String, String>){
    fun sendMessage(message : String){
        val answer = kafkaTemplate.send(AppConstants.TOPIC_NAME, message)
        println(answer)
    }
}