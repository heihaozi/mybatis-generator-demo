package one.more.mybatisgenerator.controller;

import one.more.mybatisgenerator.model.UserInfo;
import one.more.mybatisgenerator.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<UserInfo> get(@RequestParam(value = "minAge") Integer minAge) {
        return userInfoService.getGreaterThan(minAge);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public UserInfo add() {
        return userInfoService.add();
    }
}
