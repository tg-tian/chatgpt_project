package cn.bugstack.deepseek;


import cn.bugstack.deepseek.domain.chat.ChatCompletionRequest;
import cn.bugstack.deepseek.domain.chat.ChatCompletionResponse;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Map;


public interface IDeepSeekApi {

    String v1_completions = "chat/completions";

    /**
     * 文本问答
     *
     * @param qaCompletionRequest 请求信息
     * @return 应答结果
     */
    @POST(v1_completions)
    Single<ChatCompletionResponse> completions(@Body ChatCompletionRequest qaCompletionRequest);




}
