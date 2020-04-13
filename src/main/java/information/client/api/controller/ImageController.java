package information.client.api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/image")
@Controller
public class ImageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	private final String defalutImage = "default.png" ;
	
	private final String[] imgExtension = {
			".png" , ".jpg" , ".jpeg"
	};
	
	@Resource(name = "configSource")
	protected MessageSource configSource;
	
	public ImageController(){
	}
	
	@RequestMapping(value = "/get/{IMAGE_ID}", method = RequestMethod.GET , produces = "image/png" )
	public void getImage( HttpServletResponse response ,@PathVariable("IMAGE_ID") String imageId ) {
		logger.info("Image ID = {}" , imageId);
		
		String imageStorage = getMessage("image.storage");
		
		ServletOutputStream sos = null ; 
		FileInputStream fis = null;
		
		File file = null;
		
		for ( String e : imgExtension ){
			file = new File(imageStorage + imageId + e);
			
			if ( file.exists() ){
				switch(e){
				case ".png":
					response.setContentType("image/png");
					break;
				case ".jpg":
					response.setContentType("image/jpeg");
					break;
				case ".jpeg":
					response.setContentType("image/jpeg");
					break;
				}
				break;
			}
			else 
				file = null ;
		}
		
		try {
			if ( file == null ){
				file = new File ( imageStorage + defalutImage );
				response.setContentType("image/jpeg");
			}
			
			sos = response.getOutputStream();
			
			fis = new FileInputStream(file);
			int length ; 
			
			byte[] buffer = new byte[128];
			while ( (length = fis.read(buffer)) != -1 ){
				sos.write(buffer,0,length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if ( sos != null ) 
					sos.close();
				if ( fis != null )
					fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	protected String getMessage(String key) {
		String message = null ; 
		if ( key != null && !key.isEmpty() ) {
			try {
				message = configSource.getMessage(key, null, Locale.getDefault());
			} catch (Exception e) {}
			
		}
		return message ; 
	}
	
}
