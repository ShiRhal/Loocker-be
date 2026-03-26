package com.locker.be.product.service;

import com.locker.be.product.dto.ProductDto;
import com.locker.be.product.dto.ProductImageDto;
import com.locker.be.product.dto.ProductImageQueryDto;
import com.locker.be.product.dto.ProductQueryDto;
import com.locker.be.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductImageService productImageService;

    public Long create(ProductDto.ProductDetailCreateReq dto) {
        productMapper.create(dto);
        Long productId = dto.getNewID();

        ProductImageDto.ProductImageCreateReq imageDto = new ProductImageDto.ProductImageCreateReq();
        imageDto.setPRODUCT_ID(productId);
        imageDto.setFiles(dto.getFiles());

        productImageService.saveImages(imageDto);
        return productId;
    }

    public void update(ProductDto.ProductDetailUpdateReq dto) {
        Long productId = dto.getPRODUCT_ID();

        // 이미지 전체 삭제 [대표이미지 제외]
        ProductImageQueryDto.ProductPriImageReq imagePriDto = new ProductImageQueryDto.ProductPriImageReq();
        ProductImageDto.ProductImageDeleteReq imageDeleteDto = new ProductImageDto.ProductImageDeleteReq();
        imagePriDto.setPRODUCT_ID(productId);
        imageDeleteDto.setPRODUCT_ID(productId);
        productImageService.deleteForUpdate(imageDeleteDto, imagePriDto);

        // 게시글 업데이트
        productMapper.update(dto);

        // 이미지 신규 저장
        ProductImageDto.ProductImageCreateReq imageDto = new ProductImageDto.ProductImageCreateReq();
        imageDto.setPRODUCT_ID(productId);
        imageDto.setFiles(dto.getFiles());
        productImageService.saveImages(imageDto);
    }

    public void delete(ProductDto.ProductDetailDeleteReq dto) {
        ProductImageDto.ProductImageDeleteReq imageDeleteReq = new ProductImageDto.ProductImageDeleteReq();
        imageDeleteReq.setPRODUCT_ID(dto.getPRODUCT_ID());
        productImageService.delete(imageDeleteReq);
        productMapper.delete(dto);
    }

    // @Transactional(readOnly = true)
    public Collection<ProductQueryDto.ProductDetailRes> findOne(ProductQueryDto.ProductDetailReq dto) {
        Collection<ProductQueryDto.ProductDetailRes> result = productMapper.findOne(dto);

        ProductImageQueryDto.ProductImageReq imageReq = new ProductImageQueryDto.ProductImageReq();
        imageReq.setPRODUCT_ID(dto.getPRODUCT_ID());

        Collection<ProductImageQueryDto.ProductImageRes> images = productImageService.findAll(imageReq);

        for (ProductQueryDto.ProductDetailRes item : result) {
            item.setIMAGE(images);
        }

        return result;
    }

    // @Transactional(readOnly = true)
    public ProductQueryDto.ProductAllRes findAll(ProductQueryDto.ProductReq dto) {
        Collection<ProductQueryDto.ProductRes> productList = productMapper.findAll(dto);
        ProductQueryDto.ProductPriceStatusRes priceStatus = productMapper.findPriceStatus(dto);

        ProductQueryDto.ProductAllRes res = new ProductQueryDto.ProductAllRes();
        res.setPRODUCT_LIST(productList);
        res.setPRICE_STATUS(priceStatus);

        return res;
    }
}
