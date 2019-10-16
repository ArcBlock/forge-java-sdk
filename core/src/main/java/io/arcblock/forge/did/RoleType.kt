package io.arcblock.forge.did

/**
 * RoleType of DID, contains
 * account
 * node
 * device
 * application
 * smart_contract
 * bot
 * asset
 * validator
 * delegate
 * ...
 **/
enum class RoleType(val value: Int) {
  ACCOUNT(0), NODE(1), DEVICE(2), APPLICATION(3), SMART_CONTRACT(4), BOT(5), ASSET(6), STAKE(7), VALIDATOR(8), GROUP(9), TX(10), TETHER(11),SWAP(12),
  DELEGATE(13),ANY(63);
}
