package mailbox.core.service;

import lombok.RequiredArgsConstructor;
import mailbox.core.domain.Letter;
import mailbox.core.dto.request.LettersCreateRequestDto;
import mailbox.core.dto.request.LettersUpdateRequestDto;
import mailbox.core.dto.request.LettersSaveSecondRequestDto;
import mailbox.core.dto.response.LettersListResponseDto;
import mailbox.core.dto.response.LettersResponseDto;
import mailbox.core.dto.response.LettersSaveResponseDto;
import mailbox.core.repository.LettersRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LetterService {
    private final LettersRepository lettersRepository;

    @Transactional
    public LettersSaveResponseDto save(LettersCreateRequestDto requestDto){
        Long letterIdx = lettersRepository.save(requestDto.toEntity()).getLetterIdx();
        return new LettersSaveResponseDto(letterIdx);
    }

    @Transactional
    public Long update(Long letterIdx, LettersUpdateRequestDto requestDto){
        Letter letters = lettersRepository.findById(letterIdx).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + letterIdx));

        return letterIdx;
    }

    public LettersResponseDto findById(Long letterIdx){
        Letter entity = lettersRepository.findById(letterIdx).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + letterIdx));

        return new LettersResponseDto(entity);

    }

    @Transactional
    public List<LettersListResponseDto> findAllDesc(){
        return lettersRepository.findAllDesc().stream()
                .map(LettersListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public void delete(Long letterIdx){
        Letter letters = lettersRepository.findById(letterIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다 id: " + letterIdx));

        lettersRepository.delete(letters);
    }




}
