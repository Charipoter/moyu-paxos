package com.moyu.paxos.exchange;

import io.netty.channel.Channel;

import java.util.concurrent.CompletableFuture;

/**
 * 数据交换器，即通讯器
 */
public interface Exchanger {

    /**
     * 开启通讯
     */
    Channel open(String host, int port);

    /**
     * 发送消息
     */
    CompletableFuture<Object> sendAsync(Object msg);

    /**
     * 关闭
     */
    void close();


}
