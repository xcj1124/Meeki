package xaau.xcj.Curriculum.resource.management.unit;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @auther: Meeki
 * @data: 2019/5/27 17:33
 * @message:
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
