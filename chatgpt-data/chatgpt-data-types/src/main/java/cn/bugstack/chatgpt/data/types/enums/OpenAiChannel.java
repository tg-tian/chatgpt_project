package cn.bugstack.chatgpt.data.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description OpenAi 渠道
 * @create 2023-10-15 14:01
 */
@Getter
@AllArgsConstructor
public enum OpenAiChannel {

    ChatGLM("ChatGLM"),
    ChatGPT("ChatGPT"),
    DeepSeek("DeepSeek")
    ;
    private final String code;

    public static OpenAiChannel getChannel(String model) {
        if (model.toLowerCase().contains("gpt") || model.toLowerCase().contains("dall")) return OpenAiChannel.ChatGPT;
        if (model.toLowerCase().contains("glm")) return OpenAiChannel.ChatGLM;
        if (model.toLowerCase().contains("deepseek")) return OpenAiChannel.DeepSeek;
        return null;
    }

}
