package cn.xsshome.taip.ocr;

import java.util.HashMap;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 计算机视觉OCR识别
 * @author 小帅丶
 * @version 0.0.1
 */
public class TAipOcr extends BaseClient{

	public  TAipOcr(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 通用文字识别接口   
     * 用户向服务请求识别某张图中的所有文字
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String generalOcr(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(OcrConsts.OCR_GENERAL,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 通用文字识别接口   
     * 用户向服务请求识别某张图中的所有文字
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String generalOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return generalOcr(image);
    }
	 /**
     * 身份证识别接口   
     * 识别身份证图像上面的详细身份信息	
     * @param image - 二进制图像数据
     * @param card_type 身份证图片类型，0-正面，1-反面
     * @return String
	 * @throws Exception 
     */
    public String idcardOcr(byte[] image,int card_type) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("card_type",Integer.toString(card_type));
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(OcrConsts.OCR_IDCARD,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 身份证识别接口   
     * 识别身份证图像上面的详细身份信息	
     * @param filePath - 本地路径图像文件
     * @param card_type 身份证图片类型，0-正面，1-反面
     * @return String
	 * @throws Exception 
     */
    public String idcardOcr(String filePath,int card_type) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return idcardOcr(image,card_type);
    }
	 /**
     * 名片识别接口   
     * 识别名片图像上面的字段信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String bcOcr(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(OcrConsts.OCR_BCOCR,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 名片识别接口   
     * 识别名片图像上面的字段信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String bcOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return bcOcr(image);
    }
	 /**
     * 行驶证驾驶证OCR识别
     * 识别行驶证或驾驶证图像上面的字段信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String driverlicenseOcr(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(OcrConsts.OCR_DRIVERLICENSEOCR,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 行驶证驾驶证OCR识别
     * 识别行驶证或驾驶证图像上面的字段信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String driverlicenseOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return driverlicenseOcr(image);
    }
   	 /**
     * 营业执照OCR识别
     * 识别营业执照上面的字段信息	
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String bizlicenseOcr(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(OcrConsts.OCR_BIZLICENSE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 营业执照OCR识别
     * 识别营业执照上面的字段信息	
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String bizlicenseOcr(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return bizlicenseOcr(image);
    }  
  	 /**
    * 银行卡OCR识别	
    * 识别银行卡上面的字段信息	
    * @param image - 二进制图像数据
    * @return String
	* @throws Exception 
    */
	public String creditcardOcr(byte[] image) throws Exception {
		String result = "";
		HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis() / 1000 + "";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		String base64Content = Base64Util.encode(image);
		params.put("image", base64Content);
		String sign = TencentAISignSort.getSignature(params, app_key);
		params.put("sign", sign);
		result = HttpUtil.post(OcrConsts.OCR_BANK,TencentAISignSort.getParams(params));
		return result;
	}
   /**
    * 银行卡OCR识别	
    * 识别银行卡上面的字段信息	
    * @param filePath - 本地路径图像文件
    * @return String
	* @throws Exception 
    */
   public String creditcardOcr(String filePath) throws Exception{
		byte[] image = FileUtil.readFileByBytes(filePath);
		return creditcardOcr(image);
	}    
}
