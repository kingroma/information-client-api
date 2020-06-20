package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.GenreDao;
import information.client.api.dao.ImageMetaDao;
import information.client.api.dao.ProgramDao;
import information.client.api.dao.ProgramGenreDao;
import information.client.api.dao.ProgramProductDao;
import information.client.api.domain.Genre;
import information.client.api.domain.ImageMeta;
import information.client.api.domain.Program;
import information.client.api.domain.ProgramGenre;
import information.client.api.domain.ProgramGenrePK;
import information.client.api.domain.ProgramProduct;
import information.client.api.domain.ProgramProductPK;
import information.client.api.form.ProgramUiForm;
import information.client.api.service.ProgramUiService;
import information.client.api.util.DomainUtil;

@Service
public class ProgramUiServiceImpl implements ProgramUiService {
	
	@Resource
	private ProgramDao programDao ;
	
	@Resource
	private ProgramProductDao programProductDao ; 
	
	@Resource
	private ProgramGenreDao programGenreDao ;
	
	@Resource
	private ImageMetaDao imageMetaDao ; 
	
	@Resource
	private GenreDao genreDao ;

	@Override
	@Transactional
	public boolean save(ProgramUiForm form) {
		Program program = new Program();
		
		String programId = form.getProgramId();
		String title = form.getTitle();
		String programType = form.getProgramType();
		String synopsis = form.getSynopsis();
		String useAt = form.getUseAt();
		List<String> genres = form.getGenres();
		List<String> imageIdList = form.getImageId();
		List<String> imageTypeList = form.getImageType();

		if ( programId == null || programId.isEmpty() || "null".equalsIgnoreCase(programId) ) {
			programId = DomainUtil.getUUID(20);
			program.setRegistDate(DomainUtil.nowTimestamp());
		}
		
		if(useAt == null || useAt.isEmpty() || "null".equalsIgnoreCase(useAt)) {
			useAt = "Y";
		}
		
		List<ProgramGenre> programGenreList = programGenreDao.find(Filter.equal("id.programId", programId));
		for ( ProgramGenre pg : programGenreList ) {
			programGenreDao.remove(pg);
		}
		
		if ( genres != null ) {
			for ( String g : genres ) {
				List<Genre> genreList = genreDao.find(Filter.equal("genreName", g));
				
				for ( Genre genre : genreList ) {
					ProgramGenre pg = new ProgramGenre();
					ProgramGenrePK pgp = new ProgramGenrePK();
					pgp.setGenreId(genre.getGenreId());
					pgp.setProgramId(programId);
					pg.setRegistDate(DomainUtil.nowTimestamp());
					pg.setUpdateDate(DomainUtil.nowTimestamp());
					pg.setId(pgp);
					
					programGenreDao.save(pg);
				}
			}
		}
		
		program.setProgramId(programId);
		program.setTitle(title);
		program.setProgramType(programType);
		program.setSynopsis(synopsis);
		program.setUpdateDate(DomainUtil.nowTimestamp());
		program.setUseAt(useAt);
		program.setWatchCount(0);

		programDao.save(program);
		
		List<ImageMeta> imageMetaList = imageMetaDao.find(
				Filter.equal("mappingId", programId ),
				Filter.equal("imageType", programType)
				);
		
		for( ImageMeta im : imageMetaList ) {
			imageMetaDao.remove(im);
		}
		
		if (imageIdList != null ) {
			for( int i = 0 ; i < imageIdList.size() ; i ++ ) {
				ImageMeta im = new ImageMeta();
				
				String imageId = imageIdList.get(i);
				String imageType = imageTypeList.get(i);
				if ( imageId == null || imageId.isEmpty() || "null".equalsIgnoreCase(imageId) ) { 
					imageId = DomainUtil.getUUID(20);
					imageIdList.set(i, imageId);
					im.setRegistDate(DomainUtil.nowTimestamp());
				}			
				
				
				im.setImageId(imageId);
				im.setImageType(imageType);
				im.setMappingId(programId);
				im.setUpdateDate(DomainUtil.nowTimestamp());
				
				imageMetaDao.save(im);
			}
		}
		
		List<String> productId = form.getProductId();
		List<String> season = form.getSeason();
		List<String> episode = form.getEpisode();
		List<String> programProductUseAt = form.getProgramProductUseAt();
		List<String> programProductTitle = form.getProgramProductTitle() ; 
		List<String> programProductText = form.getProgramProductText();
		
		
		
		
		List<ProgramProduct> ppList = programProductDao.find(Filter.equal("id.programId", programId));
		for( ProgramProduct removePp : ppList ) {
			programProductDao.remove(removePp);
		}
		
		if ( productId != null ) { 
			for ( int i = 0 ; i < productId.size() ; i ++ ) {
				ProgramProduct pp = new ProgramProduct();
				ProgramProductPK ppp = new ProgramProductPK();
				String pId = productId.get(i);
				String s = ( season.get(i) == null || season.get(i).isEmpty() || "null".equalsIgnoreCase(season.get(i)) ? null : season.get(i)) ;
				String e = ( episode.get(i) == null || episode.get(i).isEmpty() || "null".equalsIgnoreCase(episode.get(i)) ? null : episode.get(i)) ;
				String ppUseAt = ( programProductUseAt.get(i) == null || programProductUseAt.get(i).isEmpty() || "null".equalsIgnoreCase(programProductUseAt.get(i)) ? "Y" : programProductUseAt.get(i)) ;
				String ppTitle = programProductTitle.get(i);
				String ppText = programProductText.get(i);
				
				boolean canInsertImage = true ; 
				if ( pId == null || pId.isEmpty() || "null".equalsIgnoreCase(pId)) {
					pId = DomainUtil.getUUID(20);
					pp.setRegistDate(DomainUtil.nowTimestamp());
					canInsertImage = false; 
				}

				ppp.setProductId(pId);
				ppp.setProgramId(programId);
				pp.setId(ppp);
				
				pp.setSeason(s);
				pp.setEpisode(e);
				pp.setTitle(ppTitle);
				pp.setText(ppText);
				pp.setUseAt(ppUseAt);
				pp.setUpdateDate(DomainUtil.nowTimestamp());
				
				programProductDao.save(pp);
				
				List<String> programProductImageProductId = form.getProgramProductImageProductId();
				List<String> programProductImageId = form.getProgramProductImageId();
				List<String> programProductImageType = form.getProgramProductImageType();
				
				List<ImageMeta> removeImageMeta = imageMetaDao.find(Filter.equal("mappingId", pId));
				for( ImageMeta im : removeImageMeta ) {
					imageMetaDao.remove(im);
				}
				
				
				if (programProductImageId != null && canInsertImage) {
					for( int j = 0 ; j < programProductImageId.size() ; j ++ ) {
						ImageMeta im = new ImageMeta();
						
						String imageProductId = programProductImageProductId.get(j);
						String imageId = programProductImageId.get(j);
						String imageType = programProductImageType.get(j);
						if ( imageId == null || imageId.isEmpty() || "null".equalsIgnoreCase(imageId) ) { 
							imageId = DomainUtil.getUUID(20);
							programProductImageId.set(j, imageId);
							im.setRegistDate(DomainUtil.nowTimestamp());
						}			
						
						im.setImageId(imageId);
						im.setImageType(imageType);
						im.setMappingId(imageProductId);
						im.setUpdateDate(DomainUtil.nowTimestamp());
						
						if ( imageProductId.equals(pId)) {
							imageMetaDao.save(im);
						}
						
					}
				}
			}
		}
		// programProductDao
		
		return true;
	}
}
