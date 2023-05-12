package cn.xf.im.register;

import cn.xf.im.constants.ImConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: lld
 * @version: 1.0
 */
public class RegistryZK implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(RegistryZK.class);

    private ZKit zKit;

    private String ip;

//    private BootstrapConfig.TcpConfig tcpConfig;

    public RegistryZK(ZKit zKit, String ip) {
        this.zKit = zKit;
        this.ip = ip;
//        this.tcpConfig = tcpConfig;
    }

    @Override
    public void run() {
        zKit.createRootNode();
        String tcpPath = ImConstant.ImCoreZkRoot + ImConstant.ImCoreZkRootTcp + "/" + ip + ":" + 9000;
        zKit.createNode(tcpPath);
        logger.info("Registry zookeeper tcpPath success, msg=[{}]", tcpPath);

//        String webPath =
//                ImConstant.ImCoreZkRoot + ImConstant.ImCoreZkRootWeb + "/" + ip + ":" + tcpConfig.getWebSocketPort();
//        zKit.createNode(webPath);
//        logger.info("Registry zookeeper webPath success, msg=[{}]", tcpPath);

    }
}
