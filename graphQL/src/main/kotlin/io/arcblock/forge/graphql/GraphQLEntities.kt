package io.arcblock.forge.graphql

import io.aexp.nodes.graphql.annotations.GraphQLArgument
import io.aexp.nodes.graphql.annotations.GraphQLProperty

@GraphQLProperty(
  name="getBlocks",
  arguments=arrayOf(GraphQLArgument(name="emptyExcluded", optional = true
      ),GraphQLArgument(name="heightFilter", optional = true ),GraphQLArgument(name="paging",
      optional = true ))
)
data class ResponseGetBlocks @JvmOverloads constructor(
  val blocks: List<BlockInfoSimple>? = null,
  val code: String? = null,
  val page: PageInfo? = null
)

data class BlockId @JvmOverloads constructor(
  val hash: String? = null,
  val partsHeader: PartSetHeader? = null
)

@GraphQLProperty(
  name="listSwap",
  arguments=arrayOf(GraphQLArgument(name="available", optional = true
      ),GraphQLArgument(name="paging", optional = true ),GraphQLArgument(name="receiver", optional =
      true ),GraphQLArgument(name="sender", optional = true ))
)
data class ResponseListSwap @JvmOverloads constructor(
  val code: String? = null,
  val page: PageInfo? = null,
  val swap: List<SwapState>? = null
)

@GraphQLProperty(
  name="getForgeStats",
  arguments=arrayOf()
)
data class GetForgeStats @JvmOverloads constructor(
  val code: String? = null,
  val forgeStats: ForgeStats? = null
)

@GraphQLProperty(
  name="getForgeStatsByDay",
  arguments=arrayOf(GraphQLArgument(name="endDate", optional = true
      ),GraphQLArgument(name="startDate", optional = true ))
)
data class GetForgeStatsByDay @JvmOverloads constructor(
  val code: String? = null,
  val forgeStats: ForgeStats? = null
)

@GraphQLProperty(
  name="getForgeStatsByHour",
  arguments=arrayOf(GraphQLArgument(name="date", optional = true ))
)
data class GetForgeStatsByHour @JvmOverloads constructor(
  val code: String? = null,
  val forgeStats: ForgeStats? = null
)

@GraphQLProperty(
  name="listTopAccounts",
  arguments=arrayOf(GraphQLArgument(name="paging", optional = true ))
)
data class ResponseListTopAccounts @JvmOverloads constructor(
  val accounts: List<IndexedAccountState>? = null,
  val code: String? = null,
  val page: PageInfo? = null
)

data class DiskSpaceStatus @JvmOverloads constructor(
  val forgeUsage: String? = null,
  val total: String? = null
)

data class ExchangeInfo @JvmOverloads constructor(
  val assets: List<String>? = null,
  val value: String? = null
)

@GraphQLProperty(
  name="getAccountState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetAccountState @JvmOverloads constructor(
  val code: String? = null,
  val state: AccountState? = null
)

data class ConsensusStatus @JvmOverloads constructor(
  val blockHeight: String? = null,
  val health: Boolean? = null,
  val synced: Boolean? = null
)

enum class UpgradeType {
  CONFIG_APP,

  CONFIG_CONSENSUS,

  CONFIG_DFS,

  CONFIG_FORGE,

  CONFIG_P2P,

  EXE_APP,

  EXE_CONSENSUS,

  EXE_DFS,

  EXE_FORGE,

  EXE_P2P
}

data class RetrieveSwapTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val hashkey: String? = null
)

data class StakeSummary @JvmOverloads constructor(
  val context: StateContext? = null,
  val totalStakes: String? = null,
  val totalUnstakes: String? = null
)

data class ForgeState @JvmOverloads constructor(
  val accountConfig: List<AccountConfigEntry>? = null,
  val address: String? = null,
  val consensus: ConsensusParams? = null,
  val data: Any? = null,
  val gas: List<GasEntry>? = null,
  val protocols: List<CoreProtocol>? = null,
  val stakeSummary: List<StakeSummaryEntry>? = null,
  val tasks: List<TasksEntry>? = null,
  val token: ForgeToken? = null,
  val tokenSwapConfig: TokenSwapConfig? = null,
  val txConfig: TransactionConfig? = null,
  val upgradeInfo: UpgradeInfo? = null,
  val version: String? = null
)

data class UnconfirmedTxs @JvmOverloads constructor(
  val nTxs: Int? = null,
  val txs: List<Transaction>? = null
)

data class PokeInfo @JvmOverloads constructor(
  val amount: String? = null,
  val dailyLimit: String? = null,
  val leftover: String? = null
)

