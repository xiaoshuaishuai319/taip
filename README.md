OCR Java SDK目录结构
```
cn.xsshome.taip
       ├── base                                //基类
       ├── http                                //Http通信相关类
       ├── imageclassify
       │       └── TAipImageClassify           //TAipImageClassify类
       ├── sign                                //签名公用类
       ├── ocr
       │       └── TAipOcr                      //TAipOcr类
       ├── speech
       │       └── TAipSpeech                   //TAipSpeech类
       ├── face
       │       └── TAipFace                   //TAipFace类
       ├── ptu
       │       └── TAipPtu                   //TAipPtu类
       └── util                                //工具类
```
	   
 **支持 JAVA版本：1.7+** 

直接使用JAR包步骤如下：

1.在腾讯AIQQ群下载Java SDK压缩工具包。

2.将下载的tai-java-sdk-version.zip解压后，复制到工程文件夹中。

3.在Eclipse右键“工程 -> Properties -> Java Build Path -> Add JARs”。

4.添加SDK工具包tai-java-sdk-version.jar。

其中，version为版本号，添加完成后，用户就可以在工程中使用腾讯AIJava SDK。	   
### OCR示例代码


新建TAipOcr
TAipOcr是调用腾讯AI中OCR的Java客户端，为调用腾讯AI中OCR功能的开发人员提供了一系列的交互方法。

用户可以参考如下代码新建一个TAipOcr,初始化完成后建议单例使用：

```
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
```
### ASR示例代码


新建TAipOcr
TAipOcr是调用腾讯AI中语音识别的Java客户端，为调用腾讯AI中语音识别功能的开发人员提供了一系列的交互方法。

用户可以参考如下代码新建一个TAipSpeech,初始化完成后建议单例使用：

```
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
```

### 图像识别 示例代码


TAipImageClassify是调用腾讯AI中图像识别的Java客户端，为调用腾讯AI中图像识别功能的开发人员提供了一系列的交互方法。


用户可以参考如下代码新建一个 TAipImageClassify，初始化完成后建议单例使用：

```
public class Sample {
    //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";
    public static void main(String[] args) throws Exception {
        // 初始化一个TAipImageClassify
        TAipImageClassify aipImageClassify = new TAipImageClassify(APP_ID, APP_KEY);
        String filePath = "G:/x5.jpg";//本地文件路径
        byte[] image = FileUtil.readFileByBytes(filePath);//获取文件的byte数据
        String result = aipImageClassify.visionScener(image, 1, 5);//场景识别
        String result = aipImageClassify.visionObjectr(image, 1, 5);//物体识别
        String result = aipImageClassify.imageTag(image);//图像标签识别
        String result = aipImageClassify.visionImgidentify(image, 1);//车辆识别
        String result = aipImageClassify.visionImgidentify(image, 2);//花草识别
        String result = aipImageClassify.flowersAndPlant(image);//花草识别
        String result = aipImageClassify.vehicle(image);//车辆识别
        String result = aipImageClassify.visionImgtotext(image,RandomNonceStrUtil.getRandomString());//看图说话
        String result = aipImageClassify.imageFuzzy(image);//模糊图片检测
        String result = aipImageClassify.imageFood(image);//美食图片识别
        System.out.println(result);

    }
}
```

### 图片特效


TAipPtu是调用腾讯AI中图片特效的Java客户端，为调用腾讯AI中图片特效功能的开发人员提供了一系列的交互方法。


用户可以参考如下代码新建一个 TAipPtu，初始化完成后建议单例使用：

```

public class Sample{
     //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";
    public static void main(String[] args) throws Exception {
        // 初始化一个TAipPtu
        TAipPtu aipPtu = new TAipPtu(APP_ID, APP_KEY);
        String imagePath = "G:/test2.jpg";
        String result = aipPtu.faceCosmetic(imagePath, 23);//人脸美妆     
        String result = aipPtu.faceDecoration(imagePath, 8);//人脸变妆     
        String result = aipPtu.imgFilter(imagePath, 20);//滤镜 天天P图     
        String result = aipPtu.visionImgfilter(imagePath, 32, String.valueOf(new Date().getTime()));//滤镜 AI Lab
        String result = aipPtu.faceMerge(imagePath, 12);//人脸融合
        String result = aipPtu.faceSticker(imagePath, 27);//大头贴
        String result = aipPtu.faceAge(imagePath);//颜龄检测
        System.out.println(result);
    }
}


```

### 人脸识别


TAipFace是调用腾讯AI中人脸识别的Java客户端，为调用腾讯AI中人脸识别功能的开发人员提供了一系列的交互方法。


用户可以参考如下代码新建一个 TAipFace，初始化完成后建议单例使用：

```

public class Sample{
 //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";
    public static void main(String[] args) throws Exception {
         // 初始化一个TAipPtu
        TAipFace aipFace = new TAipFace(APP_ID, APP_KEY);
        String filePath = "G:/body2.jpg";
        String filePathA = "G:/dc.jpg";
        String filePathB = "G:/dcg.jpg";
        /**********人脸识别**********/
        String result = aipFace.detect(filePath);//人脸检测与分析
        String result = aipFace.detectMulti(filePath);    //多人脸检测
        String result = aipFace.faceCompare(filePathA, filePathB);    //人脸对比     
        String result = aipFace.detectCrossage(filePathA, filePathB);//跨年龄人脸识别
        String result = aipFace.faceShape(filePathA);//五官定位     
        String result = aipFace.faceIdentify(filePath, "group01", 9);//人脸识别
        String result = aipFace.faceVerify(filePath, "20180511");//人脸验证
        /**********个体管理**********/
        String result = aipFace.faceNewperson(filePath,"group20180511","201805110001","测试");//个体创建
        String result = aipFace.faceDelperson("201805110001");//删除个体
        /*增加人脸 图片二进制List*/
        List<byte[]> bytes = new ArrayList<byte[]>();
        byte [] faceA = FileUtil.readFileByBytes(filePathA);
        byte [] faceB = FileUtil.readFileByBytes(filePathB);
        bytes.add(faceA);
        bytes.add(faceB);
        String result = aipFace.faceAddfaceByte(bytes,"201805110001","测试增加人脸");
        /*增加人脸 图片本地路径List*/
        List<String> filePaths = new ArrayList<String>();
        filePaths.add(filePathA);
        filePaths.add(filePathB);
        String result = aipFace.faceAddfaceByFilePath(filePaths,"201805110001","测试增加人脸");//增加人脸
        String result = aipFace.faceDelFace("201805110001", "2573556034542000336");//删除人脸
        String result = aipFace.faceSetInfo("201805110001", "小帅测试","测试接口");//设置信息
        String result = aipFace.faceGetInfo("201805110001");//获取信息
        /**********信息查询**********/
        String result = aipFace.getGroupIds();//获取组列表
        String result = aipFace.getPersonIds("group20180511");//获取个体列表
        String result = aipFace.getFaceIds("201805110001");//获取人脸列表
        String result = aipFace.getFaceInfo("2573564663139686751");//获取人脸信息     
        System.out.println(result);
    }
}


```
