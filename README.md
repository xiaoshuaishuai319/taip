[![Codacy Badge](https://api.codacy.com/project/badge/Grade/77d72d906e1840a2ba88616fc07212c3)](https://app.codacy.com/gh/xiaoshuaishuai319/taip?utm_source=github.com&utm_medium=referral&utm_content=xiaoshuaishuai319/taip&utm_campaign=Badge_Grade_Settings)
[![Version](https://img.shields.io/badge/version-4.3.2-brightgreen.svg)](http://mvnrepository.com/search?q=taip)
[![Download](https://img.shields.io/badge/download-v4.3.2jar-brightgreen.svg)](https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=cn.xsshome&a=taip&v=4.3.2&e=jar)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![JDK 1.7](https://img.shields.io/badge/JDK-1.7-green.svg "JDK 1.7")]()
[![WiKi](https://img.shields.io/readthedocs/pip.svg)](https://apidoc.gitee.com/xshuai/taip/)
[![作者](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-%E5%B0%8F%E5%B8%85%E4%B8%B6-7AD6FD.svg)](https://www.xsshome.cn/)

# 最新代码更新在码云(Gitee):https://gitee.com/xshuai/taip/ 
# 有问题联系 QQ:783021975

文档请移步:[http://taip.mydoc.io/](http://taip.mydoc.io/)

APPID APPKEY 是腾讯AI创建应用后得到。请移步腾讯AI官网获取哦。[https://ai.qq.com/](https://ai.qq.com/)



TAip Java SDK目录结构
```
cn.xsshome.taip
       ├── base                                //基类
       ├── http                                //Http通信相关类
       ├── error                                //SDK错误类
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
       ├── nlp
       │       └── TAipNlp                   //TAipNlp类
       ├── vision
       │       └── TAipVision                   //TAipVision类
       └── util                                //工具类
```
       
 **支持 JAVA版本：1.7+**

直接使用JAR包步骤如下：

1.在腾讯AIQQ群下载Java SDK压缩工具包或点击download图标进行下载最新jar。

2.将下载的tai-java-sdk-version.zip解压后，复制到工程文件夹中。

3.在Eclipse右键“工程 -> Properties -> Java Build Path -> Add JARs”。

4.添加SDK工具包tai-java-sdk-version.jar。

其中，version为版本号，添加完成后，用户就可以在工程中使用腾讯AIJava SDK。    

-------------------------------------------------------------------------------

## 安装

### Maven
在项目的pom.xml的dependencies中加入以下内容:

```xml
<dependency>
  <groupId>cn.xsshome</groupId>
  <artifactId>taip</artifactId>
  <version>4.3.2</version>
</dependency>
```
### Gradle
```
compile 'cn.xsshome:taip:4.3.2'
```

### 非Maven项目

点击以下任一链接，下载`taip-x.x.x.jar`即可：

- [Maven中央库1](http://central.maven.org/maven2/cn/xsshome/taip/4.3.2/taip-4.3.2.jar)
- [Maven中央库2](http://repo1.maven.org/maven2/cn/xsshome/taip/4.3.2/taip-4.3.2.jar)

-------------------------------------------------------------------------------
## 使用示例代码
### 网络设置示例代码

```
public class Sample {
    //设置APPID/APP_KEY
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";

    public static void main(String[] args) {
        // 初始化一个TAip[xxx] xxx代表具体的模块名称
        TAip[xxx] client = new TAip[xxx](APP_ID,APP_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
         // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
        //调用接口
        client.[xxxxx]("图片路径");
    }
}
```
   
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
        String result = aipOcr.idcardOcr("./idcard.jpg", 0);//身份证正面(图片)识别
        String result = aipOcr.idcardOcr("./idcard2.jpg", 1);//身份证反面(国徽)识别
        String result = aipOcr.bcOcr("./juli2.jpg");//名片识别
        String result = aipOcr.driverlicenseOcr("./driver.jpg",0);//行驶证OCR识别
        String result = aipOcr.driverlicenseOcr("./driver2.jpg",1);//驾驶证OCR识别
        String result = aipOcr.bizlicenseOcr("./biz.jpg");//营业执照OCR识别
        String result = aipOcr.creditcardOcr("./bank2.jpg");//银行卡OCR识别
        String result = aipOcr.generalOcr("./biz.jpg");//通用OCR识别
        String result = aipOcr.handWritingOcrByImage("./biz.jpg");//手写体识别 选取本地图片文件识别
        String result = aipOcr.handWritingOcrByUrl("https://yyb.gtimg.com/ai/assets/ai-demo/small/hd-1-sm.jpg");//手写体识别 选取网络图片URL识别 
        String result = aipOcr.plateOcrByImage("./biz.jpg");//车牌识别 选取本地图片文件识别
        String result = aipOcr.plateOcrByUrl("https://yyb.gtimg.com/ai/assets/ai-demo/large/plate-1-lg.jpg");//车牌识别 选取网络图片URL识别                               
    }
}
```
### ASR、TTS示例代码


新建TAipSpeech
TAipSpeech是调用腾讯AI中语音识别、合成的Java客户端，为调用腾讯AI中语音识别、合成功能的开发人员提供了一系列的交互方法。

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
        String text = "小帅封装代码";
        String result = aipSpeech.TtaSynthesis(text);//语音合成（优图）     默认参数
        String result = aipSpeech.TtaSynthesis(text,2,1);//语音合成（优图）     全部参数
        String result = aipSpeech.TtsSynthesis(text, 1, 3);//语音合成（AI Lab） 默认参数
        String result = aipSpeech.TtsSynthesis(text,1,3,0,100,0,58);//语音合成（AI Lab） 全部参数
        String result = aipSpeech.asrLong("G:/16.pcm", 1, "http://yourwebsitename.com/methodname");//长语音识别
        String result = aipSpeech.aaiDetectkeywordBySpeech(filePath, 1, "http://www.xxxxx.com//txnotify", "小",8000);//关键词检索基于本地语音文件
        String result = aipSpeech.aaiDetectkeywordBySpeechURL("http://www.xxxxx.com/audio.pcm", 1, "http://www.xxxxx.com//txnotify", "小",8000);//关键词检索基于语音URL文件
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
        String result = aipFace.detectByUrl("https://yyb.gtimg.com/aiplat/static/ai-demo/small/f-3.jpg");//人脸检测与分析使用image_url参数
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

### 自然语言处理

TAipNlp是调用腾讯AI中自然语言处理的Java客户端，为调用腾讯AI中自然语言处理功能的开发人员提供了一系列的交互方法。


用户可以参考如下代码新建一个 TAipNlp，初始化完成后建议单例使用：

```
public class Sample{
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";
    public static void main2(String[] args) throws Exception {
        TAipNlp aipNlp = new TAipNlp(APP_ID, APP_KEY);
        String session = new Date().getTime()/1000+"";
        String filePath = "G:/tt.jpg";
        String filePath2 = "G:/16.pcm";
        String result = aipNlp.nlpWordseg("小帅开发者");//分词
        String result = aipNlp.nlpWordpos("小帅是一个热心的开发者");//词性标注
        String result = aipNlp.nlpWordner("最近张学友在深圳开了一场演唱会");//专有名词
        String result = aipNlp.nlpWordsyn("今天的天气怎么样");//同义词
        String result = aipNlp.nlpWordcom("今天深圳的天气怎么样？明天呢");//意图成分
        String result = aipNlp.nlpTextpolar("小帅很帅");//情感分析
        String result = aipNlp.nlpTextchat(session,"北京天气");//基础闲聊     
        String result = aipNlp.nlpTextTrans(0, "小帅开发者");//文本翻译（AI Lab）
        String result = aipNlp.nlpTextTranslate("小帅开发者", "zh", "en");//文本翻译（翻译君）     
        String result = aipNlp.nlpImageTranslate(filePath, session, "doc","zh", "en");//图片翻译
        String result = aipNlp.nlpSpeechTranslate(6, 0, 1, session, filePath2,"zh", "en");//语音翻译     
        String result = aipNlp.nlpTextDetect("こんにちは", 0);//语种识别
        System.out.println(result);
    }
}
```

### 智能鉴黄、暴恐图片识别

TAipVision是调用腾讯AI中智能鉴黄、暴恐图片识别的Java客户端，为调用腾讯AI中智能鉴黄、暴恐图片识别功能的开发人员提供了一系列的交互方法。


用户可以参考如下代码新建一个 TAipVision，初始化完成后建议单例使用：

```
public class Sample{
    public static final String APP_ID = "你的 App ID";
    public static final String APP_KEY = "你的 Api Key";
    public static void main2(String[] args) throws Exception {
        TAipVision aipVision = new TAipVision（APP_ID, APP_KEY);
        String filePath = "G:/tt.jpg";
        String result = aipVision.imageTerrorism(filePath);//暴恐图片
        String result = aipVision.visionPorn(filePath);//智能鉴黄
        System.out.println(result);
    }
}
```

