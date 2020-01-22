package io.arcblock.forge.abtdid;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author       : shan@arcblock.io
 * Time         : 2020-01-19
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
@ConfigurationProperties("abt.did.app")
public class AbtDidServiceProperties {
  /**
   * forge chain host such as http://localhost:8210/api
   */
  private String chainHost;

  /**
   * your application name you want to be shown on UI
   */
  private String name;
  /**
   * your app's host
   */
  private String host;
  /**
   * you app's logo
   */
  private String logo;
  /**
   * deep link path, usually https://abtwallet.io/i/
   */
  private String path;
  /**
   * description about your app
   */
  private String desc;
  /**
   * your application
   */
  private String publisher;


  public String getChainHost() {
    return chainHost;
  }

  public void setChainHost(String chainHost) {
    this.chainHost = chainHost;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }
}
