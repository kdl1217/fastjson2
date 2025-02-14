package com.alibaba.fastjson2.v1issues.issue_1400;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimmking on 11/08/2017.
 */
public class Issue1400 {
    @Test
    public void test_for_issue() throws Exception {
        TypeReference tr = new TypeReference<Resource<ArrayList<App>>>(){};
        Bean test = new Bean(tr);
        Resource resource = test.resource;
        Assert.assertEquals(1,resource.ret);
        Assert.assertEquals("ok",resource.message);
        List<App> data =(List<App>) resource.data;
        Assert.assertEquals(2,data.size());
        App app1 = data.get(0);
        Assert.assertEquals("11c53f541dee4f5bbc4f75f99002278c",app1.appId);
    }

    public static class Resource<T> {
        public int ret;
        public String message;
        public T data;
    }

    public static class App {
        public String appId;
    }

    public static class Bean {
        String str = "{\"ret\":1,\"message\":\"ok\",\"data\":[{\"appId\":\"11c53f541dee4f5bbc4f75f99002278c\"},{\"appId\":\"c6102275ce5540a59424defa1cccb8ed\"}]}";
        public Resource resource;
        Bean(TypeReference tr) {
            resource = (Resource)JSON.parseObject(str, tr.getType());
        }
    }
}
