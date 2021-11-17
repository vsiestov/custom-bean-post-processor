package com.vsi.custombeanpostprocessor.service;

import com.vsi.custombeanpostprocessor.annotation.Trimmed;
import org.springframework.stereotype.Service;

@Trimmed
@Service
public class AppService {
    public void printTrimmedValue(String value) {
        System.out.println(value);
    }

    public String getTrimmedValue() {
        return "    this string should not include any spaces around    ";
    }
}