data class Header @JvmOverloads constructor(
  val appHash: String? = null,
  val chainId: String? = null,
  val consensusHash: String? = null,
  val dataHash: String? = null,
  val evidenceHash: String? = null,
  val height: String? = null,
  val lastBlockId: BlockId? = null,
  val lastCommitHash: String? = null,
  val lastResultsHash: String? = null,
  val nextValidatorsHash: String? = null,
  val numTxs: String? = null,
  val proposerAddress: String? = null,
  val time: String? = null,
  val totalTxs: String? = null,
  val validatorsHash: String? = null,
  val version: Version? = null
)

data class PubKey @JvmOverloads constructor(
  val data: String? = null,
  val type: String? = null
)

enum class Direction {
  MUTUAL,

  ONE_WAY,

  UNION
}

data class KvPair @JvmOverloads constructor(
  val key: String? = null,
  val value: String? = null
)

@GraphQLProperty(
  name="getValidatorsInfo",
  arguments=arrayOf()
)
data class ResponseGetValidatorsInfo @JvmOverloads constructor(
  val code: String? = null,
  val validatorsInfo: ValidatorsInfo? = null
)

data class OpsEntry @JvmOverloads constructor(
  val key: String? = null,
  val value: DelegateOpState? = null
)

data class Any @JvmOverloads constructor(
  val typeUrl: String? = null,
  val value: String? = null
)

data class NetworkStatus @JvmOverloads constructor(
  val health: Boolean? = null,
  val numPeers: Int? = null
)

data class StakeState @JvmOverloads constructor(
  val address: String? = null,
  val balance: String? = null,
  val context: StateContext? = null,
  val data: Any? = null,
  val from: String? = null,
  val message: String? = null,
  val to: String? = null
)

data class CoreProtocol @JvmOverloads constructor(
  val address: String? = null,
  val name: String? = null
)

data class TransactionInfo @JvmOverloads constructor(
  val code: String? = null,
  val hash: String? = null,
  val height: String? = null,
  val index: Int? = null,
  val tags: List<KvPair>? = null,
  val time: String? = null,
  val tx: Transaction? = null
)

@GraphQLProperty(
  name="listTransactions",
  arguments=arrayOf(GraphQLArgument(name="addressFilter", optional = true
      ),GraphQLArgument(name="paging", optional = true ),GraphQLArgument(name="timeFilter", optional
      = true ),GraphQLArgument(name="typeFilter", optional = true
      ),GraphQLArgument(name="validityFilter", optional = true ))
)
data class ResponseListTransactions @JvmOverloads constructor(
  val code: String? = null,
  val page: PageInfo? = null,
  val transactions: List<IndexedTransaction>? = null
)

data class ForgeStats @JvmOverloads constructor(
  val avgBlockTime: Float? = null,
  val avgTps: Int? = null,
  val maxTps: Int? = null,
  val numAccountMigrateTxs: List<String>? = null,
  val numBlocks: List<String>? = null,
  val numConsensusUpgradeTxs: List<Int>? = null,
  val numConsumeAssetTxs: List<String>? = null,
  val numCreateAssetTxs: List<String>? = null,
  val numDeclareFileTxs: List<String>? = null,
  val numDeclareTxs: List<String>? = null,
  val numExchangeTxs: List<String>? = null,
  val numPokeTxs: List<String>? = null,
  val numStakeTxs: List<String>? = null,
  val numStakes: List<String>? = null,
  val numSysUpgradeTxs: List<Int>? = null,
  val numTransferTxs: List<String>? = null,
  val numTxs: List<String>? = null,
  val numUpdateAssetTxs: List<String>? = null,
  val numValidators: List<Int>? = null,
  val tps: List<Int>? = null
)

enum class HashType {
  KECCAK,

  KECCAK_384,

  KECCAK_512,

  SHA2,

  SHA3,

  SHA3_384,

  SHA3_512
}

data class AbciServerStatus @JvmOverloads constructor(
  val abciConsensus: String? = null,
  val abciInfo: String? = null
)

data class Version @JvmOverloads constructor(
  val app: String? = null,
  val block: String? = null
)

@GraphQLProperty(
  name="listAssetTransactions",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="paging",
      optional = true ))
)
data class ResponseListAssetTransactions @JvmOverloads constructor(
  val code: String? = null,
  val page: PageInfo? = null,
  val transactions: List<IndexedTransaction>? = null
)

@GraphQLProperty(
  name="getStakeState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetStakeState @JvmOverloads constructor(
  val code: String? = null,
  val state: StakeState? = null
)

