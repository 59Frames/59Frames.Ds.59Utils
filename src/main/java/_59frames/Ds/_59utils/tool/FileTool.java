package _59frames.Ds._59utils.tool;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class FileTool {

    @NotNull
    public static String getFileExtension(String fileName) {
        char ch;
        int len;
        if(fileName==null ||
                (len = fileName.length())==0 ||
                (ch = fileName.charAt(len-1))=='/' || ch=='\\' || //in the case of a directory
                ch=='.' ) //in the case of . or ..
            return "";
        int dotInd = fileName.lastIndexOf('.'),
                sepInd = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
        if( dotInd<=sepInd )
            return "";
        else
            return fileName.substring(dotInd+1).toLowerCase();
    }

    @NotNull
    public static String getFileExtension(@NotNull File file) {
        return getFileExtension(file.getName());
    }
}
