/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.microlabs.service.impl;

import com.rolex.microlabs.model.PointInfo;
import com.rolex.microlabs.service.GeoOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rolex
 * @since 2020
 */
@Component
public class GeoOpsServiceImpl implements GeoOpsService {
    private final String GEO_KEY = "points";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Long savePoints(Collection<PointInfo> points) {
        //log.info("start to save city info: {}.", JSON.toJSONString(cityInfos));

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        points.forEach(ci -> locations.add(new RedisGeoCommands.GeoLocation<String>(
                ci.getName(), new Point(ci.getLongitude(), ci.getLatitude())
        )));

        //log.info("done to save city info.");

        return ops.add(GEO_KEY, locations);
    }

    @Override
    public List<Point> getPoints(String[] points) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.position(GEO_KEY, points);
    }

    @Override
    public Distance getTwoPointsDistance(String p1, String p2, Metric metric) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return metric == null ? ops.distance(GEO_KEY, p1, p2) : ops.distance(GEO_KEY, p1, p2, metric);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(Circle within, RedisGeoCommands.GeoRadiusCommandArgs args) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ? ops.radius(GEO_KEY, within) : ops.radius(GEO_KEY, within, args);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(String member, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ? ops.radius(GEO_KEY, member, distance) : ops.radius(GEO_KEY, member, distance, args);
    }

    @Override
    public List<String> getCityGeoHash(String[] cities) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.hash(GEO_KEY, cities);
    }
}