@GraphQLProperty(
  name="unsubscribe",
  arguments=arrayOf(GraphQLArgument(name="topic", optional = true ))
)
data class ResponseUnsubscribe @JvmOverloads constructor(
  val code: String? = null
)

data class ValidatorsInfo @JvmOverloads constructor(
  val blockHeight: String? = null,
  val validators: List<ValidatorInfo>? = null
)

data class DelegateState @JvmOverloads constructor(
  val address: String? = null,
  val context: StateContext? = null,
  val data: Any? = null,
  val ops: List<OpsEntry>? = null
)

data class Multisig @JvmOverloads constructor(
  val data: Any? = null,
  val delegator: String? = null,
  val pk: String? = null,
  val signature: String? = null,
  val signer: String? = null
)

data class ValidatorInfo @JvmOverloads constructor(
  val address: String? = null,
  val geoInfo: GeoInfo? = null,
  val name: String? = null,
  val proposerPriority: String? = null,
  val pubKey: PubKey? = null,
  val votingPower: String? = null
)

data class IndexedAssetState @JvmOverloads constructor(
  val address: String? = null,
  val consumedTime: String? = null,
  val data: Any? = null,
  val genesisTime: String? = null,
  val issuer: String? = null,
  val moniker: String? = null,
  val owner: String? = null,
  val parent: String? = null,
  val readonly: Boolean? = null,
  val renaissanceTime: String? = null,
  val transferrable: Boolean? = null,
  val ttl: String? = null
)

data class IndexedStakeState @JvmOverloads constructor(
  val address: String? = null,
  val balance: String? = null,
  val genesisTime: String? = null,
  val message: String? = null,
  val receiver: String? = null,
  val renaissanceTime: String? = null,
  val sender: String? = null,
  val type: Int? = null
)

@GraphQLProperty(
  name="getHealthStatus",
  arguments=arrayOf()
)
data class ResponseGetHealthStatus @JvmOverloads constructor(
  val code: String? = null,
  val healthStatus: HealthStatus? = null
)

@GraphQLProperty(
  name="listStakes",
  arguments=arrayOf(GraphQLArgument(name="addressFilter", optional = true
      ),GraphQLArgument(name="paging", optional = true ))
)
data class ResponseListStakes @JvmOverloads constructor(
  val code: String? = null,
  val page: PageInfo? = null,
  val stakes: List<IndexedStakeState>? = null
)

data class ForgeToken @JvmOverloads constructor(
  val decimal: Int? = null,
  val description: String? = null,
  val icon: String? = null,
  val inflationRate: Int? = null,
  val initialSupply: String? = null,
  val name: String? = null,
  val symbol: String? = null,
  val totalSupply: String? = null,
  val unit: String? = null
)

@GraphQLProperty(
  name="getChainInfo",
  arguments=arrayOf()
)
data class ResponseGetChainInfo @JvmOverloads constructor(
  val code: String? = null,
  val info: ChainInfo? = null
)

data class StakeConfig @JvmOverloads constructor(
  val timeoutGeneral: Int? = null,
  val timeoutStakeForNode: Int? = null
)

data class NetInfo @JvmOverloads constructor(
  val listeners: List<String>? = null,
  val listening: Boolean? = null,
  val nPeers: Int? = null,
  val peers: List<PeerInfo>? = null
)

data class LastCommitInfo @JvmOverloads constructor(
  val round: Int? = null,
  val votes: List<VoteInfo>? = null
)

@GraphQLProperty(
  name="getNodeInfo",
  arguments=arrayOf()
)
data class ResponseGetNodeInfo @JvmOverloads constructor(
  val code: String? = null,
  val info: NodeInfo? = null
)

data class HealthStatus @JvmOverloads constructor(
  val consensus: ConsensusStatus? = null,
  val forge: ForgeStatus? = null,
  val network: NetworkStatus? = null,
  val storage: StorageStatus? = null
)

enum class StatusCode {
  EXPIRED_ASSET,

  INVALID_DELEGATION,

  INVALID_MONIKER,

  INVALID_DELEGATION_RULE,

  FORBIDDEN,

  CONSUMED_ASSET,

  INVALID_DEPOSITOR,

  INSUFFICIENT_GAS,

  INVALID_ASSET,

  INVALID_CHAIN_TYPE,

  UNTRANSFERRABLE_ASSET,

  INVALID_NONCE,

  PROTOCOL_NOT_PAUSED,

  INVALID_WITHDRAWER,

  ACCOUNT_MIGRATED,

  WITHDRAW_ITEM_MISSING,

  INVALID_MULTISIG,

