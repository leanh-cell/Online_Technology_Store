package com.doapp.nanogear.service.serviceImpl;

import com.doapp.nanogear.entity.Banner;
import com.doapp.nanogear.repository.BannerRepository;
import com.doapp.nanogear.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    ServletContext app;

    @Autowired
    BannerRepository bannerRepository;

    @Override
    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Banner findById(int id){
       return bannerRepository.findById(id);
    }

    @Override
    public void saveBanner(Banner banner){
        bannerRepository.save(banner);
    }
    @Override
    public void updateBannerById(List<Integer> idImg, List<MultipartFile> newImages){
        try {
            for (int i = 0; i < idImg.size(); i++) {
                int id = idImg.get(i);
                Banner banner = bannerRepository.findById(id);
                MultipartFile newImage = newImages.get(i);
                String filename = newImage.getOriginalFilename();
                File file = new File(app.getRealPath("/image/" + filename));
                newImage.transferTo(file);
                banner.setImgUrl(filename);
                bannerRepository.save(banner);
            }
        } catch (Exception e) {

        }
    }
}
