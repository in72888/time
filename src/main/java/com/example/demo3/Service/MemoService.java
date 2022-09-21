package com.example.demo3.Service;

import com.example.demo3.domain.Memo;
import com.example.demo3.domain.MemoRepository;
import com.example.demo3.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    //만약 final을 쓰지 않는다면 MemoService를 이용할때
    //얘가 MemoService인지 아닌지 그 memoRepository를 스프링이 적절히 넣어주지 못함
    private final MemoRepository memoRepository;

    @Transactional  // 실질적인 업데이트는 여기서 일어남
    public Long updateMemo(Long id, MemoRequestDto requestDto) { // 파라미터 재료: 어떤걸바꿀꺼니?id 뭘로바꿀꺼니?requestDto
        
        //1. 바꿀거 찾기
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        //2. 바꾸기
        memo.update(requestDto);
        return memo.getId(); //어떤 녀석이 업뎃된건지 반환해주기
    }
}