  INVALID_TIME,

  INVALID_DELEGATION_TYPE_URL,

  INSUFFICIENT_FUND,

  INVALID_WITHDRAW_TX,

  INVALID_CUSTODIAN,

  UNSUPPORTED_STAKE,

  CONSENSUS_RPC_ERROR,

  INVALID_SWAP,

  INVALID_PASSPHRASE,

  INVALID_EXPIRY_DATE,

  INVALID_HASHKEY,

  INSUFFICIENT_STAKE,

  INVALID_DEACTIVATION,

  BANNED_UNSTAKE,

  INVALID_SENDER_STATE,

  INVALID_DEPOSIT,

  INVALID_LOCK_STATUS,

  INVALID_SIGNATURE,

  INSUFFICIENT_DATA,

  INTERNAL,

  INVALID_STAKE_STATE,

  INVALID_WALLET,

  EXPIRED_WALLET_TOKEN,

  UNSUPPORTED_TX,

  SENDER_NOT_AUTHORIZED,

  RPC_CONNECTION_ERROR,

  INVALID_SUBSCRIBE,

  EXCEED_DEPOSIT_CAP,

  INVALID_REQUEST,

  INVALID_SIGNER_STATE,

  PROTOCOL_NOT_RUNNING,

  INVALID_CHAIN_ID,

  INVALID_RECEIVER_STATE,

  INVALID_TX_SIZE,

  INVALID_FORGE_STATE,

  TIMEOUT,

  PROTOCOL_NOT_ACTIVATED,

  TOO_MANY_TXS,

  INVALID_DEPOSIT_TARGET,

  INVALID_DEPOSIT_VALUE,

  EXPIRED_TX,

  NOENT,

  SENDER_WITHDRAW_ITEMS_FULL,

  STORAGE_RPC_ERROR,

  INSUFFICIENT_DELEGATION,

  INVALID_TX,

  READONLY_ASSET,

  INVALID_OWNER,

  OK
}

data class CreateAssetTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val moniker: String? = null,
  val parent: String? = null,
  val readonly: Boolean? = null,
  val transferrable: Boolean? = null,
  val ttl: Int? = null
)

@GraphQLProperty(
  name="listBlocks",
  arguments=arrayOf(GraphQLArgument(name="heightFilter", optional = true
      ),GraphQLArgument(name="numInvalidTxsFilter", optional = true
      ),GraphQLArgument(name="numTxsFilter", optional = true ),GraphQLArgument(name="paging",
      optional = true ),GraphQLArgument(name="proposer", optional = true
      ),GraphQLArgument(name="timeFilter", optional = true ))
)
data class ResponseListBlocks @JvmOverloads constructor(
  val blocks: List<IndexedBlock>? = null,
  val code: String? = null,
  val page: PageInfo? = null
)

data class GasEntry @JvmOverloads constructor(
  val key: String? = null,
  val value: Int? = null
)

data class SetupSwapTx @JvmOverloads constructor(
  val assets: List<String>? = null,
  val data: Any? = null,
  val hashlock: String? = null,
  val locktime: Int? = null,
  val receiver: String? = null,
  val value: String? = null
)

data class UpgradeInfo @JvmOverloads constructor(
  val height: String? = null,
  val version: String? = null
)

data class ExchangeTx @JvmOverloads constructor(
  val data: Any? = null,
  val expiredAt: String? = null,
  val receiver: ExchangeInfo? = null,
  val sender: ExchangeInfo? = null,
  val to: String? = null
)

enum class RoleType {
  ROLE_ACCOUNT,

  ROLE_ANY,

  ROLE_APPLICATION,

  ROLE_ASSET,

  ROLE_BOT,

  ROLE_DEVICE,

  ROLE_GROUP,

  ROLE_NODE,

  ROLE_SMART_CONTRACT,

  ROLE_STAKE,

  ROLE_TX,

  ROLE_VALIDATOR
}

data class AcquireAssetTx @JvmOverloads constructor(
  val data: Any? = null,
  val specs: List<AssetSpec>? = null,
  val to: String? = null
)

data class PartSetHeader @JvmOverloads constructor(
  val hash: String? = null,
  val total: Int? = null
)

data class StateContext @JvmOverloads constructor(
  val genesisTime: String? = null,
  val genesisTx: TransactionInfo? = null,
  val renaissanceTime: String? = null,
  val renaissanceTx: TransactionInfo? = null
)

data class ConsensusUpgradeTx @JvmOverloads constructor(
  val data: Any? = null,
  val maxBytes: String? = null,
  val maxCandidates: Int? = null,
  val maxGas: String? = null,
  val maxValidators: Int? = null,
  val validators: List<Validator>? = null
)

