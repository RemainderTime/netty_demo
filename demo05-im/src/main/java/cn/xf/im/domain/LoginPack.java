package cn.xf.im.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @ClassName: LoginPack
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:34
 * @Version: 1.0
 */

@Data
public class LoginPack implements Serializable {

	private Integer userId;

	private String userName;
}
