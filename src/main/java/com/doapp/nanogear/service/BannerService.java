package com.doapp.nanogear.service;

import com.doapp.nanogear.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BannerService {
    List<Banner> getAll();

    Banner findById(int id);

    void saveBanner(Banner banner);

    void updateBannerById(List<Integer> idImg,List<MultipartFile> newImages);
}
