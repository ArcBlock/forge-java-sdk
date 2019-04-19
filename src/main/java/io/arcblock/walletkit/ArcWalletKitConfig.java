package io.arcblock.walletkit;

/**
 * Created by Nate Gu on 2019/2/20
 */
public interface ArcWalletKitConfig {

  interface AddressType{
    int BASE16 = 0;
    int BASE58 = 1;
  }

  interface HashType{
    int SHA3_512 = 14;
    int KECCAK_512 = 13;
    int SHA3_384 = 7;
    int KECCAK_384 = 6;
    int SHA3 = 1;
    int KECCAK = 0;
  }

  interface PkType{
    int SECP256K1 = 1;
    int ED25519 = 0;
  }

}
