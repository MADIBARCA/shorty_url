package com.madiproject.shorty_url.service;

import com.madiproject.shorty_url.dto.ShortUrlRequest;
import com.madiproject.shorty_url.dto.ShortUrlResponse;
import com.madiproject.shorty_url.entity.ShortUrlEntity;
import com.madiproject.shorty_url.repository.ShortUrlRepository;
import com.madiproject.shorty_url.util.ShortUrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortUrlRepository repository;
    private final ShortUrlUtil util;

    public ShortUrlResponse createShortUrl(ShortUrlRequest request) {
        String fullUrl = request.getUrl();

        ShortUrlEntity existingShortUrl = repository.findByFullUrl(fullUrl);

        if (existingShortUrl != null) {
            return ShortUrlResponse.builder().key(existingShortUrl.getKey()).build();
        } else {
            String newKey = util.generateUniqueKey();
            ShortUrlEntity newEntity = ShortUrlEntity.builder()
                    .key(newKey).fullUrl(fullUrl).clickCount(0L)
                    .build();
            repository.save(newEntity);
            return ShortUrlResponse.builder().key(newKey).build();
        }
    }

    public RedirectView getFullUrl(String key) {
        ShortUrlEntity entityInDb = repository.findByKey(key);

        if (entityInDb != null) {
            entityInDb.setClickCount(entityInDb.getClickCount() + 1);
            repository.save(entityInDb);
            return new RedirectView(entityInDb.getFullUrl());
        } else {
            // Handle the case where the key is not found
            // You may throw an exception or return an appropriate response
            return new RedirectView("/not-found");
        }
    }
}
