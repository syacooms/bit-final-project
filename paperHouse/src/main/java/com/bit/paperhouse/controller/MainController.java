package com.bit.paperhouse.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.paperhouse.dto.ArticleDto;
import com.bit.paperhouse.dto.UserReviewDto;
import com.bit.paperhouse.dto.WriterDto;
import com.bit.paperhouse.service.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainSvc;
	
	  // 첫 페이지
    @GetMapping("/")
    public String index() {
    	System.out.println("index()");

   
       return "/index";
    }
    
    // 메인 페이지
  //  @Secured("ROLE_USER")    
    @GetMapping("/main")
    public String main(Model model) throws Exception {
    	System.out.println("main()");
    	
    	String category = "소설";
    	
    	List<WriterDto> writerList = mainSvc.getWriterlist();
 	
    	model.addAttribute("writerList", writerList);
    	
    	Calendar cal = Calendar.getInstance();
    	List<String> today = todaySentence();
    	String todaySentence = today.get(cal.get(Calendar.DAY_OF_MONTH));
    	
        model.addAttribute("todaySentence", todaySentence);
        
        List<ArticleDto> articleList = mainSvc.getArticleList(category);
             
        model.addAttribute("articleList", articleList); 
        
        WriterDto dto = mainSvc.getTodayWriter();
        dto.setIntro('"'+dto.getIntro()+'"');
       
        model.addAttribute("todayWriter", dto); 
        
        UserReviewDto review = mainSvc.getTodayWriterRecommend(dto.getWriterSeq());
        review.setCont("'"+ review.getCont() +"'");
        model.addAttribute("review", review);
        
        return "/main";
    }
    
    // 취향별 추천글
    @GetMapping("/main/articleWrap")
    public @ResponseBody List<ArticleDto> article(String category) {
    	
    	List<ArticleDto> articleList = mainSvc.getArticleList(category);
        
        return articleList;
    }
    

     
    
    
    
    
    // 오늘의 문장
	public List<String> todaySentence() throws Exception{
		
		String url = "https://www.millie.co.kr/viewfinder/more_quot.html?post_seq=293247";
		
		Connection.Response response = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .execute();
		
		Document ddo = response.parse();
		
		String todaySentence = ddo.text();
		
		String[] pstr2 = todaySentence.split("상세보기|<");
		
		List<String> list =  new ArrayList<String>();
		
		for(int i = 0; i < pstr2.length; i++) {
	     	if(i%2 == 0 && i != 0 && i != pstr2.length-1) {
	     		list.add(pstr2[i]);
	     	}	     	
		}		
          return list;  	
	}
	
}
