package com.usa.ciclo3.reto5.custom;

import com.usa.ciclo3.reto5.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    
    private Long total;
    private Client client;
    
}
