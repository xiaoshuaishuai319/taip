OCR Java SDK目录结构
cn.xsshome.taip
       ├── base                                //基类
       ├── http                                //Http通信相关类
       ├── sign                                //签名公用类
       ├── ocr
       │       └── TAipOcr           		   //TAipOcr类
	   ├── speech
	   │       └── TAipOcr           		   //TAipSpeech类
       └── util                                //工具类
	   
支持 JAVA版本：1.7+

直接使用JAR包步骤如下：

1.在腾讯AIQQ群下载Java SDK压缩工具包。

2.将下载的tai-java-sdk-version.zip解压后，复制到工程文件夹中。

3.在Eclipse右键“工程 -> Properties -> Java Build Path -> Add JARs”。

4.添加SDK工具包tai-java-sdk-version.jar。

其中，version为版本号，添加完成后，用户就可以在工程中使用腾讯AIJava SDK。	   
#OCR示例代码
新建TAipOcr
TAipOcr是调用腾讯AI中OCR的Java客户端，为调用腾讯AI中OCR功能的开发人员提供了一系列的交互方法。

用户可以参考如下代码新建一个TAipOcr,初始化完成后建议单例使用：

public class Sample {
    //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";

    public static void main(String[] args) {
        // 初始化一个TAipOcr
       TAipOcr aipOcr = new TAipOcr(APP_ID,APP_KEY);
        // 调用接口
        String path = "test.jpg";
		String result = aipOcr.bcOcr(path);
		System.out.println(result);
    }
}
#ASR示例代码
新建TAipOcr
TAipOcr是调用腾讯AI中语音识别的Java客户端，为调用腾讯AI中语音识别功能的开发人员提供了一系列的交互方法。

用户可以参考如下代码新建一个TAipSpeech,初始化完成后建议单例使用：

public class Sample {
    //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";

    public static void main(String[] args) {
        // 初始化一个TAipSpeech
        TAipSpeech aipSpeech = new TAipSpeech(APP_ID, APP_KEY);
        // 调用接口
		String filePath ="./VOICE1513237078.pcm";//本地文件路径
		byte[] audio = FileUtil.readFileByBytes(filePath);//获取文件的byte数据
		String result = aipSpeech.asrEcho(filePath, 1);//语音识别-echo版
		String result = aipSpeech.asrLab(1, 16000, 0, 1024, 1, audio);//语音识别-流式版（AI Lab）
		String result = aipSpeech.asrWx(filePath, 1, 16000, 16, 0, 1024, 1, 1);//语音识别-流式版(WeChat AI)
		System.out.println(result);
    }
}