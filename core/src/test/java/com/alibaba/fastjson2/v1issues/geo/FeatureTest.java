package com.alibaba.fastjson2.v1issues.geo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson.support.geo.Feature;
import com.alibaba.fastjson.support.geo.Geometry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureTest {
    @Test
    public void test_geo() {
        String str = "{\n" +
                "    \"type\": \"Feature\",\n" +
                "    \"bbox\": [-10.0, -10.0, 10.0, 10.0],\n" +
                "    \"geometry\": {\n" +
                "       \"type\": \"Polygon\",\n" +
                "       \"coordinates\": [\n" +
                "           [\n" +
                "               [-10.0, -10.0],\n" +
                "               [10.0, -10.0],\n" +
                "               [10.0, 10.0],\n" +
                "               [-10.0, -10.0]\n" +
                "           ]\n" +
                "       ]\n" +
                "    }\n" +
                "}";

        Geometry geometry = JSON.parseObject(str, Geometry.class);
        assertEquals(Feature.class, geometry.getClass());

        assertEquals("{\"type\":\"Feature\",\"bbox\":[-10.0,-10.0,10.0,10.0],\"properties\":{},\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[-10.0,-10.0],[10.0,-10.0],[10.0,10.0],[-10.0,-10.0]]]}}", JSON.toJSONString(geometry));

        String str2 = JSON.toJSONString(geometry);
        assertEquals(str2, JSON.toJSONString(JSON.parseObject(str2, Geometry.class)));
    }

    @Test
    public void test_geo_1() throws Exception {
        String str = "{\n" +
                "    \"type\": \"Feature\",\n" +
                "    \"id\": \"f2\",\n" +
                "    \"geometry\": {\n" +
                "       \"type\": \"Polygon\",\n" +
                "       \"coordinates\": [\n" +
                "           [\n" +
                "               [-10.0, -10.0],\n" +
                "               [10.0, -10.0],\n" +
                "               [10.0, 10.0],\n" +
                "               [-10.0, -10.0]\n" +
                "           ]\n" +
                "       ]\n" +
                "    }\n" +
                "}";

        Geometry geometry = JSON.parseObject(str, Geometry.class);
        assertEquals(Feature.class, geometry.getClass());

        assertEquals("{\"type\":\"Feature\",\"id\":\"f2\",\"properties\":{},\"geometry\":{\"type\":\"Polygon\",\"coordinates\":[[[-10.0,-10.0],[10.0,-10.0],[10.0,10.0],[-10.0,-10.0]]]}}", JSON.toJSONString(geometry));

        String str2 = JSON.toJSONString(geometry);
        assertEquals(str2, JSON.toJSONString(JSON.parseObject(str2, Geometry.class)));
    }
}
