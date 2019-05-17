package io.arcblock.forge.did

/**
 * Author       :paperhuang
 * Time         :2019/2/14
 * Edited By    :
 * Edited Time  :
 **/
enum class RoleType(val value: Int) {
  ACCOUNT(0), NODE(1), DEVICE(2), APPLICATION(3), SMART_CONTRACT(4), BOT(5), ASSET(6), STAKE(7), VALIDATOR(8), GROUP(9), TX(10), TETHER(11), ANY(63);

}
