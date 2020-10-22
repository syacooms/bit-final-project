package com.bit.paperhouse.controller;

import com.bit.paperhouse.dto.QnaDto;
import com.bit.paperhouse.model.CustomSecurityDetails;
import com.bit.paperhouse.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QnaController {

    @Autowired
    QnaService service;

    /**
     * qna 게시판 이동
     *
     * @param model
     * @return
     */
//    @ResponseBody  에애잭스 쓸려면 따로 만들어야함
    @GetMapping("/qna")
    public String qna(Model model, QnaDto dto ,Authentication auth) {
        CustomSecurityDetails user = (CustomSecurityDetails) auth.getPrincipal();
        dto.setUserSeq(user.getUSERSEQ());


        List<QnaDto> list = service.qnaList(dto);
        model.addAttribute("qna", list);


        return "qna";

    }
    @ResponseBody
    @GetMapping("/qna/search")
    public List<QnaDto> qnaSearch(QnaDto dto ,Authentication auth){
        CustomSecurityDetails user = (CustomSecurityDetails) auth.getPrincipal();
        dto.setUserSeq(user.getUSERSEQ());
        System.out.println("choice:" + dto.getChoice());
        System.out.println("searchWord:" + dto.getSearchWord());
        System.out.println("RecordCountPerPage" + dto.getRecordCountPerPage());

        // 페이징 처리
        int sn = dto.getPageNumber();
        int start = sn * dto.getRecordCountPerPage() + 1; // 1  11 21
        int end = (sn + 1) * dto.getRecordCountPerPage();  //10  20 30  글이 11개가 되 면 10개만 보이고 1개는 그다음 페이지로 이동

             dto.setStart(start);
             dto.setEnd(end);


        List<QnaDto> qna =  service.qnaSearchList(dto);


        return qna;
    }

    @ResponseBody
    @GetMapping("/qna/count")
    public  int count(QnaDto dto ,Authentication auth){
        CustomSecurityDetails user = (CustomSecurityDetails) auth.getPrincipal();
        dto.setUserSeq(user.getUSERSEQ());

        int count = service.qnaCount(dto);

        return count;
    }


    @GetMapping("/qna/write")
    public String writeQna() {

        return "qnaWrite";
    }

    @PostMapping("/qna/writeAf")
    public String writeQnaAf(QnaDto dto, Authentication auth) {
        CustomSecurityDetails user = (CustomSecurityDetails) auth.getPrincipal();
        dto.setUserSeq(user.getUSERSEQ());
        service.writeQnaAf(dto);
        return "redirect:/qna";
    }

    @GetMapping("/qna/detail")
    public String detailQna(QnaDto dto, Model model, @RequestParam("qnaSeq") int qnaSeq ) {
        CustomSecurityDetails user = (CustomSecurityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userSeq = user.getUSERSEQ();
        model.addAttribute("userSeq", userSeq);


        QnaDto qna = service.qnaDetail(qnaSeq);
        model.addAttribute("qnaDetail", qna);

        //List<QnaDto> list = service.qnaList(dto);
        //model.addAttribute("qnaDetail" , list);
        return "qnaDetail";
    }

    @GetMapping("/qna/update")
    public String updateQna(QnaDto qto,Model model,  @RequestParam("qnaSeq") int qnaSeq) {
        CustomSecurityDetails user = (CustomSecurityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userSeq = user.getUSERSEQ();
        List<QnaDto> qna = service.qnaUpdate(qnaSeq);

        model.addAttribute("userSeq", userSeq);
        model.addAttribute("qnaUpdate",qna);
        model.addAttribute(qnaSeq);
        return "qnaUpdate";
    }
    @PostMapping("/qna/updateAf")
    public String updateQnaAf(QnaDto dto){

        service.qnaUpdateAf(dto);

        return "redirect:/qna";
    }

    @PostMapping("/qna/reply")
    public String qnaReply(Model model , QnaDto dto ){
        CustomSecurityDetails user = (CustomSecurityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userSeq = user.getUSERSEQ();

        service.qnaReply(dto);

        model.addAttribute("user", userSeq);

            return "qnaDetail";
    }
    @PostMapping("/qna/replyAf")
    public String qnaReplyAf(QnaDto dto){

       service.qnaReplyUpdate(dto);

        return "qnaDetail";
    }

    @PostMapping("/qna/insert")
    public String qnaReplyInsert(QnaDto dto){

         service.qnaReplyInsert(dto);

        return "qnaDetail";
    }


}