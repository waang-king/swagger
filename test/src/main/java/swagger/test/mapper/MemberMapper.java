package swagger.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import swagger.test.dto.MemberDto;

@Mapper
public interface MemberMapper {
    MemberDto.res selectMember(MemberDto.req member);
}
