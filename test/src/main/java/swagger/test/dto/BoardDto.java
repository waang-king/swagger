package swagger.test.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class BoardDto {

    @Schema(description = "게시물의 고유 ID", example = "1")
    private int idx;

    @Schema(description = "게시물 제목", example = "Sample Title")
    private String title;

    @Schema(description = "게시물 내용", example = "This is a sample content.")
    private String contents;

    @Schema(description = "게시물 이미지 URL", example = "http://example.com/image.jpg")
    private String image;

    @Schema(description = "삭제 여부", example = "N")
    private String delYn;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class req {

        @Schema(description = "게시물의 고유 ID", example = "1")
        private int idx;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class req2 {

        @Schema(description = "게시물 제목", example = "Sample Title")
        private String title;

        @Schema(description = "게시물 내용", example = "This is a sample content.")
        private String contents;

        @Schema(description = "게시물 이미지 URL", example = "http://example.com/image.jpg")
        private String image;

        @Schema(description = "삭제 여부", example = "N")
        private String delYn;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class res {

        @Schema(description = "게시물 제목", example = "Sample Title")
        private String title;

        @Schema(description = "게시물 내용", example = "This is a sample content.")
        private String contents;

        @Schema(description = "게시물 이미지 URL", example = "http://example.com/image.jpg")
        private String image;

        @Schema(description = "삭제 여부", example = "N")
        private String delYn;
    }
}
