package com.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @GetMapping("/boards")
    public String getBoards() {
        /**
         * todo 전체 게시물을 가져온다.
         */
        return "/boards";
    }

    @GetMapping("/boards/{id}")
    public String getBoardsDetail(@PathVariable Long id) {
        /**
         * todo 해당 id의 게시물을 가져온다.
         */
        return "/item";
    }
}
