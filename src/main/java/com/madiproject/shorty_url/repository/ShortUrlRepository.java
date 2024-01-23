package com.madiproject.shorty_url.repository;

import com.madiproject.shorty_url.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {
    ShortUrlEntity findByKey(String key);
    ShortUrlEntity findByFullUrl(String fullUrl);
}
