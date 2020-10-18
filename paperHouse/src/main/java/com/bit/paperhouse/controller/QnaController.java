package com.bit.paperhouse.controller;

import com.bit.paperhouse.dto.QnaDto;
import com.bit.paperhouse.model.CustomSecurityDetails;
import com.bit.paperhouse.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class QnaController {

    @Autowired
    QnaService service;


    @GetMapping("/qna/main")
    public String qna(Model model){

        List<QnaDto>  list = service.qnaList();
        model.addAttribute("qna" , list);
        System.out.println(list.toString());

        return "qna";

    }

    @GetMapping("/qna/write")
    public String writeQna(){

        return "qnaWrite";
    }
    @PostMapping("/qna/writeAf")
    public String writeQnaAf(QnaDto dto){

        service.writeQnaAf(dto);

        return "redirect:/qna/main";
    }
    @PostMapping("/qna/security")
    public String security(Model model){
        CustomSecurityDetails user = (CustomSecurityDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userSeq = user.getUSERSEQ();
        model.addAttribute("user",userSeq);

        return "/qna/main";
    }


}
