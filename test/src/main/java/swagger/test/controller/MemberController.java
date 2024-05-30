package swagger.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import swagger.test.dto.MemberDto;
import swagger.test.service.MemberService;

@Tag(name = "Login", description = "Login session 확인을 위한 로직")
@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "Login", description = "Login 관련 로직") // todo Controller에서는 Operation이 있어야 ui에서 볼 수 있음
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "401", description = "Invalid credentials", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    })
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDto.req req, HttpSession session) throws Exception {
        MemberDto.res member = memberService.selectMember(req);
        if (member != null) {
            // 로그인 성공 시 세션에 사용자 정보 저장
            session.setAttribute("loginUser", member);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @Operation(summary = "세션에 저장된 정보", description = "로그인된 사용자 정보를 반환")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MemberDto.res.class))}),
            @ApiResponse(responseCode = "401", description = "Not logged in", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    })
    @GetMapping("/session/user")
    public ResponseEntity<?> getLoggedInUser(HttpSession session) {
        MemberDto.res loginUser = (MemberDto.res) session.getAttribute("loginUser");
        if (loginUser != null) {
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body("Not logged in");
        }
    }

    @Operation(summary = "Logout", description = "Logout 관련 로직") // todo Controller에서는 Operation이 있어야 ui에서 볼 수 있음
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logout successful", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))})
    })
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // 세션에서 사용자 정보 제거
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }
}
