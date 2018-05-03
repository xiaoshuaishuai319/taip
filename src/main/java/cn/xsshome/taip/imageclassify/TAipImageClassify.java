package cn.xsshome.taip.imageclassify;

import java.util.HashMap;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 计算机视觉图像识别
 * @author 小帅丶
 *
 */
public class TAipImageClassify extends BaseClient{

	public TAipImageClassify(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 场景识别接口   
     * 对图片进行场景识别，快速找出图片中包含的场景信息
     * @param image - 二进制图像数据
     * @param format 图片格式
     * @param topk  返回结果个数
     * @return String
	 * @throws Exception 
     */
    public String visionScener(byte[] image,int format,int topk) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("format",Integer.toString(format));
        params.put("topk",Integer.toString(topk));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_SCENER,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 场景识别接口   
     * 对图片进行场景识别，快速找出图片中包含的场景信息
     * @param filePath - 本地路径图像文件
     * @param format 图片格式
     * @param topk  返回结果个数
     * @return String
	 * @throws Exception 
     */
    public String visionScener(String filePath,int format,int topk) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return visionScener(image,format,topk);
    }
    /**
     * 物体识别接口
     * 对图片进行物体识别，快速找出图片中包含的物体信息
     * @param image - 二进制图像数据
     * @param format 图片格式
     * @param topk  返回结果个数
     * @return String
	 * @throws Exception 
     */
    public String visionObjectr(byte[] image,int format,int topk) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("format",Integer.toString(format));
        params.put("topk",Integer.toString(topk));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_OBJECTR,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 物体识别接口   
     * 对图片进行物体识别，快速找出图片中包含的物体信息
     * @param filePath - 本地路径图像文件
     * @param format 图片格式
     * @param topk  返回结果个数
     * @return String
	 * @throws Exception 
     */
    public String visionObjectr(String filePath,int format,int topk) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return visionObjectr(image,format,topk);
    }
    /**
     * 图像标签识别接口
     * 识别一个图像的标签信息,对图像分类
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String imageTag(byte[] image) throws Exception{
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
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_IMAGE_TAG,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 图像标签识别接口
     * 识别一个图像的标签信息,对图像分类
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String imageTag(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return imageTag(image);
    }
    /**
     * 花草/车辆识别接口
     * 根据用户选择的场景，识别出图片中的花草或车辆信息
     * @param image - 二进制图像数据
     * @param scene 识别场景，1-车辆识别，2-花草识别
     * @return String
	 * @throws Exception 
     */
    public String visionImgidentify(byte[] image,int scene) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("scene", Integer.toString(scene));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_IMGIDENTIFY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 花草/车辆识别接口
     * 根据用户选择的场景，识别出图片中的花草或车辆信息
     * @param filePath - 本地路径图像文件
     * @param scene 识别场景，1-车辆识别，2-花草识别
     * @return String
	 * @throws Exception 
     */
    public String visionImgidentify(String filePath,int scene) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return visionImgidentify(image,scene);
    }
    /**
     * 花草识别接口
     * 识别出图片中的花草信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String flowersAndPlant(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("scene", "2");
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_IMGIDENTIFY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 花草识别接口
     * 根识别出图片中的花草信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String flowersAndPlant(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return flowersAndPlant(image);
    }
    /**
     * 车辆识别接口
     * 识别出图片中的车辆信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String vehicle(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("scene", "1");
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_IMGIDENTIFY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 车辆识别接口
     * 识别出图片中的车辆信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String vehicle(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return vehicle(image);
    }
    /**
     * 看图说话
     * 用一句话描述图片
     * @param image - 二进制图像数据
     * @param session_id 一次请求ID
     * @return String
	 * @throws Exception 
     */
    public String visionImgtotext(byte[] image,String session_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("session_id", session_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_VISION_IMGTOTEXT,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 看图说话
     * 用一句话描述图片
     * @param filePath - 本地路径图像文件
     * @param session_id 一次请求ID
     * @return String
	 * @throws Exception 
     */
    public String visionImgtotext(String filePath,String session_id) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return visionImgtotext(image,session_id);
    }
    /**
     * 模糊图片检测
     * 判断一个图像的模糊程度
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String imageFuzzy(byte[] image) throws Exception{
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
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_IMAGE_FUZZY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 模糊图片检测
     * 判断一个图像的模糊程度
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String imageFuzzy(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return imageFuzzy(image);
    }
    /**
     * 美食图片识别	
     * 识别一个图像是否为美食图像
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String imageFood(byte[] image) throws Exception{
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
        result = HttpUtil.post(TAipImageClassifyConsts.ICR_IMAGE_FOOD,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 美食图片识别	
     * 识别一个图像是否为美食图像
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String imageFood(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return imageFood(image);
    }
}
