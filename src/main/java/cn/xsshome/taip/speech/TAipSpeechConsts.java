package cn.xsshome.taip.speech;

public class TAipSpeechConsts {
	//语音识别-echo版
	static final String SPEECH_ASR_AAI = "https://api.ai.qq.com/fcgi-bin/aai/aai_asr";
	//语音识别-流式版（AI Lab）
	static final String SPEECH_ASR_AAIS = "https://api.ai.qq.com/fcgi-bin/aai/aai_asrs";
	//语音识别-流式版(WeChat AI) 	
	static final String SPEECH_ASR_WX = "https://api.ai.qq.com/fcgi-bin/aai/aai_wxasrs";
	//长语音识别
	static final String SPEECH_ASRLONG = "https://api.ai.qq.com/fcgi-bin/aai/aai_wxasrlong";
	// 语音合成（AI Lab）
	static final String SPEECH_TTS_TTS = "https://api.ai.qq.com/fcgi-bin/aai/aai_tts";
	// 语音合成（优图）
	static final String SPEECH_TTS_TTA = "https://api.ai.qq.com/fcgi-bin/aai/aai_tta";
}
