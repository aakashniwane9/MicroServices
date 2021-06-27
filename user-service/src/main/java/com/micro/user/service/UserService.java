package com.micro.user.service;

import com.micro.user.VO.Department;
import com.micro.user.VO.ResponseTemplateVO;
import com.micro.user.entity.User;
import com.micro.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("inside saveUser -> UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment -> UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        User user = userRepository.findByUserId(userId);
        String url = "http://DEPARTMENT-SERVICE/departments/get?id=" + user.getDepartmentId();
        Department department = restTemplate.getForObject(url, Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }


}

