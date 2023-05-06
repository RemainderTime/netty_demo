package cn.xf.netty.domain;

/**
 * @Description:
 * @ClassName: ServerMsgProtocol
 * @Author: xiongfeng
 * @Date: 2023/5/6 13:42
 * @Version: 1.0
 */
public class ServerMsgProtocol {

	private int type;             //链接信息;1自发信息、2群发消息
	private String channelId;     //通信管道ID，实际使用中会映射成用户名
	private String userHeadImg;   //用户头像[模拟分配]
	private String msgInfo;       //通信消息

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getUserHeadImg() {
		return userHeadImg;
	}

	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}
}
