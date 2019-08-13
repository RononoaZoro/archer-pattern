package com.luo.mvc;

import com.luo.mvc.controllers.MemberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoxuzheng
 * @create 2019-08-13 17:27
 **/
public class ServletDispatcher {
    private List<Handler> handlerMapping = new ArrayList<>();

    class Handler{
        private Object controller;
        private String url;
        private Method method;

        public Object getController() {
            return controller;
        }

        public Handler setController(Object controller) {
            this.controller = controller;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Handler setUrl(String url) {
            this.url = url;
            return this;
        }

        public Method getMethod() {
            return method;
        }

        public Handler setMethod(Method method) {
            this.method = method;
            return this;
        }
    }

    public ServletDispatcher() {

        try {
            Class<MemberAction> memberActionClass = MemberAction.class;
            handlerMapping.add(new Handler().setController(memberActionClass.newInstance())
                    .setMethod(memberActionClass.getMethod("getMemberById",new Class[]{String.class}))
                    .setUrl("/web/getMemberById.json"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    public void doService(HttpServletRequest request,
                          HttpServletResponse response){
        doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        //1、获取用户请求的url，如果是J2EE的标准，每个url对应一个sevlet，由浏览器输入
        String requestURI = request.getRequestURI();

        //2、servlet拿到url以后，要做权衡（要做判断，要做选择），根据用户请求的url找到对应的java类的方法
        //3、通过拿到的url去handlermapping查找对应的执行类和方法，（我们认为是策略常量）
        Handler handler = null;
        for (Handler h:handlerMapping){
            if(requestURI.equals(h.getUrl())){
                handler = h;
                break;
            }
        }

        //4、将具体的任务发给找到的Hanlder中的method去执行(利用反射)
        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(),
                    request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5、将获取到的结果写到浏览器
//        try {
//            response.getWriter().write();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



}
