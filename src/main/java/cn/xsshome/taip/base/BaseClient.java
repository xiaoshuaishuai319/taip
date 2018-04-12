package cn.xsshome.taip.base;
/**
 * 基础抽象类
 * @author 小帅丶
 * @version 0.0.1
 */
public abstract  class BaseClient {
	protected String app_id;//控制台查看应用对应的AppID
    protected String app_key;//控制台查看应用对应的AppKey
    
    protected BaseClient(String app_id, String app_key) {
		super();
		this.app_id = app_id;
		this.app_key = app_key;
	}
}
