package com.doapp.nanogear.controller.admin;

import com.doapp.nanogear.entity.Banner;
import com.doapp.nanogear.entity.Product;
import com.doapp.nanogear.repository.BannerRepository;
import com.doapp.nanogear.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class BannerHomeController {

    @Autowired
    ServletContext app;

    @Autowired
    BannerService bannerService;

    @Autowired
    BannerRepository bannerRepository;

    @GetMapping("/edit_banner")
    public String editBanner(Model model) {
        model.addAttribute("listImg", bannerService.getAll());
        return "edit_banner";
    }

    @PostMapping("/save-banner")
    public String saveBanner(@RequestParam("id") int id, @RequestParam("newImage") MultipartFile newImage, RedirectAttributes model) {
//        bannerService.updateBannerById(ids,newImages);
        try {
            Banner banner = bannerService.findById(id);
            deleteOldImages(banner);
            MultipartFile newImage1 = newImage;
            String filename1 = newImage1.getOriginalFilename();
            File file = new File(app.getRealPath("/image/" + filename1));
            newImage1.transferTo(file);
            banner.setImgUrl(filename1);
            bannerService.saveBanner(banner);
            model.addFlashAttribute("success", "thay ảnh banner thành công");
//            model.addFlashAttribute("listImg", bannerService.getAll());
            return "redirect:/admin/edit_banner";
        } catch (Exception e) {
            model.addFlashAttribute("success", "Có lỗi xảy ra khi lưu ảnh banner, vui lòng chọn và lưu lại !");
            return "redirect:/admin/edit_banner";
        }
//        model.addFlashAttribute("success","thay ảnh banner thành công");
//        return "redirect:/admin/edit_banner";
    }
    private void deleteOldImages(Banner banner) {
        if (banner != null) {
            if (banner != null && banner.getImgUrl() != null) {
                String oldImageNames = banner.getImgUrl();
                    File oldImageFile = new File(app.getRealPath("/image/" + oldImageNames));
                    if (oldImageFile.exists()) {
                        oldImageFile.delete();
                }
            }
        }
    }
}


//        for (int i = 0; i < ids.size(); i++) {
//            int idImg = ids.get(i);
//            MultipartFile newImage = newImages.get(i);
//            String filename = newImage.getOriginalFilename();
//            File file = new File(app.getRealPath("/image/"+filename));
//            newImage.transferTo(file);
//            Banner banner = bannerRepository.findById(idImg);
//            banner.setImgUrl(filename);
//            bannerRepository.save(banner);
//        }