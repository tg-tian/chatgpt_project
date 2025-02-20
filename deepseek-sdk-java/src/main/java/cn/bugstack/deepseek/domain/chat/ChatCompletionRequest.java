package cn.bugstack.deepseek.domain.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 小傅哥，微信：fustack
 * @description 对话聊天，请求信息依照；OpenAI官网API构建参数；https://platform.openai.com/playground
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
@Builder
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatCompletionRequest implements Serializable {

    /** 默认模型 */
    private String model = Model.DEEPSEEK_V3.getCode();
    /** 问题描述 */
    private List<Message> messages;
    /** 控制温度【随机性】；0到2之间。较高的值(如0.8)将使输出更加随机，而较低的值(如0.2)将使输出更加集中和确定 */
    private double temperature = 1;
    /** 多样性控制；使用温度采样的替代方法称为核心采样，其中模型考虑具有top_p概率质量的令牌的结果。因此，0.1 意味着只考虑包含前 10% 概率质量的代币 */
    @JsonProperty("top_p")
    private Double topP = 1d;
    /** 是否为流式输出；就是一蹦一蹦的，出来结果 */
    private boolean stream = false;
    /** 停止输出标识 */
    private List<String> stop;
    /** 输出字符串限制；0 ~ 4096 */
    @JsonProperty("max_tokens")
    private Integer maxTokens = 2048;
    /** 频率惩罚；降低模型重复同一行的可能性 */
    @JsonProperty("frequency_penalty")
    private double frequencyPenalty = 0;
    /** 存在惩罚；增强模型谈论新话题的可能性 */
    @JsonProperty("presence_penalty")
    private double presencePenalty = 0;

    @Getter
    @AllArgsConstructor
    public enum Model {
        /** gpt-3.5-turbo */
        DEEPSEEK_V3("deepseek-chat"),
        /** GPT4.0 */
        DEEPSEEK_R1("deepseek-reasoner"),
        ;
        private String code;
    }

}
