package swagger.test.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import swagger.test.dto.BoardDto;
import swagger.test.service.BoardService;

import java.util.List;
import java.util.Map;

@Tag(name = "Board", description = "Board API")
@RestController
public class BoardApi {

    private final BoardService boardService;

    @Autowired
    public BoardApi(BoardService boardService) {
        this.boardService = boardService;
    }

    @Operation(summary = "게시물 조회", description = "RequestParam을 기반으로 보드 목록을 가져옵니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = @Content)
    })
    @GetMapping("/select")
    public List<BoardDto.res> selectBoard(
            @RequestParam @Parameter(description = "게시물 번호") int idx) throws Exception {
        BoardDto.req req = BoardDto.req.builder().idx(idx).build();
        return boardService.selectBoard(req);
    }

    @Operation(summary = "게시글 작성", description = "게시물 작성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<String> createBoard(
            @RequestBody @Parameter(description = "게시물 작성 request") BoardDto.req2 req2) throws Exception {
        boardService.createBoard(req2);
        return ResponseEntity.ok("게시물 작성 성공");
    }

    @Operation(summary = "게시글 수정", description = "게시물 수정 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = @Content)
    })
    @PutMapping("/update")
    public ResponseEntity<String> updateBoard(
            @RequestBody @Parameter(description = "게시물 수정 request") BoardDto.req2 req2) throws Exception {
        boardService.updateBoard(req2);
        return ResponseEntity.ok("게시물 수정 성공");
    }

    @Operation(summary = "게시물 삭제", description = "게시물 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = @Content)
    })
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBoard(
            @RequestParam @Parameter(description = "Board index") int idx) throws Exception {
        BoardDto.req req = BoardDto.req.builder().idx(idx).build();
        boardService.deleteBoard(req);
        return ResponseEntity.ok("게시물 삭제 성공");
    }

    @Operation(summary = "파일 업로드", description = "파일 업로드 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "404", description = "idx를 찾을 수 없음", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "304", description = "파일을 업데이트 할 수 없음", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    })
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("idx") @Parameter(description = "게시물 id") Integer idx,
//            @RequestParam("file") @Paramete
//            r(description = "파일") MultipartFile file
            @RequestParam("file") @Parameter(
                    description = "multipart/form-data 형식의 이미지 리스트를 input으로 받습니다. 이때 key 값은 multipartFile 입니다.",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
            )MultipartFile file
    ) throws Exception {

        // Check if petId is provided
        if (idx == null) {
            return ResponseEntity.badRequest().body("No idx provided. Try again?");
        }

        // Check if file is provided
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }

        // Save the file to the server (simplified example)
        String filePath = "/path/to/save/" + file.getOriginalFilename();
        file.transferTo(new java.io.File(filePath));

        return ResponseEntity.ok("File uploaded successfully. Pet updated.");
    }

    @Operation(summary = "Submit Map", description = "Accepts a map of data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "파라미터 오류", content = @Content)
    })
    @PostMapping("/submit-map")
    public ResponseEntity<String> submitMap(
            @RequestBody @Parameter(description = "Map data to submit") Map<String, Object> data) throws Exception {
        // Map 데이터 처리 로직
        return ResponseEntity.ok("Map data submitted successfully");
    }
}
