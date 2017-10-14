package com.Web_layer;

import com.Database_layer.Route;
import com.Domain_layer.RouteDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class RouteController {

    RouteDomain routeDomain = new RouteDomain();

    @RequestMapping("/routes")
    public ModelAndView GetRoutes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Iterable<Route> routes = routeDomain.GetRoutes();
        ModelAndView modelAndView = new ModelAndView("route.jsp");
        modelAndView.addObject("routes", routes);
        return  modelAndView;
    }

    @RequestMapping("/routes/delete/{id}")
    public ModelAndView DeleteRoute(@PathVariable Integer id){
        routeDomain.DeleteRoute(id);
        return new ModelAndView("redirect:/routes");
    }

    @RequestMapping("/routes/edit/{routeId}")
    public ModelAndView EditRoute(@PathVariable(value = "routeId") Integer id){
        Route route = routeDomain.GetRoute(id);
        return new ModelAndView("/add/addRoute.jsp","route",route);
    }

    @RequestMapping(value = "/routes/edit/{routeId}", method = RequestMethod.POST)
    public ModelAndView EditRoute(@PathVariable(value = "routeId") Integer id,
                                  @RequestParam Integer trainId,
                                  @RequestParam Integer stationId,
                                  @RequestParam String timeArrival,
                                  @RequestParam String timeDeparture){
        routeDomain.UpdateRoute(id,stationId,trainId,timeArrival,timeDeparture);
        return new ModelAndView("redirect:/routes");
    }

    @RequestMapping(value = "routes/add")
    public ModelAndView AddRoute(){
        return new ModelAndView("/add/addRoute.jsp");
    }

    @RequestMapping(value = "routes/add", method = RequestMethod.POST)
    public ModelAndView AddRoute(@RequestParam Integer trainId,
                                 @RequestParam Integer stationId,
                                 @RequestParam String timeArrival,
                                 @RequestParam String timeDeparture){
        routeDomain.CreateRoute(trainId,stationId,timeArrival,timeDeparture);
        return new ModelAndView("redirect:/routes");
    }
}
