package one.more.mybatisgenerator.service;

import one.more.mybatisgenerator.mapper.UserInfoMapper;
import one.more.mybatisgenerator.model.UserInfo;
import one.more.mybatisgenerator.model.UserInfoExample;
import one.more.mybatisgenerator.model.UserInfoExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getGreaterThan(Integer age) {
        UserInfoExample example = new UserInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andAgeGreaterThan(age);
        return userInfoMapper.selectByExample(example);
    }

    public UserInfo add() {
        Random random = new Random(System.currentTimeMillis());
        UserInfo userInfo = new UserInfo();
        userInfo.setName("name" + random.nextInt(100));
        userInfo.setAge(random.nextInt(100));
        userInfo.setCreateTime(new Date());

        int rows = userInfoMapper.insert(userInfo);
        System.out.println("rows:" + rows);
        return userInfo;
    }
}
