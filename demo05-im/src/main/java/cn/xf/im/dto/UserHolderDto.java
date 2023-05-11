package cn.xf.im.dto;

import lombok.Data;

/**
 * @Description: 用户通道标识对象
 * @ClassName: UserHolderDto
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:43
 * @Version: 1.0
 */

@Data
public class UserHolderDto {

	private Integer userId;

	private Integer appId;

	private Integer clientType;
}
