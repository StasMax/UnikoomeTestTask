package org.example.userapi.service;

import java.io.InputStream;

public interface StorageService {

    String uploadFile(InputStream uploadFile, String key);

}
