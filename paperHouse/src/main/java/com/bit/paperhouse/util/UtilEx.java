package com.bit.paperhouse.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.bit.paperhouse.dto.WriterDto;
import com.bit.paperhouse.service.MypageService;

import lombok.experimental.SuperBuilder;


public class UtilEx {
	

	//남은 일 수 (date) 계산 
	//기한 만료 시 카운트 30 ...! lastcount = -1
	public static int Onelastcount(String lastdate) {
		
		int lastcount = 0;
		
		
		Calendar cal1 = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yy-MM-dd");
        Date date = null;
        try {
        	cal1.setTime(df.parse(lastdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        
        System.out.println("마지막 날짜: " + df.format(cal1.getTime()));
        System.out.println("현재 날짜   : " + df.format(cal2.getTime()));
        
        cal1.add(Calendar.DATE, - cal2.get(Calendar.DATE));
        System.out.println("남은 일 수  : " + cal1.get(Calendar.DATE));
		
        lastcount = cal1.get(Calendar.DATE);
        
        if(lastcount == 30) {
        	lastcount = -1;
        }
        
		return lastcount;
	}
	
	public static HashMap<String, Integer> getSubscribes(List<WriterDto> getNamesAndDates) {
		
		//리턴 값 선언 : 형식 (aname : adate , bname : bdate);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0;  i <getNamesAndDates.size(); i++) {
			
			//남은 구독일 수 계산 함수
			int lastcount = UtilEx.Onelastcount(getNamesAndDates.get(i).getEndDate());
			
			map.put(getNamesAndDates.get(i).getWriterName(), lastcount);
			
		}
		
		System.out.println("사용자의 구독 리스트 : " + map.toString());
		return map;
		
	}
	
	public static String saveFile(MultipartFile file,String path) {
		
		UUID uuid = UUID.randomUUID();
	    String saveName = uuid + "-" + file.getOriginalFilename();
	    
	    //절대 경로
	    //String UPLOAD_PATH = "C:\\Users\\bxoo\\Desktop\\bit-final-project\\paperHouse\\src\\main\\resources\\static\\upload";
	   
	    System.out.println("업로드패쓰 : " + path);
	    
	    //UPLOAD_PATH
	    File saveFile = new File(path + saveName);
	    
	    
	    try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return saveName;
	}
	
	@SuppressWarnings("resource")
	public static byte[] extractBytes(String imageName) throws IOException {
		
		System.out.println("확인1"+imageName);
		
		File imgPath = new File(imageName);
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		System.out.println("확인2" + imgPath);
		
		fis = new FileInputStream(imgPath);
		System.out.println("fis3 " + fis);
		int len = 0;
		
		byte[] buf = new byte[4096];
		
		while ((len = fis.read(buf)) !=-1) {
			baos.write(buf,0,len);
			//System.out.println("len " + len);
		}
		
		byte[] fileArray = baos.toByteArray();
		
		
		System.out.println("확인3" + fileArray);
		return fileArray;
	}
	
	public static byte[] encodingBase64(byte[] targetBytes) {
		
		Encoder encoder = Base64.getEncoder();
		
		return encoder.encode(targetBytes);
	}
	
	public static String incoding(String target) throws UnsupportedEncodingException{
        
        byte[] targetBytes = target.getBytes("UTF-8");
        
        // Base64 인코딩 ///////////////////////////////////////////////////
        Encoder encoder = Base64.getEncoder();
        
        // Encoder#encode(byte[] src) :: 바이트배열로 반환
        byte[] encodedBytes = encoder.encode(targetBytes);
       // System.out.println( "배열변환" +new String(encodedBytes));
        
        // Encoder#encodeToString(byte[] src) :: 문자열로 반환
        String encodedString = encoder.encodeToString(targetBytes);
        System.out.println(encodedString);
        
        /*
        // Base64 디코딩 ///////////////////////////////////////////////////
        Decoder decoder = Base64.getDecoder();
        
        // Decoder#decode(bytes[] src) 
        byte[] decodedBytes1 = decoder.decode(encodedBytes);
        // Decoder#decode(String src)
        byte[] decodedBytes2 = decoder.decode(encodedString);
        
        // 디코딩한 문자열을 표시
        String decodedString = new String(decodedBytes1, "UTF-8");
        System.out.println(decodedString);
        
        System.out.println(new String(decodedBytes2, "UTF-8"));
       */
        
        return encodedString;
    }	
	
}
