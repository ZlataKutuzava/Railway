package com.Web_layer;

import com.Database_layer.Station;
import com.Database_layer.Train;
import com.Domain_layer.StationDomain;
import com.Domain_layer.TrainsDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TrainsController {
    private TrainsDomain trainsDomain = new TrainsDomain();

    @RequestMapping("/trains")
    public ModelAndView GetStations(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Iterable<Train> trains = trainsDomain.GetTrains();
        ModelAndView modelAndView = new ModelAndView("trains.jsp");
        modelAndView.addObject("trains", trains);
        return  modelAndView;
    }

    @RequestMapping("/trains/delete/{id}")
    public ModelAndView DeleteTrain(@PathVariable Integer id){
        trainsDomain.DeleteTrain(id);
        return new ModelAndView("redirect:/trains");
    }

    @RequestMapping("/trains/edit/{trainId}")
    public ModelAndView EditTrain(@PathVariable Integer trainId){
        Train train = trainsDomain.GetTrain(trainId);
        return new ModelAndView("/add/addTrains.jsp","train",train);
    }

    @RequestMapping(value = "/trains/edit/{trainId}", method = RequestMethod.POST)
    public ModelAndView EditTrain(@PathVariable Integer trainId,
                                  @RequestParam Integer trainNumber,
                                  @RequestParam String trainType){
        trainsDomain.UpdateTrain(trainId,trainNumber,trainType);
        return new ModelAndView("redirect:/trains");
    }

    @RequestMapping(value = "trains/add")
    public ModelAndView AddStation(){
        return new ModelAndView("/add/addTrains.jsp");
    }

    @RequestMapping(value = "/trains/add",method = RequestMethod.POST)
    public ModelAndView AddTrain(@RequestParam Integer trainNumber,
                                 @RequestParam String trainType){
        trainsDomain.CreateTrain(trainNumber,trainType);
        return new ModelAndView("redirect:/trains");
    }
}
