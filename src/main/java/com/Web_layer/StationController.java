package com.Web_layer;

import com.Database_layer.Route;
import com.Database_layer.Station;
import com.Domain_layer.RouteDomain;
import com.Domain_layer.StationDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class StationController {
    private StationDomain stationDomain = new StationDomain();

    @RequestMapping("/stations")
    public ModelAndView GetStations(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Iterable<Station> stations = stationDomain.GetStations();
        ModelAndView modelAndView = new ModelAndView("stations.jsp");
        modelAndView.addObject("stations", stations);
        return  modelAndView;
    }

    @RequestMapping("/stations/delete/{id}")
    public ModelAndView DeleteStation(@PathVariable Integer id){
        stationDomain.DeleteStation(id);
        return new ModelAndView("redirect:/stations");
    }

    @RequestMapping("/stations/edit/{stationId}")
    public ModelAndView GetEditForm(@PathVariable Integer stationId){
        Station station = stationDomain.GetStation(stationId);
        return new ModelAndView("add/addStations.jsp","station",station);
    }

    @RequestMapping(value = "/stations/edit/{stationId}",method = RequestMethod.POST)
    public ModelAndView EditStation(@PathVariable Integer stationId,
                                    @RequestParam String stationName){
        stationDomain.UpdateStation(stationId,stationName);
        return new ModelAndView("redirect:/stations");
    }

    @RequestMapping(value = "/stations/add")
    public ModelAndView AddStation(){
        return new ModelAndView("/add/addStations.jsp");
    }

    @RequestMapping(value = "/stations/add", method = RequestMethod.POST)
    public ModelAndView AddStation(@RequestParam String stationName){
        stationDomain.CreateStation(stationName);
        return new ModelAndView("redirect:/stations");
    }
}
