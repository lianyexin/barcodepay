package barcodepay.apliypay.opertaion;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;

import barcodepay.apliypay.AlipyPayClient;

public class AlipayQuery {
	
	private AlipayClient alipayClient;

	public AlipayQuery(){
		try {
			alipayClient = AlipyPayClient.getAlipayClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * 交易查询接口
     * @param bizContent
     * @return
     * @throws AlipayApiException
     */
	public boolean isTradeQuery(AlipayTradeQueryModel model) throws AlipayApiException{
        AlipayTradeQueryResponse response = tradeQuery(model);
        if(response.isSuccess()){
            return true;
        }
        return false;
    }

    public AlipayTradeQueryResponse  tradeQuery(AlipayTradeQueryModel model) throws AlipayApiException{
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizModel(model);
        return alipayClient.execute(request);
    }

}
