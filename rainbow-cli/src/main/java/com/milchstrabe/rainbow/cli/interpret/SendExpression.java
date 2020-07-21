package com.milchstrabe.rainbow.cli.interpret;

import com.google.protobuf.ByteString;
import com.milchstrabe.rainbow.cli.CLI;
import com.milchstrabe.rainbow.cli.client.TCPClient;
import com.milchstrabe.rainbow.skt.server.codc.Data;
import com.milchstrabe.rainbow.skt.server.typ3.grpc.Msg;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @Author ch3ng
 * @Date 2020/4/26 23:42
 * @Version 1.0
 * @Description
 **/
public class SendExpression implements CMDExpression {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean interpret(String data) {
        String regex = "\\s+";
        String[] split = data.split(regex);
        String rec = split[1];
        String[] split1 = data.split(rec);
        String msg = split1[1];

        /** 
         *  string msgId = 1;
         *     int32 msgType = 2;
         *     string content = 3;
         *     string sender = 4;
         *     string receiver = 5;
         *     long date = 6;
         */
        Msg.MsgRequest msgRequest = Msg.MsgRequest.newBuilder()
                .setMsgId(UUID.randomUUID().toString())
                .setMsgType(1)
                .setContent(msg)
                .setSender(CLI.user.getUsername())
                .setReceiver(rec)
                .setDate(System.currentTimeMillis())
                .build();

        ByteString bytes = msgRequest.toByteString();
        Data.Request request = Data.Request.newBuilder()
                .setCmd1(1)
                .setCmd2(1)
                .setData(bytes)
                .build();
        TCPClient.f.channel().writeAndFlush(request);
        return true;
    }
}
