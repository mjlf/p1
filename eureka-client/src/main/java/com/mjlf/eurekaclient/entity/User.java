package com.mjlf.eurekaclient.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

/**
 * @ClassName User
 * @Author mjlft
 * @Date 2020/8/23 17:51
 * @Version 1.0
 * @Description TODO
 */
@Data
@Validated
public class User {
    @Length(min = 4)
    private String name;
}
