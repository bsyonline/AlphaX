/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.microlabs.structural.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rolex
 * @since 2020
 */
@Slf4j
public class IndustryAndCommerceBureau implements Government{

    @Override
    public void approve(){
        log.info("工商局审批");
    }

}
