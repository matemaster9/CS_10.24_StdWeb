package cs.matemaster.mapstruct;

import cs.matemaster.model.dto.ActivityDataFunnel;
import cs.matemaster.model.dto.ActivityDataFunnelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author matemaster
 */
@Mapper
public interface IActivityDataFunnelMapper {

    IActivityDataFunnelMapper Instance = Mappers.getMapper(IActivityDataFunnelMapper.class);

    ActivityDataFunnelVO toActivityDataFunnelVO(ActivityDataFunnel activityDataFunnel);
}
