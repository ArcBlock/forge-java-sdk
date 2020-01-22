package io.arcblock.forge.abtdid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.arcblock.forge.did.bean.AppInfo;

/**
 * Author       : shan@arcblock.io
 * Time         : 2020-01-19
 * Edited By    :
 * Edited Time  :
 * Description  :
 **/
@Configuration
@ConditionalOnClass(AbtDidService.class)
@EnableConfigurationProperties(AbtDidServiceProperties.class)
public class AbtDidConfigure {
  @Autowired
  private AbtDidServiceProperties properties;

  @Bean
  @ConditionalOnMissingBean
  @ConditionalOnProperty(prefix = "abt.did", value = "enabled", havingValue = "true")
  AbtDidService provideAbtService() {
    return new AbtDidService(new AppInfo(properties.getChainHost(),properties.getName(),properties.getLogo(),properties.getDesc(),properties.getPublisher()),
      properties.getHost());
  }
}
