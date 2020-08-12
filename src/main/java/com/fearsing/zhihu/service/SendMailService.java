package com.fearsing.zhihu.service;

import java.io.File;
import java.util.List;

public interface SendMailService {
    void sendSimpleMail(String to, String title, String content);
    void sendAttachmentsMail(String to, String title, String content, List<File> fileList);
}
