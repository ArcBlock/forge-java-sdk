package com.example.demo.components

import io.arcblock.forge.*
import org.springframework.stereotype.*

@Component
class ForgeSDKComponent {
    var forgeSDK: ForgeSDK = ForgeSDK.connect("localhost",28210)
}
