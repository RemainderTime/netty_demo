package cn.xf.im.domain;

import lombok.Data;

/**
 * @Description: 用户登陆信息
 * @ClassName: UserSession
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:36
 * @Version: 1.0
 */
@Data
public class UserSession {

	private Integer clientType;
	/**
	 * 应用ID
	 */
//    4字节 appId
	private Integer appId;
	/**
	 * 数据解析类型 和具体业务无关，后续根据解析类型解析data数据 0x0:Json,0x1:ProtoBuf,0x2:Xml,默认:0x0
	 */
	//4字节 解析类型
	private Integer messageType = 0x0;

	private Integer userId;

	//imei号
	private String imei;

	//用户在线状态 1：在线 2:离线
	private Integer connectStatus;


}
