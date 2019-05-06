#!/bin/sh
#"https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/tx.proto"  \
LIST=(
https://raw.githubusercontent.com/ArcBlock/ex_abci_proto/master/lib/protos/vendor.proto \

  "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/enum.proto" \
  "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/rpc.proto"  \

  "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/service.proto" \
 "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/state.proto" \
  "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/trace_type.proto" \
  "https://api.github.com/repos/ArcBlock/forge-abi/contents/lib/protobuf/type.proto"
 )

TLIST=(
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/account/account_migrate/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/account/declare/protocol.proto" \
   "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/asset/acquire_asset/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/asset/consume_asset/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/asset/create_asset/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/asset/update_asset/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/governance/deploy_protocol/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/governance/upgrade_node/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/misc/poke/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/stake/stake/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/trade/deposit_tether/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/trade/exchange/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/trade/exchange_tether/protocol.proto" \
  "https://api.github.com/repos/ArcBlock/forge-core-protocols/contents/lib/trade/transfer/protocol.proto" \
)

cd src/main/proto/
rm *.proto
for f in ${LIST[@]}
do
  echo $f
  echo "github: $GITHUB_TOKEN"
  curl -H "Authorization: token $GITHUB_TOKEN" -H 'Accept: application/vnd.github.v4.raw' -O -L $f
done

for f in ${TLIST[@]}
do
  echo $f
  tmp=${f##*lib/}
  tmp=${tmp%/*}
  tmp=${tmp##*/}.proto
  echo $tmp
  curl -H "Authorization: token $GITHUB_TOKEN" -H 'Accept: application/vnd.github.v4.raw' -o ${tmp//\//_}  -O -L $f
done


echo "finish"

