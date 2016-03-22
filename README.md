# filedatesearcher
## features
This project searches the files of a directory and prints them depending on the input date.

The user is asked to type the directory, the date and the field to be searched (creation time or last 

modification time). The application prints the files that were created/modified before, after and in the given 

date.
##usage
in windows cmd:

cd path\to\filedatesearcher 
#### compile

path\to\filedatesearcher>javac -d bin -sourcepath src src/filedatesearcher/FileDateSearcher.java
#### run

path\to\filedatesearcher>java -cp bin filedatesearcher.FileDateSearcher
