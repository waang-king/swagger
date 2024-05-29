package swagger.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swagger.test.dto.MemberDto;
import swagger.test.mapper.MemberMapper;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberDto.res selectMember(MemberDto.req req) throws Exception {
        return memberMapper.selectMember(req);
    }
}
