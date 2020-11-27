/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.microlabs.structural.proxy.static_proxy;

/**
 * @author rolex
 * @since 2020
 */
public class ImageProxy implements Image, Advice {

    private Image target;

    public ImageProxy(String imageFilePath) {
        this.target = new JPEGImage(imageFilePath);
    }

    @Override
    public void display() {
        before();
        target.display();
        after();
    }

    @Override
    public void before() {
        System.out.println("before");
    }

    @Override
    public void after() {
        System.out.println("after");
    }
}