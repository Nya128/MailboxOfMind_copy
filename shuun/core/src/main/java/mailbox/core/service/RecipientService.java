package mailbox.core.service;

import lombok.RequiredArgsConstructor;
import mailbox.core.dto.request.RecipientSaveRequestDto;
import mailbox.core.dto.response.RecipientSaveResponseDto;
import mailbox.core.repository.RecipientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RecipientService {
    private final RecipientRepository recipientRepository;

    @Transactional
    public RecipientSaveResponseDto save(RecipientSaveRequestDto requestDto){
        // 수신인이 이미 등록되어 있는지 확인
        Long recipientIdx;
        if(this.checkRecipientExist(requestDto.getRecipientName())) { // 이미 등록돼 있으면
            recipientIdx = this.findByRecipientName(requestDto.getRecipientName());
        }
        else { // 등록 안 되어 있으면
            recipientIdx = recipientRepository.save(requestDto.toEntity()).getRecipientIdx();
        }

        return new RecipientSaveResponseDto(recipientIdx);
    }

    private Boolean checkRecipientExist(String recipientName) {
        return recipientRepository.existsRecipientByRecipientName(recipientName);
    }


    //    public LettersResponseDto findById(Long letterIdx){
//        Letter entity = recipientRepository.findById(letterIdx).orElseThrow(() ->
//                new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. id = " + letterIdx));
//
//        return new LettersResponseDto(entity);
//
//    }
//
    public Long findByRecipientName(String recipientName){
        return recipientRepository.findByRecipientName(recipientName).getRecipientIdx();
    }


}
