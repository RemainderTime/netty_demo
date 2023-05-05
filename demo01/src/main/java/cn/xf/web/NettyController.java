package cn.xf.web;

import cn.xf.server.NettyServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: NettyController
 * @Author: xiongfeng
 * @Date: 2023/5/5 16:30
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/nettyServer", method = RequestMethod.GET)
public class NettyController {

	@Resource
	private NettyServer nettyServer;

	@RequestMapping("/localAddress")
	public String localAddress() {
		return "nettyServer localAddress " + nettyServer.getChannel().localAddress();
	}

	@RequestMapping("/isOpen")
	public String isOpen() {
		return "nettyServer isOpen " + nettyServer.getChannel().isOpen();
	}

}
