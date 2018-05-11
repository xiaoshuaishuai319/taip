package cn.xsshome.taip.face;
/**
 * 计算机视觉人脸识别API地址
 * @author 小帅丶
 * @version 4.1.0
 */
public class FaceConsts {
	// 人脸检测与分析
	static final String FACE_DETECT = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";
	// 多人脸检测
	static final String FACE_DETECTMULTI = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";
	// 人脸对比
	static final String FACE_COMPARE = "https://api.ai.qq.com/fcgi-bin/face/face_facecompare";
	// 跨年龄人脸识别
	static final String FACE_DETECTCROSSAGE = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";
	// 五官定位		
	static final String FACE_SHAPE = "https://api.ai.qq.com/fcgi-bin/face/face_faceshape";
	// 人脸识别	
	static final String FACE_IDENTIFY = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";
	// 人脸验证	
	static final String FACE_VERIFY = "https://api.ai.qq.com/fcgi-bin/face/face_faceverify";
	//个体创建
	static final String PERSONFACE_NEWPERSON = "https://api.ai.qq.com/fcgi-bin/face/face_newperson";
	//删除个体
	static final String PERSONFACE_DELPERSON = "https://api.ai.qq.com/fcgi-bin/face/face_delperson";
	//增加人脸
	static final String PERSONFACE_ADD = "https://api.ai.qq.com/fcgi-bin/face/face_addface";
	//删除人脸
	static final String PERSONFACE_DEL = "https://api.ai.qq.com/fcgi-bin/face/face_delface";
	//设置信息	
	static final String PERSONFACE_SETINFO = "https://api.ai.qq.com/fcgi-bin/face/face_setinfo";
	//获取信息
	static final String PERSONFACE_GETINFO = "https://api.ai.qq.com/fcgi-bin/face/face_getinfo";
	//获取组列表
	static final String INFOFACE_GETGROUPIDS = "https://api.ai.qq.com/fcgi-bin/face/face_getgroupids";
	//获取个体列表
	static final String INFOFACE_GETPERSONIDS = "https://api.ai.qq.com/fcgi-bin/face/face_getpersonids";
	//获取人脸列表
	static final String INFOFACE_GETFACEIDS = "https://api.ai.qq.com/fcgi-bin/face/face_getfaceids";
	//获取人脸信息
	static final String INFOFACE_GETFACEINFO = "https://api.ai.qq.com/fcgi-bin/face/face_getfaceinfo";
}
