package com.fulihui.redisdubbo.demo.producer.model;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by SSM on 2017/4/6 0006.
 */
@Setter
@Getter
public class TemplateItem extends ToString {
    private String value;
}