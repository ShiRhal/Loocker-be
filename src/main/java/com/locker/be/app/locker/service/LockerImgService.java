package com.locker.be.app.locker.service;

import com.locker.be.app.locker.dto.LockerImgDto;
import com.locker.be.app.locker.dto.LockerImgQueryDto;
import com.locker.be.app.locker.mapper.LockerImgMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LockerImgService {

    @Value("${file.upload.locker-path}")
    private String lockerUploadPath;
    private final LockerImgMapper lockerImgMapper;

    public void create(LockerImgDto.LockerImgCreateReq dto) {
        MultipartFile imageFile = dto.getIMAGE_FILE();
        String savedFileName = UUID.randomUUID() + getExtension(imageFile.getOriginalFilename());
        Path uploadDir = Paths.get(
                lockerUploadPath,
                String.valueOf(dto.getTRADE_ID()),
                String.valueOf(dto.getLOCKER_ID())
        );
        Path savedPath = uploadDir.resolve(savedFileName);
        String imageUrl = "/uploads/trade-locker/"
                + dto.getTRADE_ID()
                + "/"
                + dto.getLOCKER_ID()
                + "/"
                + savedFileName;
        try {
            Files.createDirectories(uploadDir); // 1. 폴더 생성
            imageFile.transferTo(savedPath.toFile()); // 2. 실제 이미지 파일 저장
            LockerImgDto.LockerImgCreateParam param = new LockerImgDto.LockerImgCreateParam(); // 3. SP 호출용 파라미터 세팅
            param.setTRADE_ID(dto.getTRADE_ID());
            param.setLOCKER_ID(dto.getLOCKER_ID());
            param.setIMAGE_TYPE_CODE(dto.getIMAGE_TYPE_CODE());
            param.setIMAGE_URL(imageUrl);
            lockerImgMapper.create(param); // 4. DB 저장: SP_LOCKER_IMAGE_INSERT 호출

        } catch (Exception e) {
            try {
                Files.deleteIfExists(savedPath); // SP 실패 또는 파일 저장 실패 시 실제 파일 삭제
            } catch (Exception ignored) {}
            throw new RuntimeException("보관함 이미지 저장 실패", e);
        }
    }

    private String getExtension(String originalFilename) {
        if (originalFilename == null || !originalFilename.contains(".")) {
            return ".jpg";
        }
        return originalFilename.substring(originalFilename.lastIndexOf("."));
    }

    // @Transactional(readOnly = true)
    public Collection<LockerImgQueryDto.LockerImgRes> findImg(LockerImgQueryDto.LockerImgReq dto) {

        return lockerImgMapper.findImg(dto);
    }
}
