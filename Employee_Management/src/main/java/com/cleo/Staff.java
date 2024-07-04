package com.cleo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Staff {
    /*
    {"firstName":"Magda",
  "lastName":"Iovan",
  "monthlyIncome":920,
  "nbHoursPerWeek":20
}
     */

   private String firstName;

   private String lastName;
   private int monthlyIncome;
   private int nbHoursPerWeek;


}
