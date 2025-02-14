package com.alibaba.fastjson2.v1issues;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by wenshao on 30/07/2017.
 */
public class Issue1330_long {
    @Test
    public void test_for_issue() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"ABC\"}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseLong error") != -1);
    }

    @Test
    public void test_for_issue_1() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":[]}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseLong error") != -1);
    }

    @Test
    public void test_for_issue_2() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":{}}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
        assertTrue(error.getMessage().indexOf("parseLong error") != -1);
    }

    public static class Model {
        public long value;
    }
}
