package com.doapp.nanogear.security;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class AddImage {
    private static final String UPLOAD_PRD = "src/main/resources/static/images/products"; // Đường dẫn đến thư mục images
    private static final String UPLOAD_U = "src/main/resources/static/images/users";
    public void uploadImagePrd(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Lấy tên tệp
                String fileName = file.getOriginalFilename();

                // Tạo đường dẫn đến thư mục lưu trữ tệp
                Path path = Paths.get(UPLOAD_PRD + fileName);

                // Lưu tệp vào thư mục images
                file.transferTo(path.toFile());

                // Thành công, tệp đã được lưu trữ tại đường dẫn UPLOAD_DIR + fileName
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi
            }
        }
    }

    public void uploadImageU(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Lấy tên tệp
                String fileName = file.getOriginalFilename();

                // Tạo đường dẫn đến thư mục lưu trữ tệp
                Path path = Paths.get(UPLOAD_U + fileName);

                // Lưu tệp vào thư mục images
                file.transferTo(path.toFile());

                // Thành công, tệp đã được lưu trữ tại đường dẫn UPLOAD_DIR + fileName
            } catch (IOException e) {
                e.printStackTrace();
                // Xử lý lỗi
            }
        }
    }
}
