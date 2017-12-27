package barcodepay.apliypay.opertaion;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;

import barcodepay.apliypay.AlipyPayClient;

public class AlipayTrade {

	private AlipayClient alipayClient;

	public AlipayTrade(){
		try {
			alipayClient = AlipyPayClient.getAlipayClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 条形码支付
     * @throws AlipayApiException
     */
    public String tradePay(AlipayTradePayModel model) throws AlipayApiException {
        AlipayTradePayResponse response = tradePayToResponse(model);
        return response.getBody();
    }

    public AlipayTradePayResponse tradePayToResponse(AlipayTradePayModel model) throws AlipayApiException{
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setBizModel(model);// 填充业务参数
        return alipayClient.execute(request); // 通过alipayClient调用API，获得对应的response类
    }
}
