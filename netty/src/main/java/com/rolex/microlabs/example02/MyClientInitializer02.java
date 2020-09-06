/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.microlabs.example02;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author rolex
 * @since 2020
 */
public class MyClientInitializer02 extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new MyClientHandler02());
    }
}