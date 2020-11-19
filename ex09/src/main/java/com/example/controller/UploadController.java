package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	//Path 지정
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping("formUpload")
	public void formUpload(){	
	}
	
	@RequestMapping("ajaxUpload")
	public void ajaxUpload(){
	}
	// submit 시 파일 업로드
	@RequestMapping(value="formUpload", method=RequestMethod.POST)
	public void uplodatFormPost(MultipartFile file) throws Exception{
		System.out.println("upload................");
		System.out.println("path..........."+path);
		//uid를 통하여 랜덤으로 긴 파일명을 받고 마지막에 file.getOriginalFilename으로 실제 파일명 만듬
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString()+"_"+file.getOriginalFilename();
		System.out.println("파일명:"+savedName);
		
		//파일 업로드
		File target =new File(path,savedName);
		FileCopyUtils.copy(file.getBytes(), target);
	}
	
	// 파일 업로드
	@ResponseBody
	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String ajaxUpload(MultipartFile file) throws Exception {
		// uid를 통하여 랜덤으로 긴 파일명을 받고 마지막에 file.getOriginalFilename으로 실제 파일명 만듬
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + file.getOriginalFilename();
		System.out.println("파일명:" + savedName);

		// 파일 업로드
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		return savedName;
	}
	
	// 파일 삭제
	@ResponseBody
	@RequestMapping(value="deleteFile" ,method= RequestMethod.POST)
	public void ajaxDelete(String fileName){
		new File(path+"/"+fileName).delete();
	}
	
	//이미지파일 보기
	@ResponseBody
	@RequestMapping("displayFile")
	public byte[] displayFile(String fileName)throws Exception{
		System.out.println(fileName);
		FileInputStream in=new FileInputStream(path+"/"+fileName);
		byte[] image=IOUtils.toByteArray(in);
		in.close();
		return image;
	}
}
