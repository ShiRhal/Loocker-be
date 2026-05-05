package com.locker.be.web.product.service;

import com.locker.be.web.product.dto.ProductImageDto;
import com.locker.be.web.product.dto.ProductImageQueryDto;
import com.locker.be.web.product.mapper.ProductImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductImageService {

    private final ProductImageMapper productImageMapper;

    @Value("${file.upload.product-path}")
    private String uploadPath;

    public Collection<ProductImageQueryDto.ProductImageRes> findAll(ProductImageQueryDto.ProductImageReq dto) {
        return productImageMapper.findAll(dto);
    }

    public void saveImages(ProductImageDto.ProductImageCreateReq dto) {
        if (dto.getFiles() == null || dto.getFiles().length == 0) {
            return;
        }

        if (dto.getFiles().length > 10) {
            throw new IllegalArgumentException("이미지는 최대 10개까지 등록 가능합니다.");
        }

        File dir = new File(uploadPath, String.valueOf(dto.getPRODUCT_ID()));
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int sortOrder = 1;

        for (MultipartFile file : dto.getFiles()) {
            if (file == null || file.isEmpty()) {
                continue;
            }

            String originalFilename = file.getOriginalFilename();
            String extension = getExtension(originalFilename);
            String savedFileName = UUID.randomUUID() + extension;

            File dest = new File(dir, savedFileName);

            try {
                file.transferTo(dest);
            } catch (IOException | IllegalStateException e) {
                throw new RuntimeException(
                    "이미지 저장 실패"
                        + "\noriginalFilename = " + originalFilename
                        + "\nsavedFileName = " + savedFileName
                        + "\ndest = " + dest.getAbsolutePath()
                        + "\nuploadPath = " + uploadPath
                        + "\nmessage = " + e.getMessage(),
                    e
                );
            }

            String imageUrl = "/uploads/product/" + dto.getPRODUCT_ID() + "/" + savedFileName;

            ProductImageDto.ProductImageCreateReq saveDto = new ProductImageDto.ProductImageCreateReq();
            saveDto.setPRODUCT_ID(dto.getPRODUCT_ID());
            saveDto.setIMAGE_URL(imageUrl);
            saveDto.setSORT_ORDER((long) sortOrder);
            saveDto.setIS_PRIMARY(sortOrder == 1);
            saveDto.setIS_ACTIVE(true);

            productImageMapper.create(saveDto);
            sortOrder++;
        }
    }

    private String getExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }
    // 대표 이미지 제외 이미지 삭제
    public void deleteForUpdate(ProductImageDto.ProductImageDeleteReq deleteDto, ProductImageQueryDto.ProductPriImageReq priDto) {
        Long productId = deleteDto.getPRODUCT_ID();

        // DB에서 대표 이미지 URL 또는 파일명 조회
        String mainImageUrl = productImageMapper.findPri(priDto);
        String mainFileName = extractFileName(mainImageUrl);

        File dir = new File(uploadPath, String.valueOf(productId));
        deleteFilesExceptMain(dir, mainFileName);

        // DB에서도 대표이미지 제외하고 삭제
        // mapper 연결 주석 처리 -> 게시글 수정 쿼리 안에서 sp 호출
        // productImageMapper.deleteForUpdate(deleteDto);
    }
    // 대표 이미지 추출
    private String extractFileName(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank()) {
            return null;
        }
        int idx = imageUrl.lastIndexOf("/");
        return (idx >= 0) ? imageUrl.substring(idx + 1) : imageUrl;
    }
    // 대표이미지 제외 이미지 삭제
    private void deleteFilesExceptMain(File dir, String mainFileName) {
        if (dir == null || !dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                deleteFilesExceptMain(file, mainFileName);
                File[] innerFiles = file.listFiles();
                if (innerFiles == null || innerFiles.length == 0) {
                    file.delete();
                }
            } else {
                if (mainFileName != null && file.getName().equals(mainFileName)) {
                    continue; // 대표이미지는 삭제 안 함
                }
                if (!file.delete()) {
                    throw new RuntimeException("파일 삭제 실패: " + file.getAbsolutePath());
                }
            }
        }
    }

    // 이미지 전체삭제
    public void delete(ProductImageDto.ProductImageDeleteReq dto) {
        File dir = new File(uploadPath, String.valueOf(dto.getPRODUCT_ID()));
        deleteDirectory(dir);
        // mapper 연결 주석 처리 -> 게시글 삭제 쿼리 안에서 sp 호출
        // productImageMapper.delete(dto);
    }
    // 이미지 삭제 및 폴더 삭제
    private void deleteDirectory(File dir) {
        if (dir == null || !dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    if (!file.delete()) {
                        throw new RuntimeException("파일 삭제 실패: " + file.getAbsolutePath());
                    }
                }
            }
        }
        if (!dir.delete()) {
            throw new RuntimeException("폴더 삭제 실패: " + dir.getAbsolutePath());
        }
    }
}
