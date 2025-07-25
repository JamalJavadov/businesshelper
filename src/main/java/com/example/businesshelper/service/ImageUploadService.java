package com.example.businesshelper.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.businesshelper.model.entity.Product;
import com.example.businesshelper.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageUploadService {
    private final Cloudinary cloudinary;
    private final ProductRepository productRepository;

    public String uploadImageMeal(MultipartFile file, long id) {
        String contentType = file.getContentType();
        if (contentType == null || (!contentType.equals("image/png") && !contentType.equals("image/jpeg"))) {
            throw new IllegalArgumentException("Yalnız PNG və JPEG formatlı şəkillər yükləyə bilərsiniz.");
        }

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            // 2. İstifadəçi və ya aşpaz obyektini tap və şəkil yolunu yenilə
            Optional<Product> product = productRepository.findById(id);

            String imageUrl = uploadResult.get("secure_url").toString();

            if (product.isPresent()) {
                product.get().setImageUrl(imageUrl);
                productRepository.save(product.get());
            }
            return imageUrl;

        } catch (IOException e) {
            // Şəkil yüklənərkən baş verən IO xətalarını idarə et
            throw new RuntimeException("Şəkil yüklənərkən daxili xəta baş verdi.", e);
        }
    }
}