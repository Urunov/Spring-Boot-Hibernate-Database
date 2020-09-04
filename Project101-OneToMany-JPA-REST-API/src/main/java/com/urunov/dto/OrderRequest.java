package com.urunov.dto;

import com.urunov.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: apple
 * @created on 03/09/2020
 * @Project is OneToMany
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private Customer customer;
}
