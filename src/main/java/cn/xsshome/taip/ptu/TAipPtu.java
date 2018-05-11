package cn.xsshome.taip.ptu;

import java.util.HashMap;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 计算机视觉图片特效模块
 * @author 小帅丶
 * @version 4.1.0
 */
public class TAipPtu extends BaseClient{

	public TAipPtu(String app_id, String app_key) {
		super(app_id, app_key);
	}
	/**
     * 人脸美妆 	
     * 给定图片和美妆编码，对原图进行人脸美妆特效处理 	
     * @param image - 二进制图像数据
     * @param cosmetic 美妆编码
     * @return String
	 * @throws Exception 
     */
    public String faceCosmetic(byte[] image,int cosmetic) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("cosmetic", String.valueOf(cosmetic));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.PTU_FACECOSMETIC,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸美妆 	
     * 给定图片和美妆编码，对原图进行人脸美妆特效处理 
     * @param filePath - 本地路径图像文件
     * @param cosmetic 美妆编码
     * @return String
	 * @throws Exception 
     */
    public String faceCosmetic(String filePath,int cosmetic) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceCosmetic(image,cosmetic);
    }
    /**
     * 人脸变妆 	
     * 给定图片和变妆编码，对原图进行人脸变妆特效处理
     * @param image - 二进制图像数据
     * @param decoration 变妆编码
     * @return String
	 * @throws Exception 
     */
    public String faceDecoration(byte[] image,int decoration) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("decoration", String.valueOf(decoration));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.PTU_FACEDECORATION,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸变妆 	
     * 给定图片和变妆编码，对原图进行人脸变妆特效处理
     * @param filePath - 本地路径图像文件
     * @param decoration 变妆编码
     * @return String
	 * @throws Exception 
     */
    public String faceDecoration(String filePath,int decoration) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceDecoration(image,decoration);
    }
    /**
     * 图片滤镜（天天P图） 	
     * 对原图进行滤镜特效处理，更适合人物图
     * @param image - 二进制图像数据
     * @param filter 滤镜特效编码
     * @return String
	 * @throws Exception 
     */
    public String imgFilter(byte[] image,int filter) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("filter", String.valueOf(filter));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.PTU_IMGFILTER,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 图片滤镜（天天P图） 	
     * 对原图进行滤镜特效处理，更适合人物图
     * @param filePath - 本地路径图像文件
     * @param filter 滤镜特效编码
     * @return String
	 * @throws Exception 
     */
    public String imgFilter(String filePath,int filter) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return imgFilter(image,filter);
    }
    /**
     * 图片滤镜（AI Lab） 	
     * 对原图进行滤镜特效处理，更适合风景图片
     * @param image - 二进制图像数据
     * @param filter 滤镜特效编码
     * @param session_id 一次请求ID 尽可能唯一，长度上限64字节
     * @return String
	 * @throws Exception 
     */
    public String visionImgfilter(byte[] image,int filter,String session_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("filter", String.valueOf(filter));
        params.put("session_id", session_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.AILAB_VISION_IMGFILTER,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 图片滤镜（AI Lab） 	
     * 对原图进行滤镜特效处理，更适合风景图片
     * @param filePath - 本地路径图像文件
     * @param filter 滤镜特效编码
     * @param session_id 一次请求ID 尽可能唯一，长度上限64字节
     * @return String
	 * @throws Exception 
     */
    public String visionImgfilter(String filePath,int filter,String session_id) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return visionImgfilter(image,filter,session_id);
    }
    /**
     * 人脸融合 	
     * 给定图片和融合模板，对原图进行人脸融合特效处理
     * @param image - 二进制图像数据
     * @param model 默认素材模板编码见https://ai.qq.com/doc/facemerge.shtml；自定义素材模板可在应用详情页上传和查询，使用指引见https://ai.qq.com/doc/facemerge.shtml。
     * @return String
	 * @throws Exception 
     */
    public String faceMerge(byte[] image,int model) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("model", String.valueOf(model));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.PTU_FACEMERGE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸融合 	
     * 给定图片和融合模板，对原图进行人脸融合特效处理
     * @param filePath - 本地路径图像文件
     * @param model 默认素材模板编码见https://ai.qq.com/doc/facemerge.shtml；自定义素材模板可在应用详情页上传和查询，使用指引见https://ai.qq.com/doc/facemerge.shtml。
     * @return String
	 * @throws Exception 
     */
    public String faceMerge(String filePath,int model) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceMerge(image,model);
    }
    /**
     * 大头贴 	
     * 给定图片和大头贴编码，对原图进行大头贴特效处理 	
     * @param image - 二进制图像数据
     * @param sticker 大头贴编码
     * @return String
	 * @throws Exception 
     */
    public String faceSticker(byte[] image,int sticker) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("sticker", String.valueOf(sticker));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(PtuConsts.PTU_FACESTICKER,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 大头贴 	
     * 给定图片和大头贴编码，对原图进行大头贴特效处理 	
     * @param filePath - 本地路径图像文件
     * @param sticker 大头贴编码
     * @return String
	 * @throws Exception 
     */
    public String faceSticker(String filePath,int sticker) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceSticker(image,sticker);
    }
    /**
     * 颜龄检测 	
     * 给定图片，对原图进行人脸颜龄检测处理
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String faceAge(byte[] image) throws Exception{
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
        result = HttpUtil.post(PtuConsts.PTU_FACEAGE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 颜龄检测 	
     * 给定图片，对原图进行人脸颜龄检测处理
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String faceAge(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceAge(image);
    }
}
