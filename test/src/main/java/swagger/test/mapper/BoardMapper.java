package swagger.test.mapper;


import org.apache.ibatis.annotations.Mapper;
import swagger.test.dto.BoardDto;
import swagger.test.dto.MemberDto;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto.res> selectBoard(BoardDto.req req);

    void createBoard(BoardDto.req2 req2);

    void updateBoard(BoardDto.req2 req2);

    void deleteBoard(BoardDto.req req);

}