data class IndexedBlock @JvmOverloads constructor(
  val height: String? = null,
  val numInvalidTxs: String? = null,
  val numTxs: String? = null,
  val proposer: String? = null,
  val time: String? = null
)

data class SwapState @JvmOverloads constructor(
  val address: String? = null,
  val assets: List<String>? = null,
  val context: StateContext? = null,
  val hash: String? = null,
  val hashkey: String? = null,
  val hashlock: String? = null,
  val locktime: Int? = null,
  val receiver: String? = null,
  val sender: String? = null,
  val value: String? = null
)

data class RequestEndBlock @JvmOverloads constructor(
  val height: String? = null
)

data class ChainInfo @JvmOverloads constructor(
  val address: String? = null,
  val appHash: String? = null,
  val blockHash: String? = null,
  val blockHeight: String? = null,
  val blockTime: String? = null,
  val consensusVersion: String? = null,
  val forgeAppsVersion: List<ForgeAppsVersionEntry>? = null,
  val id: String? = null,
  val moniker: String? = null,
  val network: String? = null,
  val supportedTxs: List<String>? = null,
  val synced: Boolean? = null,
  val totalTxs: String? = null,
  val version: String? = null,
  val votingPower: String? = null
)

data class BlockInfo @JvmOverloads constructor(
  val appHash: String? = null,
  val consensusHash: String? = null,
  val dataHash: String? = null,
  val evidenceHash: String? = null,
  val height: String? = null,
  val invalidTxs: List<TransactionInfo>? = null,
  val invalidTxsHashes: List<String>? = null,
  val lastBlockId: BlockId? = null,
  val lastCommitHash: String? = null,
  val lastResultsHash: String? = null,
  val nextValidatorsHash: String? = null,
  val numTxs: Int? = null,
  val proposer: String? = null,
  val time: String? = null,
  val totalTxs: String? = null,
  val txs: List<TransactionInfo>? = null,
  val txsHashes: List<String>? = null,
  val validatorsHash: String? = null,
  val version: Version? = null
)

data class VoteInfo @JvmOverloads constructor(
  val signedLastBlock: Boolean? = null,
  val validator: Validator? = null
)

data class RequestBeginBlock @JvmOverloads constructor(
  val byzantineValidators: List<Evidence>? = null,
  val hash: String? = null,
  val header: Header? = null,
  val lastCommitInfo: LastCommitInfo? = null
)

data class IndexedAccountState @JvmOverloads constructor(
  val address: String? = null,
  val balance: String? = null,
  val genesisTime: String? = null,
  val migratedFrom: String? = null,
  val migratedTo: String? = null,
  val moniker: String? = null,
  val nonce: String? = null,
  val numAssets: String? = null,
  val numTxs: String? = null,
  val recentNumTxs: List<String>? = null,
  val renaissanceTime: String? = null,
  val totalReceivedStakes: String? = null,
  val totalStakes: String? = null,
  val totalUnstakes: String? = null
)

@GraphQLProperty(
  name="getProtocols",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ))
)
data class ResponseGetProtocols @JvmOverloads constructor(
  val code: String? = null,
  val protocols: List<Protocol>? = null
)

data class StakeTx @JvmOverloads constructor(
  val data: StakeDataType? = null,
  val message: String? = null,
  val to: String? = null,
  val value: String? = null
)

data class Protocol @JvmOverloads constructor(
  val address: String? = null,
  val code: List<CodeInfo>? = null,
  val data: Any? = null,
  val description: String? = null,
  val group: String? = null,
  val installedAt: String? = null,
  val name: String? = null,
  val namespace: String? = null,
  val pipeline: String? = null,
  val proto: String? = null,
  val sources: List<String>? = null,
  val typeUrls: List<TypeUrls>? = null,
  val version: Int? = null
)

data class AssetSpec @JvmOverloads constructor(
  val address: String? = null,
  val data: String? = null
)

data class SysUpgradeTx @JvmOverloads constructor(
  val data: Any? = null,
  val gracePeriod: String? = null,
  val task: UpgradeTask? = null
)

data class AccountMigrateTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val pk: String? = null,
  val type: WalletType? = null
)

data class UpgradeTasks @JvmOverloads constructor(
  val item: List<UpgradeTask>? = null
)

@GraphQLProperty(
  name="getProtocolState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetProtocolState @JvmOverloads constructor(
  val code: String? = null,
  val state: ProtocolState? = null
)

