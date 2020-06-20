package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.ContentDao;
import information.client.api.dao.ContentProgramDao;
import information.client.api.dao.ImageMetaDao;
import information.client.api.domain.Content;
import information.client.api.domain.ContentProgram;
import information.client.api.domain.ContentProgramPK;
import information.client.api.domain.ImageMeta;
import information.client.api.form.ContentUiForm;
import information.client.api.service.ContentUiService;
import information.client.api.util.DomainUtil;

@Service
public class ContentUiServiceImpl implements ContentUiService {

	@Resource
	ContentDao contentDao ; 
	
	@Resource
	ContentProgramDao contentProgramDao ; 
	
	@Resource
	ImageMetaDao imageMetaDao ; 
	
	@Override
	@Transactional
	public boolean save(ContentUiForm form) {
		Content content = new Content();
		
		String contentId = form.getContentId();
		String contentName = form.getContentName();
		String contentType = form.getContentType();
		String sortSn = form.getSortSn();
		String useAt = form.getUseAt();

		List<String> programId = form.getProgramId();
		List<String> imageId = form.getImageId();
		List<String> imageType = form.getImageType();
		
		if ( contentId == null || contentId.isEmpty() || "null".equalsIgnoreCase(contentId) ) {
			contentId = DomainUtil.getUUID(20);
			content.setRegistDate(DomainUtil.nowTimestamp());
		}
		
		if(useAt == null || useAt.isEmpty() || "null".equalsIgnoreCase(useAt)) {
			useAt = "Y";
		}
		
		List<Content> contentList = contentDao.find(Filter.equal("contentId", contentId));
		for ( Content c : contentList ) { 
			contentDao.remove(c);
		}
		
		content.setContentId(contentId);
		content.setContentName(contentName);
		content.setContentType(contentType);
		content.setUpdateDate(DomainUtil.nowTimestamp());
		content.setSortSn(Integer.parseInt(sortSn));
		content.setUseAt(useAt);

		contentDao.save(content);
		
		List<ContentProgram> listContentProgram = contentProgramDao.find(Filter.equal("id.contentId", contentId));
		for ( ContentProgram cp : listContentProgram ) {
			contentProgramDao.remove(cp);
		}
		
		
		
		if ( programId != null && imageId != null && imageType != null ) {
			for ( int i = 0 ; i < programId.size() ; i ++ ) {
				String pId = programId.get(i);
				
				ContentProgram cp = new ContentProgram();
				ContentProgramPK pk = new ContentProgramPK();
				pk.setContentId(contentId);
				pk.setProgramId(pId);
				cp.setId(pk);
				cp.setRegistDate(DomainUtil.nowTimestamp());
				cp.setSortSn(null);
				cp.setUpdateDate(DomainUtil.nowTimestamp());
				
				contentProgramDao.save(cp);
				
				ImageMeta im = new ImageMeta();
				String imgId = imageId.get(i);
				String cType = imageType.get(i);
				
				List<ImageMeta> listImageMeta = imageMetaDao.find(
						Filter.equal("mappingId", programId),
						Filter.equal("subId", contentId),
						Filter.equal("imageType", cType));
				
				for ( ImageMeta removeIm : listImageMeta) {
					imageMetaDao.remove(removeIm);
				}
				
				if ( imgId == null || imgId.isEmpty() || "null".equalsIgnoreCase(imgId) ) {
					imgId = DomainUtil.getUUID(20);
					im.setRegistDate(DomainUtil.nowTimestamp());
				}
				
				im.setImageId(imgId);
				im.setMappingId(pId);
				im.setSubId(contentId);
				im.setImageType(cType);
				im.setUpdateDate(DomainUtil.nowTimestamp());
				
				imageMetaDao.save(im);
			}
		}
		
		return true ; 
	}
}
