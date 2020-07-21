package com.milchstrabe.rainbow.base.controller;

import com.milchstrabe.rainbow.base.common.constant.SessionKey;
import com.milchstrabe.rainbow.base.server.annotion.NettyController;
import com.milchstrabe.rainbow.base.server.annotion.NettyMapping;
import com.milchstrabe.rainbow.base.server.session.Request;
import com.milchstrabe.rainbow.base.server.session.SessionAttribute;
import com.milchstrabe.rainbow.server.domain.UCI;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author ch3ng
 * @Date 2020/4/21 21:57
 * @Version 1.0
 * @Description
 * cmd1:0 --> cmd2:1
 **/
@Slf4j
@NettyController(cmd = 0)
public class HeartBeatController {

    @NettyMapping(cmd = 1)
    public void heartBeat(Request request){
        SessionAttribute attachment = (SessionAttribute) request.getSession().getAttachment();
        UCI uci = (UCI) attachment.get(SessionKey.CLIENT_IN_SESSION);
        log.info("heart beat-->username:[{}]",uci.getUsername());
    }
}
