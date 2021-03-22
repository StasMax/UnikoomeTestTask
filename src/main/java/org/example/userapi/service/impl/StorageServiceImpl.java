package org.example.userapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.userapi.service.StorageService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    /**
     * Имитация отправки файла в хранилище
     * @param uploadFile загруженный файл
     * @param key ключ файла
     * @return ссылка на файл
     */
    @Override
    public String uploadFile(InputStream uploadFile, String key) {

        log.info("Файл с ключом: " + key + " упешно отправлен в хранилище");
        List<String> images = Arrays.asList(
                "https://bipbap.ru/wp-content/uploads/2015/02/1496408549_pixmafia_20170602_000348_045.jpg",
                "https://i2.wp.com/intrigue.dating/wp-content/uploads/2020/08/images_005613_035.jpg?resize=750%2C937&ssl=1",
                "https://i09.fotocdn.net/s121/f177c04484ef1771/public_pin_l/2770307786.jpg",
                "https://im0-tub-ru.yandex.net/i?id=7eb9cca711d3c85aed2ea18940555f66-l&ref=rim&n=13&w=1080&h=1350",
                "https://favera.ru/img/2016/12/02/1414040_1480630800.jpg",
                "https://shnyagi.net/uploads/pic/2015/09-21/krasotki_26.jpg",
                "https://cs11.pikabu.ru/post_img/2018/11/06/10/154152281917169480.jpg",
                "https://pixmafia.com/post/2020/09/006762/images_006762_032.jpg",
                "https://cdn-nus-1.pinme.ru/tumb/600/photo/86/1ce2/861ce25af1bd2ac1dcad76e850828fc7.png",
                "https://i.pinimg.com/originals/2c/14/4e/2c144e6fc07e8bdb13e59a6c30491e30.jpg");
        return images.get(new Random().nextInt(images.size()));
    }

}
