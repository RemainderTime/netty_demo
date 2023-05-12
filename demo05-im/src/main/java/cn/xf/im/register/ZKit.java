package cn.xf.im.register;

import cn.xf.im.constants.ImConstant;
import org.I0Itec.zkclient.ZkClient;

/**
 * @description:
 * @author: lld
 * @version: 1.0
 */
public class ZKit {

    private ZkClient zkClient;

    public ZKit(ZkClient zkClient) {
        this.zkClient = zkClient;
    }

    //im-coreRoot/tcp/ip:port
    public void createRootNode(){
        boolean exists = zkClient.exists(ImConstant.ImCoreZkRoot);
        if(!exists){
            zkClient.createPersistent(ImConstant.ImCoreZkRoot);
        }
        boolean tcpExists = zkClient.exists(ImConstant.ImCoreZkRoot +
                ImConstant.ImCoreZkRootTcp);
        if(!tcpExists){
            zkClient.createPersistent(ImConstant.ImCoreZkRoot +
                    ImConstant.ImCoreZkRootTcp);
        }

        boolean webExists = zkClient.exists(ImConstant.ImCoreZkRoot +
                ImConstant.ImCoreZkRootWeb);
        if(!tcpExists){
            zkClient.createPersistent(ImConstant.ImCoreZkRoot +
                    ImConstant.ImCoreZkRootWeb);
        }
    }

    //ip+port
    public void createNode(String path){
        if(!zkClient.exists(path)){
            zkClient.createPersistent(path);
        }
    }
}
