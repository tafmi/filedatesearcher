
package filedatesearcher;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSearcher {
    
    private final File directory;
    private final FileDate date;
    private final int field;
    private final HashMap <String,FileDate> before;
    private final HashMap <String,FileDate> after;
    private final HashMap <String,FileDate> same;
    
    
    public FileSearcher(File directory, FileDate date,int field){ 
        this.directory=directory;
        this.date=date;
        this.field=field;
        before=new HashMap<>();
        after=new HashMap<>();
        same=new HashMap<>();
    }
   
    public void start() throws IOException{
        File[] files=directory.listFiles();
        if(files.length==0){
            System.out.println("The directory you specified is empty.");
            return;        
        }
        else{
            processDirectory(directory);// process the input directory
            printResults();
        }
        
    }
    
    private void processDirectory(File directory) throws IOException{
        
        File[] files=directory.listFiles();
        for(File f:files){
            if(f.isDirectory()){
               processDirectory(f);
            }
            else{
                processFile(f);//process the file
            }
        }  
    }
    
    private void processFile(File file) throws IOException{
        
        FileAttributes attributes=new FileAttributes(file);
        String time;
        if(field==1){
           time=attributes.getCreationTime().substring(0, 10);// gets file's creation date
        }
        else{
           time=attributes.getModificationTime().substring(0, 10);// gets file's last modification date
        }
        FileDate fileDate=createFileDate(time);
		//compares file's date with input date
        if(date.compareTo(fileDate)==0){
           same.put(file.getCanonicalPath(),fileDate);
        }
        else if(date.compareTo(fileDate)==1){
            before.put(file.getCanonicalPath(),fileDate);
        }
        else{
            after.put(file.getCanonicalPath(),fileDate);
        }
    }
    
    private FileDate createFileDate(String date){
        String[] dateArray=date.split("-");
        String newdate=dateArray[2]+"-"+dateArray[1]+"-"+dateArray[0];
        FileDate filedate=new FileDate(newdate) {};
        filedate.isValid();
        return filedate;
    }
    
    private void printResults(){
        String s;
        if(field==1){
          s="created";  
        }
        else{
          s="modified";
        }
        if(!before.isEmpty()){
           System.out.println("Files "+s+" before "+date.toString()+" :"); //prints files before input date
            for (Map.Entry pair : before.entrySet()) {
                System.out.println(pair.getKey()+" "+pair.getValue());
            }
        }
        if(!same.isEmpty()){
           System.out.println("Files "+s+" in "+date.toString()+" :"); //prints files in input date
           for (Map.Entry pair : same.entrySet()) {
                System.out.println(pair.getKey()+" in ["+pair.getValue()+"]");
            }
        }
        if(!after.isEmpty()){
           System.out.println("Files "+s+" after "+date.toString()+" :"); //prints files after input date
           for (Map.Entry pair : after.entrySet()) {
                System.out.println(pair.getKey()+" in ["+pair.getValue()+"]");
            }
        }
    }
}
