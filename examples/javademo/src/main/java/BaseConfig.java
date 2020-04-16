import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.arcblock.forge.ForgeSDK;
import io.arcblock.forge.graphql.GraphQLClient;

/**
 * █████╗ ██████╗  ██████╗██████╗ ██╗      ██████╗  ██████╗██╗  ██╗
 * ██╔══██╗██╔══██╗██╔════╝██╔══██╗██║     ██╔═══██╗██╔════╝██║ ██╔╝
 * ███████║██████╔╝██║     ██████╔╝██║     ██║   ██║██║     █████╔╝
 * ██╔══██║██╔══██╗██║     ██╔══██╗██║     ██║   ██║██║     ██╔═██╗
 * ██║  ██║██║  ██║╚██████╗██████╔╝███████╗╚██████╔╝╚██████╗██║  ██╗
 * ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═════╝ ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝
 * Author       : shan@arcblock.io
 * Time         : 2019-11-29
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
class BaseConfig {

 public static Logger logger = LoggerFactory.getLogger("Forge");
 public static Integer serverPort= 28211;
 static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
 static GraphQLClient gql = new  GraphQLClient("http://localhost:8211/api");
 static ForgeSDK forge = ForgeSDK.Companion.connect("localhost", BaseConfig.serverPort);
 //wait for block commit
 static void waitForBlockCommit() {
  try {
   Thread.sleep(5000);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
 }

 static void printAccountBalance(String address){
//  AccountState account = gql.getAccountState(address).getResponse().getState();
//  if (account != null)
//   logger.info("\n\n\t"+ account.getMoniker() +" \n\t\tbalance\t\t\t\t:"+account.getBalance()+"\n\t\tAssets count\t:"+account.getNumAssets() +"\n\n");
//  else logger.error("account is null");
 }

 static void logPretty(Object any){
  try {
   logger.info("\n"+any.getClass().getSimpleName() +":\n"+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(any));
  } catch (JsonProcessingException e) {
   e.printStackTrace();
  }
 }


}
