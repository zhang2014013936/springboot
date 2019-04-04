package com.dharma.demo.api.conterller;

import com.dharma.demo.api.bean.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/index")
public class IndexController {
    @Value(value ="good afternoon")
    private String greeting;

    @Value(value ="${dharma.randomInt")
    private String build;

    @Value(value ="${dharma.randomString")
    private String uuid;

    @Value(value ="${dharma.project")
    private String project;

    @Value(value ="${dharma.noexist:default")
    private String unknown;

    @Value(value ="${dharma.team")
    private String[]team;

    @Value(value = "#{admin.name}")
    private String admin;

    @Bean
    public Admin admin(){
        return new Admin("zhangqiang");
    }
    @GetMapping("/system")

    public HashMap<String,Object> sys(){
        HashMap<String,Object> sys =new HashMap<>();
        sys.put("project",project);
        sys.put("build",build);
        sys.put("unknown",unknown);
        sys.put("team",team);
        sys.put("admin",admin);
        sys.put("admin",uuid);
        return sys;
    }

}
