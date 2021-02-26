package com.cskt.historl.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutoLoginModel implements Serializable {
    private String code;
}
