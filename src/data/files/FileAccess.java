/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.files;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FileAccess {

    private static final String SYSPATH = (new File("").getAbsolutePath());
    private String filename;

    public FileAccess() {
    }

    public FileAccess(String filename) {
        this.filename = SYSPATH + "/src/data/files" + filename;
    }

    public List<String> readFile() throws Exception {
        List<String> data = Files.readAllLines(new File(filename).toPath(), Charset.forName("utf-8"));
        return data;
    }

    public boolean writeFile(List<String> data) throws Exception {
        Files.write(new File(filename).toPath(), data, Charset.forName("utf-8"));
        return true;
    }
}