data class AccountConfig @JvmOverloads constructor(
  val address: String? = null,
  val balance: String? = null,
  val pk: String? = null
)

data class Transaction @JvmOverloads constructor(
  val chainId: String? = null,
  val delegator: String? = null,
  val from: String? = null,
  val itxJson: String? = null,
  val nonce: String? = null,
  val pk: String? = null,
  val signature: String? = null,
  val signatures: List<Multisig>? = null
)

data class AccountConfigEntry @JvmOverloads constructor(
  val key: String? = null,
  val value: AccountConfig? = null
)

data class StakeSummaryEntry @JvmOverloads constructor(
  val key: Int? = null,
  val value: StakeSummary? = null
)

data class PokeTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val date: String? = null
)

data class TransferTx @JvmOverloads constructor(
  val assets: List<String>? = null,
  val data: Any? = null,
  val to: String? = null,
  val value: String? = null
)

data class DelegateOpState @JvmOverloads constructor(
  val balance: String? = null,
  val balanceDelta: String? = null,
  val numTxs: String? = null,
  val numTxsDelta: String? = null,
  val rule: String? = null
)

data class AssetState @JvmOverloads constructor(
  val address: String? = null,
  val consumedTime: String? = null,
  val context: StateContext? = null,
  val data: Any? = null,
  val issuer: String? = null,
  val moniker: String? = null,
  val owner: String? = null,
  val parent: String? = null,
  val readonly: Boolean? = null,
  val stake: StakeContext? = null,
  val transferrable: Boolean? = null,
  val ttl: Int? = null
)

data class StakeDataType @JvmOverloads constructor(
  val type: String? = null
)

data class StorageStatus @JvmOverloads constructor(
  val diskSpace: DiskSpaceStatus? = null,
  val health: Boolean? = null,
  val indexerServer: String? = null,
  val stateDb: String? = null
)

data class ConsensusParams @JvmOverloads constructor(
  val maxBytes: String? = null,
  val maxCandidates: Int? = null,
  val maxGas: String? = null,
  val maxValidators: Int? = null,
  val paramChanged: Boolean? = null,
  val pubKeyTypes: List<String>? = null,
  val validatorChanged: Boolean? = null,
  val validators: List<Validator>? = null
)

data class BlockInfoSimple @JvmOverloads constructor(
  val appHash: String? = null,
  val consensusHash: String? = null,
  val dataHash: String? = null,
  val evidenceHash: String? = null,
  val height: String? = null,
  val invalidTxsHashes: List<String>? = null,
  val lastBlockId: BlockId? = null,
  val lastCommitHash: String? = null,
  val lastResultsHash: String? = null,
  val nextValidatorsHash: String? = null,
  val numTxs: Int? = null,
  val proposer: String? = null,
  val time: String? = null,
  val totalTxs: String? = null,
  val txsHashes: List<String>? = null,
  val validatorsHash: String? = null,
  val version: Version? = null
)

data class DeployProtocolTx @JvmOverloads constructor(
  val address: String? = null,
  val code: List<CodeInfo>? = null,
  val data: Any? = null,
  val description: String? = null,
  val name: String? = null,
  val namespace: String? = null,
  val pipeline: String? = null,
  val proto: String? = null,
  val sources: List<String>? = null,
  val tags: List<String>? = null,
  val typeUrls: List<TypeUrls>? = null,
  val version: Int? = null
)

data class RevokeSwapTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null
)

data class PokeConfig @JvmOverloads constructor(
  val amount: String? = null,
  val dailyLimit: String? = null,
  val enabled: Boolean? = null
)

data class DeclareConfig @JvmOverloads constructor(
  val hierarchy: Int? = null,
  val restricted: Boolean? = null
)

data class Evidence @JvmOverloads constructor(
  val chainId: String? = null,
  val chainType: String? = null,
  val hash: String? = null,
  val originalTx: String? = null,
  val receiverAddress: String? = null
)

data class DelegateConfig @JvmOverloads constructor(
  val deltaInterval: Int? = null,
  val typeUrls: List<String>? = null
)

data class AccountState @JvmOverloads constructor(
  val address: String? = null,
  val balance: String? = null,
  val context: StateContext? = null,
  val data: Any? = null,
  val issuer: String? = null,
  val migratedFrom: List<String>? = null,
  val migratedTo: List<String>? = null,
  val moniker: String? = null,
  val nonce: String? = null,
  val numAssets: String? = null,
  val numTxs: String? = null,
  val pk: String? = null,
  val poke: PokeInfo? = null,
  val stake: StakeContext? = null,
  val type: WalletType? = null
)

