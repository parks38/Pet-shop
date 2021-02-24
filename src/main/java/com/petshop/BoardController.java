package com.petshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/boards")
    public String getBoards() {
        /**
         * todo 전체 게시물을 가져온다.
         */
        return "/boards";
    }
}
