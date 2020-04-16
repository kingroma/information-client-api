package information.client.api.sort;

import java.util.Comparator;

import information.client.api.domain.ContentProgram;

public class ContentProgramSortASC implements Comparator<ContentProgram> {
	@Override
	public int compare(ContentProgram o1, ContentProgram o2) {
		if ( o1 != null && o2 != null ) {
			int arg1 = o1.getSortSn();
			int arg2 = o2.getSortSn();
			
			if(arg1 == arg2) return 0;
            else if(arg1 > arg2) return 1;
            else return -1;
		}
		return 0;
	}
}
