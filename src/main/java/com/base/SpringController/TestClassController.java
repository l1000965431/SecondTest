package com.base.SpringController;


import com.base.SpringControllerModel.Usermodel;
import com.base.SpringServiceTest.SpringServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by liumin on 15/12/22.
 */

@Controller
@RequestMapping("/Test")
public class TestClassController {

    @Autowired
    private SpringServiceTest springServiceTest;

    @RequestMapping("/TestClassUser")
    @ResponseBody
    public String TestClassUser(Usermodel user, HttpSession session) {
        System.out.println("姓名:" + user.getName());
        System.out.println("ID:" + user.getId());
        session.setAttribute("User", user);
        return "1";
    }

    @RequestMapping("/TestAdd")
    @ResponseBody
    public String TestAdd() {
        springServiceTest.TraddUser("seele");
        return "1";
    }

    @RequestMapping(value = "/Testget",produces = { MediaType.APPLICATION_JSON_VALUE
            + ";charset=UTF-8" })
    @ResponseBody
    public List Testget() {
        return springServiceTest.TrgetUser();
    }

    @RequestMapping("/TestSetSession")
    @ResponseBody
    public String TestSetSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("msg", "seele126");
        return "1";
    }

    @RequestMapping("/TestGetSession")
    @ResponseBody
    public String TestGetSession(HttpSession session) {
        return session.getAttribute("msg").toString();
    }
}
