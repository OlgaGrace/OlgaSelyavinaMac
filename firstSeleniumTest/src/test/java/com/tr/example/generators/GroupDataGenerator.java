package com.tr.example.generators;

import com.tr.example.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
    public static void main(String[] arg) throws IOException {
        int count = Integer.parseInt(arg[0]);
        File file = new File(arg[1]);

        List<GroupData> groups = generateGroups(count);
        save(groups, file);

    }

    private static void save(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group: groups){
            writer.write(String.format("%s;%s;%s\n",
                    group.getName(),
                    group.getHeader(),
                    group.getFooter()));
        }
        writer.close();

    }

    private static List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i=0; i<count; i++){
            groups.add(new GroupData()
                    .withName(String.format("name %s", i))
                    .withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));

        }
        return groups;
    }

}
