package com.alibaba.fastjson2.v1issues.issue_1100;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wenshao on 05/05/2017.
 */
public class Issue1177_1 {
    @Test
    public void test_for_issue() throws Exception {
        String text = "{\"a\":{\"x\":\"y\"},\"b\":{\"x\":\"y\"}}";
        JSONObject jsonObject = JSON.parseObject(text);
        System.out.println(jsonObject);
        String jsonpath = "$..x";
        String value="y2";
        JSONPath.set(jsonObject, jsonpath, value);
        String result = jsonObject.toString();
        assertEquals("{\"a\":{\"x\":\"y2\"},\"b\":{\"x\":\"y2\"}}", result);

    }
}
