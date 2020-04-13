package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.TimelineDao;
import information.client.api.domain.Timeline;

@Lazy
@Repository
public class TimelineDaoImpl extends BaseDaoImpl<Timeline,String> implements TimelineDao{

}
