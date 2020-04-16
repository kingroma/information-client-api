package information.client.api.sort;

import java.util.Comparator;

import information.client.api.domain.ProgramProduct;

public class ProgramProductSeasonEpisodeSortASC implements Comparator<ProgramProduct>{
	@Override
	public int compare(ProgramProduct o1, ProgramProduct o2) {
		if ( o1 != null && o1.getSeason() != null && o1.getEpisode() != null &&
				o2 != null && o2.getSeason() != null && o2.getEpisode() != null ) {
			int arg1 = 0;
			int arg2 = 0;
			
			try {
				arg1 = Integer.parseInt(o1.getSeason()) * 1000 + Integer.parseInt(o1.getEpisode()) ;
				arg2 = Integer.parseInt(o2.getSeason()) * 1000 + Integer.parseInt(o2.getEpisode()) ;
			} catch (Exception e) { }
			
			if(arg1 == arg2) return 0;
            else if(arg1 > arg2) return 1;
            else return -1;
		}
		return 0;
	}

}
