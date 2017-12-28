package barcodepay.apliypay;

import java.util.Properties;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

 // 获取阿里支付client
public class AlipyPayClient {
	
	private static AlipayClient alipayClient;
	
	public static AlipayClient getAlipayClient() throws Exception{
		
		if(alipayClient!=null){
			return alipayClient;
		}
		
		Properties prop = new Properties();
		//prop.load(new FileInputStream(new File("alipay.properties")));
		prop.load(AlipyPayClient.class.getResourceAsStream("/alipay.properties"));

	    String charset = "UTF-8";
	    String privateKey = prop.getProperty("privateKey");
	    String alipayPulicKey = prop.getProperty("alipayPulicKey");
	    String serverUrl = prop.getProperty("serverUrl");
	    String appId = prop.getProperty("appId");
	    String format = "json";
	    String signType = "RSA2";
	    String notifyDomain = prop.getProperty("notify_domain");

	    alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPulicKey, signType);
	    
		return alipayClient;
	}
	

}
