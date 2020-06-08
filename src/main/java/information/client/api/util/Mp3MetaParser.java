package information.client.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.sis.referencing.factory.IdentifiedObjectFinder.Domain;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;

public class Mp3MetaParser {
	
	public static class Mp3MetaDto {
		private String genre ;
		private String creator ; 
		private String album ;
		private String metaAuthor ;
		private String artist ;
		private String dcCreator ;
		private String title ; 
		private String dcTitle ;
		private String author ;
		private Double duration ;
		
		public Mp3MetaDto() {}
		public Mp3MetaDto(Metadata metadata) {
			this.genre = metadata.get("xmpDM:genre");
			this.creator = metadata.get("creator");
			this.album = metadata.get("xmpDM:album");
			this.metaAuthor = metadata.get("meta:author");
			this.artist = metadata.get("xmpDM:artist");
			this.dcCreator = metadata.get("dc:creator");
			this.title = metadata.get("title");
			this.dcTitle = metadata.get("dc:title");
			this.author = metadata.get("Author");
			
			try {
				this.duration = Double.parseDouble(metadata.get("xmpDM:duration"));
			} catch(Exception e) {}
		}
		
		@Override
		public String toString() {
			return DomainUtil.changeObjValueToString(this);
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getAlbum() {
			return album;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		public String getMetaAuthor() {
			return metaAuthor;
		}
		public void setMetaAuthor(String metaAuthor) {
			this.metaAuthor = metaAuthor;
		}
		public String getArtist() {
			return artist;
		}
		public void setArtist(String artist) {
			this.artist = artist;
		}
		public String getDcCreator() {
			return dcCreator;
		}
		public void setDcCreator(String dcCreator) {
			this.dcCreator = dcCreator;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDcTitle() {
			return dcTitle;
		}
		public void setDcTitle(String dcTitle) {
			this.dcTitle = dcTitle;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Double getDuration() {
			return duration;
		}
		public void setDuration(Double duration) {
			this.duration = duration;
		}
		
	}
	
	/**
	xmpDM:genre: Cinematic
	creator: Kevin MacLeod
	xmpDM:album: YouTube Audio Library
	meta:author: Kevin MacLeod
	xmpDM:artist: Kevin MacLeod
	dc:creator: Kevin MacLeod
	title: Impact Moderato
	dc:title: Impact Moderato
	Author: Kevin MacLeod
	xmpDM:duration: 27288.0
	*/
	
	public static Mp3MetaDto getMp3Info(String path) {
		// TODO Auto-generated method stub
		Mp3MetaDto dto = null ; 
		try {
	        InputStream input = new FileInputStream(new File(path));
	        ContentHandler handler = new DefaultHandler();
	        Metadata metadata = new Metadata();
	        Parser parser = new Mp3Parser();
	        ParseContext parseCtx = new ParseContext();
	        parser.parse(input, handler, metadata, parseCtx);
	        input.close();

	        // List all metadata
//	        String[] metadataNames = metadata.names();
//	        
//	        for(String name : metadataNames){
//	        	System.out.println(name + "> " + metadata.get(name));
//	        }
	        
	        dto = new Mp3MetaDto(metadata);
        } catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto ; 
	}
}
