package com.example.demo.services

import com.example.demo.components.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*

@Service
class StateService {
    @Autowired lateinit var forgeSDKComponent: ForgeSDKComponent

}