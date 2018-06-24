find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java launcher.main.Main scenario.txt
