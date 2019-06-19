// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package forge_abi;

public final class Service {
  private Service() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rservice.proto\022\tforge_abi\032\trpc.proto2\345\007" +
      "\n\010ChainRpc\022D\n\tcreate_tx\022\032.forge_abi.Requ" +
      "estCreateTx\032\033.forge_abi.ResponseCreateTx" +
      "\022C\n\010multisig\022\032.forge_abi.RequestMultisig" +
      "\032\033.forge_abi.ResponseMultisig\022>\n\007send_tx" +
      "\022\030.forge_abi.RequestSendTx\032\031.forge_abi.R" +
      "esponseSendTx\022?\n\006get_tx\022\027.forge_abi.Requ" +
      "estGetTx\032\030.forge_abi.ResponseGetTx(\0010\001\022H" +
      "\n\tget_block\022\032.forge_abi.RequestGetBlock\032" +
      "\033.forge_abi.ResponseGetBlock(\0010\001\022G\n\nget_",
      "blocks\022\033.forge_abi.RequestGetBlocks\032\034.fo" +
      "rge_abi.ResponseGetBlocks\022`\n\023get_unconfi" +
      "rmed_txs\022#.forge_abi.RequestGetUnconfirm" +
      "edTxs\032$.forge_abi.ResponseGetUnconfirmed" +
      "Txs\022Q\n\016get_chain_info\022\036.forge_abi.Reques" +
      "tGetChainInfo\032\037.forge_abi.ResponseGetCha" +
      "inInfo\022N\n\rget_node_info\022\035.forge_abi.Requ" +
      "estGetNodeInfo\032\036.forge_abi.ResponseGetNo" +
      "deInfo\022=\n\006search\022\030.forge_abi.RequestSear" +
      "ch\032\031.forge_abi.ResponseSearch\022K\n\014get_net",
      "_info\022\034.forge_abi.RequestGetNetInfo\032\035.fo" +
      "rge_abi.ResponseGetNetInfo\022`\n\023get_valida" +
      "tors_info\022#.forge_abi.RequestGetValidato" +
      "rsInfo\032$.forge_abi.ResponseGetValidators" +
      "Info\022G\n\nget_config\022\033.forge_abi.RequestGe" +
      "tConfig\032\034.forge_abi.ResponseGetConfig2\242\001" +
      "\n\010EventRpc\022H\n\tsubscribe\022\033.forge_abi.Requ" +
      "estSubscribe\032\034.forge_abi.ResponseSubscri" +
      "be0\001\022L\n\013unsubscribe\022\035.forge_abi.RequestU" +
      "nsubscribe\032\036.forge_abi.ResponseUnsubscri",
      "be2\337\001\n\007FileRpc\022I\n\nstore_file\022\033.forge_abi" +
      ".RequestStoreFile\032\034.forge_abi.ResponseSt" +
      "oreFile(\001\022F\n\tload_file\022\032.forge_abi.Reque" +
      "stLoadFile\032\033.forge_abi.ResponseLoadFile0" +
      "\001\022A\n\010pin_file\022\031.forge_abi.RequestPinFile" +
      "\032\032.forge_abi.ResponsePinFile2\264\004\n\010StateRp" +
      "c\022^\n\021get_account_state\022!.forge_abi.Reque" +
      "stGetAccountState\032\".forge_abi.ResponseGe" +
      "tAccountState(\0010\001\022X\n\017get_asset_state\022\037.f" +
      "orge_abi.RequestGetAssetState\032 .forge_ab",
      "i.ResponseGetAssetState(\0010\001\022T\n\017get_forge" +
      "_state\022\037.forge_abi.RequestGetForgeState\032" +
      " .forge_abi.ResponseGetForgeState\022a\n\022get" +
      "_protocol_state\022\".forge_abi.RequestGetPr" +
      "otocolState\032#.forge_abi.ResponseGetProto" +
      "colState(\0010\001\022X\n\017get_stake_state\022\037.forge_" +
      "abi.RequestGetStakeState\032 .forge_abi.Res" +
      "ponseGetStakeState(\0010\001\022[\n\020get_tether_sta" +
      "te\022 .forge_abi.RequestGetTetherState\032!.f" +
      "orge_abi.ResponseGetTetherState(\0010\0012\355\003\n\t",
      "WalletRpc\022P\n\rcreate_wallet\022\036.forge_abi.R" +
      "equestCreateWallet\032\037.forge_abi.ResponseC" +
      "reateWallet\022J\n\013load_wallet\022\034.forge_abi.R" +
      "equestLoadWallet\032\035.forge_abi.ResponseLoa" +
      "dWallet\022S\n\016recover_wallet\022\037.forge_abi.Re" +
      "questRecoverWallet\032 .forge_abi.ResponseR" +
      "ecoverWallet\022L\n\013list_wallet\022\034.forge_abi." +
      "RequestListWallet\032\035.forge_abi.ResponseLi" +
      "stWallet0\001\022P\n\rremove_wallet\022\036.forge_abi." +
      "RequestRemoveWallet\032\037.forge_abi.Response",
      "RemoveWallet\022M\n\014declare_node\022\035.forge_abi" +
      ".RequestDeclareNode\032\036.forge_abi.Response" +
      "DeclareNode2\346\006\n\010StatsRpc\022T\n\017get_forge_st" +
      "ats\022\037.forge_abi.RequestGetForgeStats\032 .f" +
      "orge_abi.ResponseGetForgeStats\022\\\n\021list_t" +
      "ransactions\022\".forge_abi.RequestListTrans" +
      "actions\032#.forge_abi.ResponseListTransact" +
      "ions\022J\n\013list_assets\022\034.forge_abi.RequestL" +
      "istAssets\032\035.forge_abi.ResponseListAssets" +
      "\022J\n\013list_stakes\022\034.forge_abi.RequestListS",
      "takes\032\035.forge_abi.ResponseListStakes\022M\n\014" +
      "list_account\022\035.forge_abi.RequestListAcco" +
      "unt\032\036.forge_abi.ResponseListAccount\022Z\n\021l" +
      "ist_top_accounts\022!.forge_abi.RequestList" +
      "TopAccounts\032\".forge_abi.ResponseListTopA" +
      "ccounts\022l\n\027list_asset_transactions\022\'.for" +
      "ge_abi.RequestListAssetTransactions\032(.fo" +
      "rge_abi.ResponseListAssetTransactions\022J\n" +
      "\013list_blocks\022\034.forge_abi.RequestListBloc" +
      "ks\032\035.forge_abi.ResponseListBlocks\022Z\n\021get",
      "_health_status\022!.forge_abi.RequestGetHea" +
      "lthStatus\032\".forge_abi.ResponseGetHealthS" +
      "tatus\022M\n\014list_tethers\022\035.forge_abi.Reques" +
      "tListTethers\032\036.forge_abi.ResponseListTet" +
      "hersb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          forge_abi.Rpc.getDescriptor(),
        }, assigner);
    forge_abi.Rpc.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
