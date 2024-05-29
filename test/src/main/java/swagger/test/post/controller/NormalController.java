package swagger.test.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "NormalController", description = "Controller")
@Controller
public class NormalController {

    @Operation(summary = "Hello Method", description = "Returns a hello message") // todo Controller에서는 Operation이 있어야 ui에서 볼 수 있음
    @GetMapping("/hello.cm")
    public String hello() {
        return "hello";
    }
}