data class TokenSwapConfig @JvmOverloads constructor(
  val commission: String? = null,
  val commissionHolderAddress: String? = null,
  val commissionRate: Int? = null,
  val revokeCommission: Int? = null,
  val withdrawInterval: Int? = null
)

data class ForgeAppsVersionEntry @JvmOverloads constructor(
  val key: String? = null,
  val value: String? = null
)

data class TasksEntry @JvmOverloads constructor(
  val key: String? = null,
  val value: UpgradeTasks? = null
)

data class ProtocolState @JvmOverloads constructor(
  val address: String? = null,
  val context: StateContext? = null,
  val data: Any? = null,
  val group: String? = null,
  val itx: DeployProtocolTx? = null,
  val migratedFrom: List<String>? = null,
  val migratedTo: List<String>? = null,
  val rootHash: String? = null,
  val status: String? = null
)

data class PageInfo @JvmOverloads constructor(
  val cursor: String? = null,
  val next: Boolean? = null,
  val total: Int? = null
)

@GraphQLProperty(
  name="getTx",
  arguments=arrayOf(GraphQLArgument(name="hash", optional = true ))
)
data class ResponseGetTx @JvmOverloads constructor(
  val code: String? = null,
  val info: TransactionInfo? = null
)

data class UpdateAssetTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val moniker: String? = null
)

data class StakeContext @JvmOverloads constructor(
  val recentReceivedStakes: CircularQueue? = null,
  val recentStakes: CircularQueue? = null,
  val totalReceivedStakes: String? = null,
  val totalStakes: String? = null,
  val totalUnstakes: String? = null
)

@GraphQLProperty(
  name="startSimulator",
  arguments=arrayOf()
)
data class ResponseStartSimulator @JvmOverloads constructor(
  val code: String? = null
)

data class ConsumeAssetTx @JvmOverloads constructor(
  val address: String? = null,
  val data: Any? = null,
  val issuer: String? = null
)

data class DeclareTx @JvmOverloads constructor(
  val data: Any? = null,
  val issuer: String? = null,
  val moniker: String? = null
)

@GraphQLProperty(
  name="stopSimulator",
  arguments=arrayOf()
)
data class ResponseStopSimulator @JvmOverloads constructor(
  val code: String? = null
)

@GraphQLProperty(
  name="getSwapState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetSwapState @JvmOverloads constructor(
  val code: String? = null,
  val state: SwapState? = null
)

data class UpgradeTask @JvmOverloads constructor(
  val actions: List<UpgradeAction>? = null,
  val dataHash: String? = null,
  val type: UpgradeType? = null
)

@GraphQLProperty(
  name="listAssets",
  arguments=arrayOf(GraphQLArgument(name="ownerAddress", optional = true
      ),GraphQLArgument(name="paging", optional = true ))
)
data class ResponseListAssets @JvmOverloads constructor(
  val account: IndexedAccountState? = null,
  val assets: List<IndexedAssetState>? = null,
  val code: String? = null,
  val page: PageInfo? = null
)

@GraphQLProperty(
  name="getUnconfirmedTxs",
  arguments=arrayOf(GraphQLArgument(name="paging", optional = true ))
)
data class ResponseGetUnconfirmedTxs @JvmOverloads constructor(
  val code: String? = null,
  val page: PageInfo? = null,
  val unconfirmedTxs: UnconfirmedTxs? = null
)

data class UpgradeNodeTx @JvmOverloads constructor(
  val height: String? = null,
  val override: Boolean? = null,
  val version: String? = null
)

@GraphQLProperty(
  name="getConfig",
  arguments=arrayOf(GraphQLArgument(name="parsed", optional = true ))
)
data class ResponseGetConfig @JvmOverloads constructor(
  val code: String? = null,
  val config: String? = null
)

@GraphQLProperty(
  name="getSimulatorStatus",
  arguments=arrayOf()
)
data class ResponseGetSimulatorStatus @JvmOverloads constructor(
  val code: String? = null,
  val result: String? = null
)

data class CircularQueue @JvmOverloads constructor(
  val circular: Boolean? = null,
  val fifo: Boolean? = null,
  val items: List<String>? = null,
  val maxItems: Int? = null,
  val typeUrl: String? = null
)

@GraphQLProperty(
  name="getBlock",
  arguments=arrayOf(GraphQLArgument(name="height", optional = true ))
)
data class ResponseGetBlock @JvmOverloads constructor(
  val block: BlockInfo? = null,
  val code: String? = null
)

enum class EncodingType {
  BASE16,

  BASE58
}

enum class Validity {
  BOTH,

  INVALID,

