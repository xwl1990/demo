package com.lazy.demo.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/***
 * Description: 
 *
 * @author: xieweili
 * @since: 2017年1月16日	
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public abstract class BascController {

    public HttpSession getSession(HttpServletRequest req){
        return req.getSession(true);
    }
}
