package com.example.demo3.controller;

import com.example.demo3.Service.MemoService;
import com.example.demo3.domain.Memo;
import com.example.demo3.domain.MemoRepository;
import com.example.demo3.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
//CRUD에서 CRD는 Repo가 필요하고, U는 Service가 필요할거다
    //그거 먼저 선언해주기~!
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) { //폼에서 보내는 데이터를 받기위한 어노테이션 @RequestBody
        Memo memo = new Memo(requestDto); // DTO -> ENTITY
        return memoRepository.save(memo); // ENTITY를 DB에 저장
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.updateMemo(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}
