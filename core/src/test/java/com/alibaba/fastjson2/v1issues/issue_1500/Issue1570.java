package com.alibaba.fastjson2.v1issues.issue_1500;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Issue1570 {
    @Test
    public void test_for_issue() throws Exception {
        Model model = new Model();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":\"\"}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    @Test
    public void test_for_issue_string() throws Exception {
        ModelString model = new ModelString();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":\"\"}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    @Test
    public void test_for_issue_int() throws Exception {
        ModelInt model = new ModelInt();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":0}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    @Test
    public void test_for_issue_long() throws Exception {
        ModelLong model = new ModelLong();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":0}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    @Test
    public void test_for_issue_bool() throws Exception {
        ModelBool model = new ModelBool();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":false}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    @Test
    public void test_for_issue_list() throws Exception {
        ModelList model = new ModelList();
        assertEquals("{}", JSON.toJSONString(model));
        assertEquals("{\"value\":[]}", JSON.toJSONString(model, JSONWriter.Feature.NullAsDefaultValue));
    }

    public static class Model {
        public String value;
    }

    static class ModelString {
        public String value;
    }

    public static class ModelInt {
        public Integer value;
    }

    public static class ModelLong {
        public Long value;
    }

    public static class ModelBool {
        public Boolean value;
    }

    public static class ModelList {
        public List value;
    }
}
