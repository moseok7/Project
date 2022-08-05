package com.mealkit.board;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/community/*")
public class CommunityController {

  private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);

  @Inject
  private CommunityService service;

//  @RequestMapping(value = "/write", method = RequestMethod.GET)
//  public void writeGET(CommunityVO community, Model model) throws Exception {
//
//    logger.info("write get ...........");
//  }

  // @RequestMapping(value = "/register", method = RequestMethod.POST)
  // public String registPOST(BoardVO board, Model model) throws Exception {
  //
  // logger.info("regist post ...........");
  // logger.info(board.toString());
  //
  // service.regist(board);
  //
  // model.addAttribute("result", "success");
  //
  // //return "/board/success";
  // return "redirect:/board/listAll";
  // }

//  @RequestMapping(value = "/write", method = RequestMethod.POST)
//  public String registPOST(CommunityVO community, RedirectAttributes rttr) throws Exception {
//
//    logger.info("write post ...........");
//    logger.info(community.toString());
//
//    service.regist(community);
//
//    rttr.addFlashAttribute("msg", "SUCCESS");
//    return "redirect:/board/listAll";
//  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public void list(Model model) throws Exception {

    logger.info("show all list......................");
    
    model.addAttribute("list", service.list());
    
  }

  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public void read(@RequestParam("cNo") int cNo, Model model) throws Exception {

    model.addAttribute("CommunityVO",service.read(cNo));
  }

//  @RequestMapping(value = "/remove", method = RequestMethod.POST)
//  public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
//
//    service.remove(bno);
//
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listAll";
//  }
//
  @RequestMapping(value = "/update", method = RequestMethod.GET)
  public void modifyGET(int cNo, Model model) throws Exception {

    model.addAttribute(service.read(cNo));
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String modifyPOST(CommunityVO community, RedirectAttributes rttr) throws Exception {

    logger.info("mod post............");

    service.update(community);
    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/board/list";
  }

//  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
//  public void listAll(Criteria cri, Model model) throws Exception {
//
//    logger.info("show list Page with Criteria......................");
//
//    model.addAttribute("list", service.listCriteria(cri));
//  }
//
//  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
//  public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    logger.info(cri.toString());
//
//    model.addAttribute("list", service.listCriteria(cri));
//    PageMaker pageMaker = new PageMaker();
//    pageMaker.setCri(cri);
//    // pageMaker.setTotalCount(131);
//
//    pageMaker.setTotalCount(service.listCountCriteria(cri));
//
//    model.addAttribute("pageMaker", pageMaker);
//  }
//
//  @RequestMapping(value = "/readPage", method = RequestMethod.GET)
//  public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }

//  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
//  public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
//
//    service.remove(bno);
//
//    rttr.addAttribute("page", cri.getPage());
//    rttr.addAttribute("perPageNum", cri.getPerPageNum());
//    rttr.addFlashAttribute("msg", "SUCCESS");
//
//    return "redirect:/board/listPage";
//  }
//
//  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
//  public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model)
//      throws Exception {
//
//    model.addAttribute(service.read(bno));
//  }

}
