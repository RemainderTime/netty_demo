package cn.xf.netty.web;

import cn.xf.netty.server.NettyServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Description:
 * @ClassName: NettyController
 * @Author: xiongfeng
 * @Date: 2023/5/6 13:53
 * @Version: 1.0
 */
@Controller
public class NettyController {

	@Resource
	private NettyServer nettyServer;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("name", "xiaohao");
		return "index";
	}
}
