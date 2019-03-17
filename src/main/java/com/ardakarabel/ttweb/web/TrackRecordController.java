package com.ardakarabel.ttweb.web;

import com.ardakarabel.ttweb.config.TrackRecordConstants;
import com.ardakarabel.ttweb.model.TrackRecord;
import com.ardakarabel.ttweb.model.TrackRecordEmail;
import com.ardakarabel.ttweb.service.TrackRecordDBService;
import com.ardakarabel.ttweb.service.TrackRecordRESTService;
import com.ardakarabel.ttweb.validator.RecordFormValidator;
import com.ardakarabel.ttweb.validator.RecordSearchFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrackRecordController {

    private final Logger logger = LoggerFactory.getLogger(TrackRecord.class);
    private ArrayList<String> breadcrumbList;


    @Autowired
    RecordFormValidator trackRecordFormValidator;

    @Autowired
    RecordSearchFormValidator trackRecordSearchFormValidator;

    @InitBinder("recordAddForm")
    protected void addInitBinder(WebDataBinder binder) {
        binder.setValidator(trackRecordFormValidator);
    }

    @InitBinder("searchInitBinder")
    protected void searchInitBinder(WebDataBinder binder) {
        binder.setValidator(trackRecordSearchFormValidator);
    }

    private TrackRecordDBService trackRecordDBService;
    private TrackRecordRESTService trackRecordRESTService;

    @Autowired
    public void setTrackRecordDBService(TrackRecordDBService trackRecordDBService) {
        this.trackRecordDBService = trackRecordDBService;
    }

    @Autowired
    public void setTrackRecordRESTService(TrackRecordRESTService trackRecordRESTServiceService) {
        this.trackRecordRESTService = trackRecordRESTServiceService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        logger.debug("showAllTrackRecords()");
        breadcrumbList = new ArrayList();
        model.addAttribute("siteTitle", "Home Page");
        model.addAttribute("view", "template/main.jsp");
        model.addAttribute("active", "main");
        breadcrumbList.add("Home Page");
        model.addAttribute("breadcrumbList", breadcrumbList);
        model.addAttribute("pattern", TrackRecordConstants.PATTERN);
        model.addAttribute("trackRecords", trackRecordDBService.getAll());
        return "index";
    }

    @RequestMapping(value = "/record/search", method = RequestMethod.GET)
    public String searchRecord(Model model) {
        logger.debug("searchRecord()");
        breadcrumbList = new ArrayList();
        model.addAttribute("siteTitle", "Search Records");
        model.addAttribute("view", "record/search.jsp");
        model.addAttribute("active", "recordShow");
        breadcrumbList.add("Records");
        breadcrumbList.add("Search");
        model.addAttribute("breadcrumbList", breadcrumbList);
        model.addAttribute("pattern", TrackRecordConstants.PATTERN);
        model.addAttribute("recordSearchForm", new TrackRecord());
        return "index";
    }

    @RequestMapping(value = "/record/new", method = RequestMethod.POST)
    public String addTrackRecord(@ModelAttribute("recordAddForm") @Validated TrackRecord trackRecord,
                                 BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("addTrackRecord() : {}", trackRecord);
        newTrackRecordPopulate(model);

        if (result.hasErrors()) {
            model.addAttribute("errorEmail", trackRecord.getEmail());
            model.addAttribute("resultStatus", "error");
        } else {
            try {
                trackRecordDBService.addOrUpdate(trackRecord);
                trackRecordRESTService.add(trackRecord);
                model.addAttribute("resultStatus", "success");
                model.addAttribute("successEmail", trackRecord.getEmail());
                model.addAttribute("recordAddForm", new TrackRecord());
            } catch (Exception e) {
                model.addAttribute("resultStatus", "error");
            }
        }
        return "index";
    }

    // Show Add Record Form
    @RequestMapping(value = "/record/new", method = RequestMethod.GET)
    public String showAddTrackRecordForm(Model model) {
        logger.debug("showAddTrackRecordForm()");
        newTrackRecordPopulate(model);
        model.addAttribute("recordAddForm", new TrackRecord());
        return "index";
    }

    private void newTrackRecordPopulate(Model model) {
        breadcrumbList = new ArrayList();
        model.addAttribute("siteTitle", "New TrackRecord");
        model.addAttribute("view", "record/new.jsp");
        model.addAttribute("active", "recordNew");
        breadcrumbList.add("Records");
        breadcrumbList.add("New");
        model.addAttribute("breadcrumbList", breadcrumbList);
    }

    // Show Record From DB/REST
    @RequestMapping(value = "/record/rest/show", method = RequestMethod.POST)
    public String searchTrackRecord(@ModelAttribute("searchInitBinder") @Validated TrackRecordEmail trackRecordEmail,
                                    BindingResult result, final RedirectAttributes redirectAttributes) {

        String email = trackRecordEmail.getEmail();
        logger.debug("showTrackRecord() email: {}", email);
        redirectAttributes.addFlashAttribute("email", email);

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("result", "error");
            return "redirect:/record/search";
        }


        List<TrackRecord> trackRecords = trackRecordRESTService.getByEmail(email);

        if (trackRecords == null || trackRecords.get(0) == null) {
            redirectAttributes.addFlashAttribute("result", "notfound");
        } else {
            redirectAttributes.addFlashAttribute("trackRecords", trackRecords);
            redirectAttributes.addFlashAttribute("result", "success");
        }

        return "redirect:/record/search";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("record/search");
        model.addObject("result", "error");
        model.addObject("msg", "trackRecord not found");

        return model;

    }

}