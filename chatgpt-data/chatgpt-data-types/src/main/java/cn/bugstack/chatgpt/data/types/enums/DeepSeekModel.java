package cn.bugstack.chatgpt.data.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeepSeekModel {
    DEEPSEEK_V3("deepseek-v3"),
    DEEPSEEK_R1("deepseek-r1"),
    ;
    private final String code;
}
