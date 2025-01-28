package cn.bugstack.chatgpt.data.config;

import cn.bugstack.deepseek.session.OpenAiSession;
import cn.bugstack.deepseek.session.OpenAiSessionFactory;
import cn.bugstack.deepseek.session.defaults.DefaultOpenAiSessionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description ChatGPTSDKConfig 工厂配置开启
 * @create 2023-07-16 08:07
 */
@Configuration
@EnableConfigurationProperties(DeepseekSDKConfigProperties.class)
public class DeepseekSDKConfig {

    @Bean(name = "deepseekOpenAiSession")
    @ConditionalOnProperty(value = "deepseek.sdk.config.enabled", havingValue = "true", matchIfMissing = false)
    public OpenAiSession openAiSession(ChatGPTSDKConfigProperties properties) {
        // 1. 配置文件
        cn.bugstack.deepseek.session.Configuration configuration = new cn.bugstack.deepseek.session.Configuration();
        configuration.setApiHost(properties.getApiHost());
        configuration.setApiKey(properties.getApiKey());

        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);

        // 3. 开启会话
        return factory.openSession();
    }

}
