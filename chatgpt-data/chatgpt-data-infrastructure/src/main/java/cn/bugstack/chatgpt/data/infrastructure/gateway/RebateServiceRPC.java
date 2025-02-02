package cn.bugstack.chatgpt.data.infrastructure.gateway;

import cn.bugstack.trigger.api.IRebateService;
import cn.bugstack.trigger.api.dto.RebateRequestDTO;
import cn.bugstack.trigger.api.request.Request;
import cn.bugstack.trigger.api.response.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 返利服务
 * @create 2024-10-20 14:27
 */
@Slf4j
@Service
public class RebateServiceRPC {

    //@DubboReference(interfaceClass = IRebateService.class, version = "1.0")
    private IRebateService rebateService;

    @Value("${app.config.big-market.appId}")
    private String appId;
    @Value("${app.config.big-market.appToken}")
    private String appToken;

    public boolean rebate(String userId, String orderId) {
        try {
            RebateRequestDTO requestDTO = new RebateRequestDTO();
            requestDTO.setUserId(userId);
            requestDTO.setOutBusinessNo(orderId);
            requestDTO.setBehaviorType("OPENAI_PAY");

            Request<RebateRequestDTO> request = new Request<>();

            request.setAppId(appId);
            request.setAppToken(appToken);
            request.setData(requestDTO);

            Response<Boolean> response = rebateService.rebate(request);
            log.info("支付返利操作开始，request:{} response:{}", JSON.toJSONString(request), JSON.toJSONString(response));
            return "0000".equals(response.getCode());
        } catch (Exception e) {
            log.error("支付返利操作失败，userId:{} orderId:{}", userId, orderId, e);
            return false;
        }
    }

}
