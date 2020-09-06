package com.urunov.dto;

import com.urunov.model.Customer;
import lombok.*;

/**
 * @Author: apple
 * @created on 06/09/2020
 * @Project is GraphQL-OneToMany
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class OrderRequest {

    private Customer customer;
}
