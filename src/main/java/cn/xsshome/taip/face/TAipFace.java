package cn.xsshome.taip.face;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;
/**
 * 计算机视觉人脸识别模块
 * @author 小帅丶
 * @version 4.1.0
 */
public class TAipFace extends BaseClient{

	public TAipFace(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 人脸检测与分析	
     * 识别上传图像上面的人脸信息
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String detect(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("mode", "1");
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_DETECT,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸检测与分析	
     * 识别上传图像上面的人脸信息
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String detect(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return detect(image);
    }
    /**
     * 多人脸检测	
     * 识别上传图像上面的人脸位置，支持多人脸识别。
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String detectMulti(byte[] image) throws Exception{
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
        result = HttpUtil.post(FaceConsts.FACE_DETECTMULTI,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 多人脸检测	
     * 识别上传图像上面的人脸位置，支持多人脸识别。
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String detectMulti(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return detectMulti(image);
    }
    /**
     * 人脸对比	
     * 对请求图片进行人脸对比
     * @param image_a - 二进制图像数据A
     * @param image_b - 二进制图像数据B
     * @return String
	 * @throws Exception 
     */
    public String faceCompare(byte[] image_a,byte[] image_b) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64ContentA = Base64Util.encode(image_a);
        String base64ContentB = Base64Util.encode(image_b);
        params.put("image_a", base64ContentA);
        params.put("image_b", base64ContentB);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_COMPARE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸对比	
     * 对请求图片进行人脸对比
     * @param filePathA - 本地路径图像文件A
     * @param filePathB - 本地路径图像文件B
     * @return String
	 * @throws Exception 
     */
    public String faceCompare(String filePathA,String filePathB) throws Exception{
    	byte[] imageA = FileUtil.readFileByBytes(filePathA);
    	byte[] imageB = FileUtil.readFileByBytes(filePathB);
        return faceCompare(imageA,imageB);
    }
    /**
     * 跨年龄人脸识别	
     * 上传两张人脸照，返回最相似的两张人脸及相似度。
     * @param source_image - 二进制待比较图片图像数据
     * @param target_image - 二进制待比较图片图像数据
     * @return String
	 * @throws Exception 
     */
    public String detectCrossage(byte[] source_image,byte[] target_image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64ContentA = Base64Util.encode(source_image);
        String base64ContentB = Base64Util.encode(target_image);
        params.put("source_image", base64ContentA);
        params.put("target_image", base64ContentB);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_DETECTCROSSAGE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 跨年龄人脸识别	
     * 上传两张人脸照，返回最相似的两张人脸及相似度。
     * @param source_imagefilePath - 本地路径待比较图片图像文件
     * @param target_imagefilePath - 本地路径待比较图片图像文件
     * @return String
	 * @throws Exception 
     */
    public String detectCrossage(String source_imagefilePath,String target_imagefilePath) throws Exception{
    	byte[] imageA = FileUtil.readFileByBytes(source_imagefilePath);
    	byte[] imageB = FileUtil.readFileByBytes(target_imagefilePath);
        return detectCrossage(imageA,imageB);
    }
    /**
     * 五官定位	
     * 对请求图片进行五官定位	
     * @param image - 二进制图像数据
     * @return String
	 * @throws Exception 
     */
    public String faceShape(byte[] image) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("mode", "1");
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_SHAPE,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 五官定位	
     * 对请求图片进行五官定位	
     * @param filePath - 本地路径图像文件
     * @return String
	 * @throws Exception 
     */
    public String faceShape(String filePath) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceShape(image);
    }
    /**
     * 人脸识别	
     * 对请求图片中的人脸进行识别
     * @param image 二进制图像数据
     * @param group_id 候选人组ID（个体创建时设定）
     * @param topn 返回的候选人个数
     * @return String
     * @throws Exception
     */
    public String faceIdentify(byte[] image,String group_id,int topn) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("group_id", group_id);
        params.put("topn", String.valueOf(topn));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_IDENTIFY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸识别	
     * 对请求图片中的人脸进行识别
     * @param filePath 本地路径图像文件
     * @param group_id 候选人组ID（个体创建时设定）
     * @param topn 返回的候选人个数
     * @return String
     * @throws Exception
     */
    public String faceIdentify(String filePath,String group_id,int topn) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceIdentify(image,group_id,topn);
    }
    /**
     * 人脸验证	
     * 对请求图片进行人脸验证
     * @param image 二进制图像数据
     * @param person_id 待验证的个体
     * @return String
     * @throws Exception
     */
    public String faceVerify(byte[] image,String person_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("person_id", person_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.FACE_VERIFY,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 人脸验证	
     * 对请求图片进行人脸验证
     * @param filePath 本地路径图像文件
     * @param person_id 待验证的个体
     * @return String
     * @throws Exception
     */
    public String faceVerify(String filePath,String person_id) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceVerify(image,person_id);
    }
    /**
     * 个体创建(全部参数)	
     * 创建一个个体（Person）
     * @param image 二进制图像数据
     * @param group_ids 组id 可以是多个 eg:group01|group02
     * @param person_id 指定的个体id
     * @param person_name 个体名字
     * @param tag 备注信息
     * @return
     * @throws Exception
     */
    public String faceNewperson(byte[] image,String group_ids,String person_id,String person_name,String tag) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("group_ids", group_ids);
        params.put("person_id", person_id);
        params.put("person_name", person_name);
        params.put("tag", tag);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_NEWPERSON,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 个体创建(全部参数)	
     * 创建一个个体（Person）
     * @param filePath 本地路径图像文件
     * @param group_ids 组id 可以是多个 eg:group01|group02
     * @param person_id 指定的个体id
     * @param person_name 个体名字
     * @param tag 备注信息
     * @return
     * @throws Exception
     */
    public String faceNewperson(String filePath,String group_ids,String person_id,String person_name,String tag) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceNewperson(image,group_ids,person_id,person_name,tag);
    }
    /**
     * 个体创建(必填参数)	
     * 创建一个个体（Person）
     * @param image 二进制图像数据
     * @param group_ids 组id 可以是多个 eg:group01|group02
     * @param person_id 指定的个体id
     * @param person_name 个体名字
     * @return
     * @throws Exception
     */
    public String faceNewperson(byte[] image,String group_ids,String person_id,String person_name) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(image);
        params.put("image", base64Content);
        params.put("group_ids", group_ids);
        params.put("person_id", person_id);
        params.put("person_name", person_name);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_NEWPERSON,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 个体创建(必填参数)
     * 创建一个个体（Person）
     * @param filePath 本地路径图像文件
     * @param group_ids 组id 可以是多个 eg:group01|group02
     * @param person_id 指定的个体id
     * @param person_name 个体名字
     * @return
     * @throws Exception
     */
    public String faceNewperson(String filePath,String group_ids,String person_id,String person_name) throws Exception{
    	byte[] image = FileUtil.readFileByBytes(filePath);
        return faceNewperson(image,group_ids,person_id,person_name);
    }
    /**
     * 删除个体	
     * 删除一个个体（Person）
     * @param person_id 需要删除的个体（Person）ID
     * @return String
     * @throws Exception
     */
    public String faceDelperson(String person_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("person_id", person_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_DELPERSON,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 增加人脸(byte图片数据)	
     * 将一组人脸（Face）加入到一个个体（Person）中
     * @param images 多个|单个图片的byte数据
     * @param person_id 指定的个体（Person）ID
     * @param tag 备注信息
     * @return String
     * @throws Exception
     */
    public String faceAddfaceByte(List<byte[]> images,String person_id,String tag) throws Exception{
    	String result ="";
    	String imagestr ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		for (int i = 0; i < images.size(); i++) {
			imagestr +=Base64Util.encode(images.get(i))+"|";
		}
		imagestr = imagestr.substring(0, imagestr.length()-1);
        params.put("person_id", person_id);
        params.put("images", imagestr);
        params.put("tag", tag);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_ADD,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 增加人脸(图片路径)
     * 将一组人脸（Face）加入到一个个体（Person）中
     * @param filePaths 多个|单个图片本地路径
     * @param person_id 指定的个体（Person）ID
     * @param tag 备注信息
     * @return String
     * @throws Exception
     */
    public String faceAddfaceByFilePath(List<String> filePaths,String person_id,String tag) throws Exception{
    	List<byte[]> images = new ArrayList<byte[]>();
		for (int i = 0; i < filePaths.size(); i++) {
			images.add(FileUtil.readFileByBytes(filePaths.get(i)));
		}
        return faceAddfaceByte(images,person_id,tag);
    }
    /**
     * 删除人脸 	
     * 从一个个体（Person）中删除一组人脸（Face）
     * @param person_id 需要删除的个体（Person）ID
     * @param face_ids 需要删除的人脸（Face）ID（多个之间用“\
     * @return String
     * @throws Exception
     */
    public String faceDelFace(String person_id,String face_ids) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("person_id", person_id);
        params.put("face_ids", face_ids);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_DEL,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 设置信息 	
     * 设置个体（Person）的名字或备注
     * @param person_id 需要设置的个体（Person）ID
     * @param person_name 新的名字
     * @param tag 备注信息
     * @return String
     * @throws Exception
     */
    public String faceSetInfo(String person_id,String person_name,String tag) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("person_id", person_id);
        params.put("person_name", person_name);
        params.put("tag", tag);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_SETINFO,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 获取信息 	
     * 获取一个个体（Person）的信息
     * @param person_id 需要查询的个体（Person）ID
     * @return String
     * @throws Exception
     */
    public String faceGetInfo(String person_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        params.put("person_id", person_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.PERSONFACE_GETINFO,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 获取组列表 	
     * 获取应用下所有的组（Group）ID列表 获取一个AppId下所有Group ID
     * @return String
     * @throws Exception
     */
    public String getGroupIds() throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.INFOFACE_GETGROUPIDS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 获取个体列表 	
     * 获取一个组（Group）中的所有个体（Person）ID
     * @param group_id 组（Group）ID
     * @return String
     * @throws Exception
     */
    public String getPersonIds(String group_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("group_id", group_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.INFOFACE_GETPERSONIDS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 获取人脸列表 	
     * 根据个体（Person）ID 获取人脸（Face）ID列表
     * @param person_id 个体（Person）ID
     * @return String
     * @throws Exception
     */
    public String getFaceIds(String person_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("person_id", person_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.INFOFACE_GETFACEIDS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 获取人脸信息 	
     * 根据人脸（Face）ID 获取人脸（Face）信息
     * @param face_id 人脸（Face） ID
     * @return String
     * @throws Exception
     */
    public String getFaceInfo(String face_id) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("face_id", face_id);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(FaceConsts.INFOFACE_GETFACEINFO,TencentAISignSort.getParams(params));
        return result;
    }
}
