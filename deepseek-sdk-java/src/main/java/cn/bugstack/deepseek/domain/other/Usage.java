package cn.bugstack.deepseek.domain.other;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 使用量
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usage implements Serializable {

    /** 完成令牌 */
    @JsonProperty("completion_tokens")
    private long completionTokens;
    /** 提示令牌 */
    @JsonProperty("prompt_tokens")
    private long promptTokens;

    @JsonProperty("prompt_cache_hit_tokens")
    private long promptCacheHitTokens;

    @JsonProperty("prompt_cache_miss_tokens")
    private long promptCacheMissTokens;

    /** 总量令牌 */
    @JsonProperty("total_tokens")
    private long totalTokens;

    public long getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(long promptTokens) {
        this.promptTokens = promptTokens;
    }

    public long getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(long completionTokens) {
        this.completionTokens = completionTokens;
    }

    public long getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(long totalTokens) {
        this.totalTokens = totalTokens;
    }

    public long getPromptCacheMissTokens() {
        return promptCacheMissTokens;
    }

    public void setPromptCacheMissTokens(long promptCacheMissTokens) {
        this.promptCacheMissTokens = promptCacheMissTokens;
    }

    public long getPromptCacheHitTokens() {
        return promptCacheHitTokens;
    }

    public void setPromptCacheHitTokens(long promptCacheHitTokens) {
        this.promptCacheHitTokens = promptCacheHitTokens;
    }

}
