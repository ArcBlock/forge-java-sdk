package io.arcblock.vc

import java.lang.RuntimeException

enum class VCError {
  UNSUPPORT_CREDENTIAL

}

class ParseVCException(val type: VCError, reason: String) : RuntimeException(reason)
