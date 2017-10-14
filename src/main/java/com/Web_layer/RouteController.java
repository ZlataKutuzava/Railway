package com.Web_layer;

import com.Database_layer.Route;
import com.Domain_layer.RouteDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class RouteController {



    @RequestMapping("/routes")
    public ModelAndView GetRoutes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        RouteDomain routeDomain = new RouteDomain();
        ArrayList<Route> routes = new ArrayList<Route>();
        routes.add(routeDomain.GetRoute(1));
        ModelAndView modelAndView = new ModelAndView("route.jsp");
        modelAndView.addObject("routeList", routes);
        return  modelAndView;
    }

}
