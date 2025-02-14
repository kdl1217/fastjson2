package com.alibaba.fastjson2.v1issues.issue_3300;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSON;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author ：Nanqi
 * @Date ：Created in 17:11 2020/7/11
 */
public class Issue3338 {
    @Test
    public void test_for_issue() throws Exception {
        Model model = new Model();
        Map map = new HashMap();
        map.put("nanqi", "因为相信，所以看见。");
        model.setMap(map);

        String jsonString = JSON.toJSONString(model);
        assertTrue(jsonString.contains("因为相信，所以看见。"));

        Model modelBack = JSONObject.parseObject(jsonString, Model.class);
        assertEquals("因为相信，所以看见。", modelBack.getMap().get("nanqi"));
    }

    static class Model {
        private Map map;

        public Map getMap() {
            return map;
        }

        public void setMap(Map map) {
            this.map = map;
        }
    }
}
