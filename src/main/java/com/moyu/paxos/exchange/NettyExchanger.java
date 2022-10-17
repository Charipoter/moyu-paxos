package com.moyu.paxos.exchange;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class NettyExchanger implements Exchanger {

    private static final ConcurrentHashMap<Channel, NettyExchanger> CHANNEL_MAP = new ConcurrentHashMap<>();

    private Channel channel;

    @Override
    public Channel open(String host, int port) {
        Bootstrap bootstrap = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {

                    }
                })
                .remoteAddress(host, port);

        return bootstrap.connect().channel();
    }

    @Override
    public CompletableFuture<Object> sendAsync(Object msg) {



        return null;
    }

    @Override
    public void close() {

    }
}
