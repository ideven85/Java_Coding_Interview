package com.cleo.shop.domain;

import lombok.*;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Battery extends Product{

    private boolean rechargeable;
    private int voltage;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battery b= (Battery) o;

        return true;
    }


}
