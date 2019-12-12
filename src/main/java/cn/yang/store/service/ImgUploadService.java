package cn.yang.store.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

import cn.yang.store.common.NumberBuilder;

@Service
@Transactional
public class ImgUploadService {
		
	@Value("${Img.path}")
	private String rootpath;
	
	private NumberBuilder nb;
	/**
	 * 上传单张图片
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String uploadOne(MultipartFile file) throws IllegalStateException, IOException{
		File dir=new File(rootpath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		String fileName=file.getOriginalFilename();
		if(!StringUtil.isEmpty(fileName)){
			String suffix=FilenameUtils.getExtension(fileName);//获取文件后缀名
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String date = df.format(new Date());
			String number = nb.getFixLengthNumberToString(1);
			String newFileName = "store"+date+number+"." + suffix;
			File targetFile = new File(dir,newFileName);
			file.transferTo(targetFile);
			return newFileName;
		}else{
			return null;
		}
	}
	/**
	 * 上传多张图片
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String uploadMore(MultipartFile[] file) throws IllegalStateException, IOException{
		  File dir=new File(rootpath);
		  if(!dir.exists()){ dir.mkdirs(); } 
		  String  imgpath="";
		  for(int i =0;i<file.length;i++) {
			  String  fileName=file[i].getOriginalFilename(); 
			  if(!StringUtil.isEmpty(fileName)){
				  String suffix=FilenameUtils.getExtension(fileName);//获取文件后缀名
				  SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				  String date = df.format(new Date());
				  String newFileName = "store"+date+i+ "a." + suffix;
				  File targetFile = new File(dir,newFileName);
				  file[i].transferTo(targetFile);
				  if(i+1>=file.length)
				  {
					  imgpath+=newFileName;
				  }
				  else {
					  imgpath+=newFileName+",";
				  }
			  }
			  else ;
		  }
		  System.out.println("新添图片路径为为："+imgpath);
		  return imgpath;
	}
	public void deleteImg(String imgPaths) {
		File dir=new File(rootpath);
		String rootpathaa = rootpath;
		if(!dir.exists()){ System.out.println("该文件夹路径不存在了");}
		else {
			String[] delPath = imgPaths.split(",");
			for(int i = 0; i<delPath.length;i++) {
				System.out.println("要删除的图片路径为"+delPath[i]);
				new File(rootpathaa.replace("/", "\\")+"\\"+delPath[i]).delete();
			}
		}
	}
}
