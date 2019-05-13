package com.example.demo.services

import com.example.demo.components.ForgeSDKComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StateService {
    @Autowired
    lateinit var forgeSDKComponent: ForgeSDKComponent
}
