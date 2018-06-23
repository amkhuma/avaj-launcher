find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java simulation.weather.Main scenario.txt