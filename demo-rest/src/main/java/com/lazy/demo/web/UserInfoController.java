package com.lazy.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lazy.demo.sys.UserInfoSvc;
import com.lazy.demo.web.common.BascController;

/***
 * Description: 
 *
 * @author: xieweili
 * @since: 2017年1月16日	
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
@Controller
public class UserInfoController extends BascController{
    
    private static final Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoSvc userInfoSvc;
    
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject index1() {
        JSONObject json = new JSONObject();
        
        LOG.info(json.toJSONString());
        return json;
    }
    
    @RequestMapping(value = "/tes121t", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest req) {
        ModelAndView m = new ModelAndView("pay");
        
        LOG.info(getSession(req).getId());
        m.addObject("test", "asdfafdasdfas");
        return m;
    }
}

	