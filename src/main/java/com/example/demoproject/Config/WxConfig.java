package com.example.demoproject.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource("classpath:pay.properties")
public class WxConfig implements Serializable {
    @Value("${wx.appid}")
    private String APPID;

    @Value("${wx.secret}")
    private String SECRET;

    @Value("${wx.mch_id}")
    private String MCH_ID;

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getSECRET() {
        return SECRET;
    }

    public void setSECRET(String SECRET) {
        this.SECRET = SECRET;
    }

    public String getMCH_ID() {
        return MCH_ID;
    }

    public void setMCH_ID(String MCH_ID) {
        this.MCH_ID = MCH_ID;
    }

    @Override
    public String toString() {
        return "WxConfig{" +
                "APPID='" + APPID + '\'' +
                ", SECRET='" + SECRET + '\'' +
                ", MCH_ID='" + MCH_ID + '\'' +
                '}';
    }
}