  VALID
}

data class TransactionConfig @JvmOverloads constructor(
  val declare: DeclareConfig? = null,
  val delegate: DelegateConfig? = null,
  val maxAssetSize: Int? = null,
  val maxListSize: Int? = null,
  val maxMultisig: Int? = null,
  val minimumStake: String? = null,
  val poke: PokeConfig? = null,
  val stake: StakeConfig? = null
)

data class GeoInfo @JvmOverloads constructor(
  val city: String? = null,
  val country: String? = null,
  val latitude: Float? = null,
  val longitude: Float? = null
)

@GraphQLProperty(
  name="getNetInfo",
  arguments=arrayOf()
)
data class ResponseGetNetInfo @JvmOverloads constructor(
  val code: String? = null,
  val netInfo: NetInfo? = null
)

data class ForgeStatus @JvmOverloads constructor(
  val abciServer: AbciServerStatus? = null,
  val abiServer: String? = null,
  val forgeWeb: String? = null,
  val health: Boolean? = null
)

@GraphQLProperty(
  name="getForgeState",
  arguments=arrayOf(GraphQLArgument(name="height", optional = true ),GraphQLArgument(name="keys",
      optional = true ))
)
data class ResponseGetForgeState @JvmOverloads constructor(
  val code: String? = null,
  val state: ForgeState? = null
)

data class DeclareFileTx @JvmOverloads constructor(
  val hash: String? = null
)

data class Validator @JvmOverloads constructor(
  val address: String? = null,
  val power: String? = null
)

data class PeerInfo @JvmOverloads constructor(
  val consensusVersion: String? = null,
  val geoInfo: GeoInfo? = null,
  val id: String? = null,
  val ip: String? = null,
  val moniker: String? = null,
  val network: String? = null
)

enum class UpgradeAction {
  BACKUP,

  CRASH_IF_FAIL,

  DROP_ADDRESS_BOOK,

  REPLACE,

  RESTART_ALL_IF_FAIL,

  RESTART_APP,

  RESTART_CONSENSUS,

  RESTART_DFS,

  RESTART_FORGE,

  RESTART_P2P,

  ROLLBACK_IF_FAIL,

  VERIFY
}

@GraphQLProperty(
  name="getAssetState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetAssetState @JvmOverloads constructor(
  val code: String? = null,
  val state: AssetState? = null
)

@GraphQLProperty(
  name="getDelegateState",
  arguments=arrayOf(GraphQLArgument(name="address", optional = true ),GraphQLArgument(name="height",
      optional = true ),GraphQLArgument(name="keys", optional = true ))
)
data class ResponseGetDelegateState @JvmOverloads constructor(
  val code: String? = null,
  val state: DelegateState? = null
)

data class CodeInfo @JvmOverloads constructor(
  val binary: String? = null,
  val checksum: String? = null
)

enum class KeyType {
  ED25519,

  SECP256K1
}

data class NodeInfo @JvmOverloads constructor(
  val address: String? = null,
  val appHash: String? = null,
  val blockHash: String? = null,
  val blockHeight: String? = null,
  val blockTime: String? = null,
  val consensusVersion: String? = null,
  val forgeAppsVersion: List<ForgeAppsVersionEntry>? = null,
  val geoInfo: GeoInfo? = null,
  val id: String? = null,
  val ip: String? = null,
  val moniker: String? = null,
  val network: String? = null,
  val p2pAddress: String? = null,
  val supportedTxs: List<String>? = null,
  val synced: Boolean? = null,
  val totalTxs: String? = null,
  val version: String? = null,
  val votingPower: String? = null
)

data class WalletType @JvmOverloads constructor(
  val address: EncodingType? = null,
  val hash: HashType? = null,
  val pk: KeyType? = null,
  val role: RoleType? = null
)

@GraphQLProperty(
  name="sendTx",
  arguments=arrayOf(GraphQLArgument(name="commit", optional = true ),GraphQLArgument(name="token",
      optional = true ),GraphQLArgument(name="tx", optional = true ),GraphQLArgument(name="wallet",
      optional = true ))
)
data class ResponseSendTx @JvmOverloads constructor(
  val code: String? = null,
  val hash: String? = null
)

data class TypeUrls @JvmOverloads constructor(
  val module: String? = null,
  val url: String? = null
)

data class IndexedTransaction @JvmOverloads constructor(
  val code: String? = null,
  val hash: String? = null,
  val receiver: String? = null,
  val sender: String? = null,
  val time: String? = null,
  val tx: Transaction? = null,
  val type: String? = null,
  val valid: Boolean? = null
)
