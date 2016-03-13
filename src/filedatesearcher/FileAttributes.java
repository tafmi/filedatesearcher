
package filedatesearcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {
    
    private final String creationTime;
    private final String modificationTime;
    
    public FileAttributes(File file) throws IOException{
        Path filepath=file.toPath();
        BasicFileAttributes attributes=Files.readAttributes(filepath, BasicFileAttributes.class);
        creationTime=attributes.creationTime().toString();
        modificationTime=attributes.lastModifiedTime().toString();
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getModificationTime() {
        return modificationTime;
    }
    
}
