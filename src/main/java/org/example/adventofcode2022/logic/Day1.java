package org.example.adventofcode2022.logic;


import org.example.adventofcode2022.models.ElfInventory;
import org.example.utils.IOUtil;
import org.example.adventofcode2022.utils.MigrationUtil;
import org.example.adventofcode2022.utils.Util;

import java.util.List;

import static org.example.utils.Constant.generalPath;

public class Day1 {

    public static void main(String[] args) {
        try {
            String filePath = generalPath + "Day1";
            List<String> list = IOUtil.readFileIntoList(filePath);

            if (list == null) {
                System.out.println("Can't read from the file");
            } else {
                List<ElfInventory> elfInventoryList = MigrationUtil.migrateDay1(list);

                Integer max = Util.findMax(elfInventoryList, 1);
                Integer max3 = Util.findMax(elfInventoryList, 3);

                System.out.println("max is = " + max);
                System.out.println("max3 is = " + max3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}