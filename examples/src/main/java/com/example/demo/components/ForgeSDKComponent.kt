package com.example.demo.components

import io.arcblock.forge.ForgeSDK
import org.springframework.stereotype.Component

@Component
class ForgeSDKComponent {
    var forgeSDK: ForgeSDK = ForgeSDK.connect("localhost", 10020)
}
