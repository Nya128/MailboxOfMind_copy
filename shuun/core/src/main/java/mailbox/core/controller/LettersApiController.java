package mailbox.core.controller;

import lombok.RequiredArgsConstructor;
import mailbox.core.config.BaseResponse;
import mailbox.core.dto.request.*;
import mailbox.core.dto.response.LettersListResponseDto;
import mailbox.core.dto.response.LettersResponseDto;
import mailbox.core.dto.response.LettersSaveResponseDto;
import mailbox.core.dto.response.RecipientSaveResponseDto;
import mailbox.core.service.LetterService;
import mailbox.core.service.RecipientService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class LettersApiController {

    private final LetterService letterService;
    private final RecipientService recipientService;


    // saveFirst()에서 받은 수신인 이름, 발신인 이름 임시 저장
    private String recipientName, sender;

    // Getter & Setter
    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }




    // 편지 리스트 조회
    @ResponseBody
    @GetMapping("/letters")
    public BaseResponse<List<LettersListResponseDto>> getLettersList(){
        List<LettersListResponseDto> letters = letterService.findAllDesc();
        return new BaseResponse<>(letters);
    }

    // 편지 수신인, 발신인 이름 임시 저장
    @PostMapping("/letters/first")
    public String saveFirst(@RequestBody LettersSaveFirstRequestDto requestDto){

        this.setRecipientName(requestDto.getRecipientName());
        this.setSender(requestDto.getSender());

        String result = "발신인: " + this.sender + ", 수신인: " + this.recipientName;
        return result;
    }

    // 편지 생성
    @PostMapping("/letters")
    public BaseResponse<LettersSaveResponseDto> createLetter(@RequestBody LettersSaveSecondRequestDto requestDto){
        // validation 처리: // 제목/내용 길이 45/1000자 넘지 않는지 확인


        // Recipient(수신인) 저장
         // userIdx 어떻게 가져와야 하나요?
//        RecipientSaveRequestDto recipientSaveRequestDto = new RecipientSaveRequestDto(this.getRecipientName(), userIdx);
        RecipientSaveRequestDto recipientSaveRequestDto = new RecipientSaveRequestDto(this.getRecipientName(), 1L);
        RecipientSaveResponseDto recipientSaveResponseDto = this.recipientService.save(recipientSaveRequestDto);

        // Letter(편지) 저장
        // 선물도 저장해야 함
        LettersCreateRequestDto lettersCreateRequestDto = new LettersCreateRequestDto(
                1L, requestDto.getTitle(), requestDto.getContent(), recipientSaveResponseDto.getRecipientIdx(), getSender(),
                requestDto.getDestinationIdx(), requestDto.getPresentStatus(), requestDto.getPublicSetting(), "ACTIVE");
        LettersSaveResponseDto lettersSaveResponseDto = this.letterService.save(lettersCreateRequestDto);

        return new BaseResponse<>(lettersSaveResponseDto);
    }

    @PatchMapping("/letters/{letterIdx}")
    public Long update(@PathVariable Long letterIdx,
                       @RequestBody LettersUpdateRequestDto requestDto){
        return letterService.update(letterIdx, requestDto);
    }

    @GetMapping("/letters/{letterIdx}")
    public LettersResponseDto getLetter (@PathVariable Long letterIdx){
        return letterService.findById(letterIdx);
    }

    @DeleteMapping("/letters/{letterIdx}")
    public Long delete(@PathVariable Long letterIdx){
        letterService.delete(letterIdx);
        return letterIdx;
    }

}
