package com.hrm.common.shiro.session;


import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;


/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 15:29
 **/
public class CustomerSessionManager extends DefaultWebSessionManager {
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        //获取请求头Authorization中的数据
        String sessionId = WebUtils.toHttp(request).getHeader("Authorization");
        if(StringUtils.isEmpty(sessionId)) {
            //如果没有携带，生成新的sessionId
            return super.getSessionId(request,response);
        }else {
            sessionId = sessionId.replaceAll("Bearer", "");
            //返回sessionId；
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }
    }

}
