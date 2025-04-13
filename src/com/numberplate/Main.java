package com.numberplate;

import com.numberplate.service.NumberPlateService;

public class Main {
    public static void main(String[] args) {
        NumberPlateService numberPlateService = new NumberPlateService();

        numberPlateService.generateUniqueNumberPlate("YC", "04/07/2019");
        numberPlateService.generateUniqueNumberPlate("LT", "23/01/2003");
        numberPlateService.generateUniqueNumberPlate("FF", "30/05/2032");
    }
}
