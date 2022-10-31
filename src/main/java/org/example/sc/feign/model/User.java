package org.example.sc.feign.model;

import java.util.List;
import lombok.Data;

/**
 * @author zhengshijun
 * @date 2022/10/31.
 */
@Data
public class User {

    private List<String> urls;

    private String username;

    private Integer age;
}
