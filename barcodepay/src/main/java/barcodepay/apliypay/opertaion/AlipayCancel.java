package barcodepay.apliypay.opertaion;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeCancelModel;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;

import barcodepay.apliypay.AlipyPayClient;

public class AlipayCancel {
	
	private AlipayClient alipayClient;

	public AlipayCancel(){
		try {
			alipayClient = AlipyPayClient.getAlipayClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * 交易撤销接口
     * @param bizContent
     * @return
     * @throws AlipayApiException
     */
	public boolean isTradeCancel(AlipayTradeCancelModel model) throws AlipayApiException{
        AlipayTradeCancelResponse response = tradeCancel(model);
        if(response.isSuccess()){
            return true;
        }
        return false;
    }

    public AlipayTradeCancelResponse tradeCancel(AlipayTradeCancelModel model) throws AlipayApiException{
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        request.setBizModel(model);
        AlipayTradeCancelResponse response = alipayClient.execute(request);
        return response;
    }
}
