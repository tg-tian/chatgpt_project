package cn.tg.chatgpt.application;


public interface IWeiXinValidateService {

    boolean checkSign(String signature, String timestamp, String nonce);

}
