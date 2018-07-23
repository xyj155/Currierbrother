package com.example.currierbrother.controller;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.example.currierbrother.util.JiguangPush;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jpush")
public class JPushController {

    @RequestMapping("/request")
    @ResponseBody
    public Map<String, String> addArticle() throws Exception {
        Map<String, String> parm = new HashMap<String, String>();
        parm.put("id", "1");
        parm.put("Atitle", "浙江省嘉兴学院");
        parm.put("msg", "122323");
        JiguangPush.jpushAndroid(parm);
        return parm;
    }
}
