package cn.xsshome.taip.speech;

import java.util.HashMap;


import cn.xsshome.taip.base.BaseClient;
import cn.xsshome.taip.http.HttpUtil;
import cn.xsshome.taip.sign.TencentAISignSort;
import cn.xsshome.taip.util.Base64Util;
import cn.xsshome.taip.util.FileUtil;
import cn.xsshome.taip.util.RandomNonceStrUtil;

public class TAipSpeech extends BaseClient{
	
	public TAipSpeech(String app_id, String app_key) {
		super(app_id, app_key);
	}
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(byte[] audio,int format,int rate) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(audio);
        params.put("speech", base64Content);
        params.put("format", Integer.toString(format));
        params.put("rate",Integer.toString(rate));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAI,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(String filePath,int format,int rate) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrEcho(audio,format,rate);
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(byte[] audio,int format) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
        String base64Content = Base64Util.encode(audio);
        params.put("speech", base64Content);
        params.put("format", Integer.toString(format));
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAI,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-echo版
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @return String
	 * @throws Exception 
     */
    public String asrEcho(String filePath,int format) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrEcho(audio,format);
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param speech_chunk 待识别语音分片 base64编码数据
     * @return String
     * @throws Exception
     */
    public String asrLab(int format,int rate,int seq,int len,int end,String speech_chunk) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("format", Integer.toString(format));
		params.put("rate",Integer.toString(rate));
		params.put("seq",Integer.toString(seq));
		params.put("len", Integer.toString(len));
		params.put("end", Integer.toString(end));
		params.put("speech_id",RandomNonceStrUtil.getRandomString(10));
		params.put("speech_chunk", speech_chunk);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_AAIS,TencentAISignSort.getParams(params));
        return result;
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param audio 音频二进制数据
     * @return String
     * @throws Exception
     */
    public String asrLab(int format,int rate,int seq,int len,int end,byte[] audio) throws Exception{
    	String base64Content = Base64Util.encode(audio);
        return asrLab(format, rate, seq, len, end, base64Content);
    }
    /**
     * 语音识别-流式版（AI Lab）
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath 音频文件本地路径
     * @param format 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate 音频采样率编码 8000 16000
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @return String
     * @throws Exception
     */
    public String asrLab(String filePath,int format,int rate,int seq,int len,int end,String speech_id) throws Exception{
    	String base64Content = Base64Util.encode(FileUtil.readFileByBytes(filePath));
        return asrLab(format, rate, seq, len, end, base64Content);
    }
    /**
     * 语音识别-流式版(WeChat AI) 	
     * 对音频进行语音识别，并返回语音的文字内容
     * @param audio - 二进制音频数据
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4 SPEEX-5 MP3-8
     * @param rate - 语音采样率编码 8000 16000
     * @param bits 音频采样位数 16
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param cont_res 是否获取中间识别结果 0不获取 1获取
     * @return String
	 * @throws Exception 
     */
    public String asrWx(byte[] audio,int format,int rate,int bits,int seq,int len,int end,int cont_res) throws Exception{
    	String result ="";
        HashMap<String, String> params = new HashMap<String, String>();
		String time_stamp = System.currentTimeMillis()/1000+"";
		params.put("app_id", app_id);
		params.put("time_stamp", time_stamp);
		params.put("nonce_str", RandomNonceStrUtil.getRandomString());
		params.put("format", Integer.toString(format));
		params.put("rate",Integer.toString(rate));
		params.put("seq",Integer.toString(seq));
		params.put("len", Integer.toString(len));
		params.put("end", Integer.toString(end));
		params.put("bits", Integer.toString(bits));
		params.put("cont_res", Integer.toString(cont_res));
		params.put("speech_id",RandomNonceStrUtil.getRandomString(10));
		String speech_chunk = Base64Util.encode(audio);
		params.put("speech_chunk", speech_chunk);
        String sign = TencentAISignSort.getSignature(params,app_key);
		params.put("sign",sign);
        result = HttpUtil.post(SpeechConsts.SPEECH_ASR_WX,TencentAISignSort.getParams(params));
        return result;
    }
	 /**
     * 语音识别-流式版(WeChat AI) 	
     * 对音频进行语音识别，并返回语音的文字内容
     * @param filePath - 音频文件本地路径
     * @param format - 语音压缩格式编码 PCM-1 WAV-2 AMR-3 SILK-4
     * @param rate - 语音采样率编码 8000 16000
     * @param bits 音频采样位数 16
     * @param seq 语音分片所在语音流的偏移量（字节）
     * @param len 语音分片长度（字节）
     * @param end 是否结束分片标识  0中间分片 1结束分片
     * @param cont_res 是否获取中间识别结果 0不获取 1获取
     * @return String
	 * @throws Exception 
     */
    public String asrWx(String filePath,int format,int rate,int bits,int seq,int len,int end,int cont_res) throws Exception{
    	byte[] audio = FileUtil.readFileByBytes(filePath);
        return asrWx(audio, format, rate, bits, seq, len, end, cont_res);
    }
}
