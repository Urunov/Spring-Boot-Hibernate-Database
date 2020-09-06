package com.urunov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {

    private String name;
    private String productName;


}
