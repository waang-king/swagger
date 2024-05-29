package swagger.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swagger.test.dto.BoardDto;
import swagger.test.dto.MemberDto;
import swagger.test.mapper.BoardMapper;
import swagger.test.mapper.MemberMapper;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto.res> selectBoard(BoardDto.req req) throws Exception {
        return boardMapper.selectBoard(req);
    }

    public void createBoard(BoardDto.req2 req2) throws Exception {
        boardMapper.createBoard(req2);
    }

    public void updateBoard(BoardDto.req2 req2) throws Exception {
        boardMapper.updateBoard(req2);
    }

    public void deleteBoard(BoardDto.req req) throws Exception {
        boardMapper.deleteBoard(req);
    }

}
